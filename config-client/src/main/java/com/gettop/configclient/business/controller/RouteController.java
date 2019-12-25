package com.gettop.configclient.business.controller;

import com.gettop.configclient.business.model.GatewayRoute;
import com.gettop.configclient.business.service.GatewayRouteService;
import com.gettop.configclient.common.GatewayRouteDto;
import com.gettop.configclient.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private GatewayRouteService gatewayRouteService;
    @Autowired
    private TestService testService;

    /**
     * 刷新路由配置
     *
     * @param
     * @return
     */
    /*@GetMapping("/refresh")
    public String refresh() throws Exception {
        return this.gatewayServiceHandler.loadRouteConfig();
    }*/

    @RequestMapping(value = "/worldsss")
    public String refresh() throws Exception {
       /* Test test = testService.getById(1);
        System.out.println(test.getName());*/
        GatewayRoute gr = this.gatewayRouteService.selectById(1);
        System.out.println(gr.getPredicates());
        return gr.getPredicates();
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
        //gatewayServiceHandler.loadRouteConfig();
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestBody GatewayRouteDto gatewayRouteDto) throws Exception {
        gatewayRouteService.update(gatewayRouteDto);
        //gatewayServiceHandler.loadRouteConfig();
        return "success";
    }

    @GetMapping("/delete")
    public String delete(@PathVariable int id) throws Exception {
        gatewayRouteService.delete(id);
        //gatewayServiceHandler.deleteRoute(id);
        return "success";
    }



}