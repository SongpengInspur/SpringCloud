package com.gettop.gateway.business.controller;

import com.gettop.gateway.common.GatewayRouteDto;
import com.gettop.gateway.business.service.GatewayRouteService;
import com.gettop.gateway.common.handler.GatewayServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private GatewayServiceHandler gatewayServiceHandler;


    @Autowired
    private GatewayRouteService gatewayRouteService;

    /**
     * 刷新路由配置
     *
     * @param
     * @return
     */
    @GetMapping("/refresh")
    public String refresh() throws Exception {
        return this.gatewayServiceHandler.loadRouteConfig();
    }

    /**
     * 增加路由记录
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestBody GatewayRouteDto gatewayRouteDto) throws Exception {
        gatewayRouteService.add(gatewayRouteDto);
        gatewayServiceHandler.loadRouteConfig();
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestBody GatewayRouteDto gatewayRouteDto) throws Exception {
        gatewayRouteService.update(gatewayRouteDto);
        gatewayServiceHandler.loadRouteConfig();
        return "success";
    }

    @GetMapping("/delete")
    public String delete(@PathVariable int id) throws Exception {
        gatewayRouteService.delete(id);
        gatewayServiceHandler.deleteRoute(id);
        return "success";
    }

}