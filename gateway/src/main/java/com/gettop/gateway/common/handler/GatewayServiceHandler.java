package com.gettop.gateway.common.handler;

import com.gettop.gateway.business.dao.GatewayRouteDao;
import com.gettop.gateway.business.model.GatewayRoute;
import com.gettop.gateway.common.cache.RedisRouteDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;

@Service
public class GatewayServiceHandler implements ApplicationEventPublisherAware, CommandLineRunner {
    @Autowired
    private RedisRouteDefinitionRepository routeDefinitionWriter;
    private ApplicationEventPublisher publisher;

    //自己的获取数据dao
    @Autowired
    private GatewayRouteDao gatewayRouteDao;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public void run(String... args){
        this.loadRouteConfig();
    }

    public String loadRouteConfig() {
        List<GatewayRoute> gatewayRouteList = new ArrayList<>();
        //从数据库拿到路由配置
        GatewayRoute gr = gatewayRouteDao.selectByPrimaryKey(1);
        gatewayRouteList.add(gr);

        //log.info("网关配置信息：=====>"+ JSON.toJSONString(gatewayRouteList));
        gatewayRouteList.forEach(gatewayRoute -> {
            RouteDefinition definition = new RouteDefinition();
            Map<String, String> predicateParams = new HashMap<>(8);
            PredicateDefinition predicate = new PredicateDefinition();
            FilterDefinition filterDefinition = new FilterDefinition();
            Map<String, String> filterParams = new HashMap<>(8);

            URI uri = null;
            if(gatewayRoute.getUri().startsWith("http")){
                //http地址
                uri = UriComponentsBuilder.fromHttpUrl(gatewayRoute.getUri()).build().toUri();
            }else{
                //注册中心
                uri = UriComponentsBuilder.fromUriString("lb://"+gatewayRoute.getUri()).build().toUri();
            }

            definition.setId(gatewayRoute.getId().toString());
            // 名称是固定的，spring gateway会根据名称找对应的PredicateFactory
            predicate.setName("Path");
            predicateParams.put("pattern",gatewayRoute.getPredicates());
            predicate.setArgs(predicateParams);

            // 名称是固定的, 路径去前缀
            filterDefinition.setName("StripPrefix");
            filterParams.put("_genkey_0", gatewayRoute.getFilters().toString());
            filterDefinition.setArgs(filterParams);

            definition.setPredicates(Arrays.asList(predicate));
            definition.setFilters(Arrays.asList(filterDefinition));
            definition.setUri(uri);
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        });

        this.publisher.publishEvent(new RefreshRoutesEvent(this));
        return "success";
    }


    public void deleteRoute(int routeId){
        routeDefinitionWriter.delete(Mono.just(routeId+"")).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }
}

