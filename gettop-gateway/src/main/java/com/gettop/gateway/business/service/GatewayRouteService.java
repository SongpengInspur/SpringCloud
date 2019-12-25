package com.gettop.gateway.business.service;


import com.gettop.gateway.business.dao.GatewayRouteDao;
import com.gettop.gateway.business.model.GatewayRoute;
import com.gettop.gateway.business.model.GatewayRouteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GatewayRouteService {

    @Autowired
    private GatewayRouteDao gatewayRouteDao;

    public Integer add(GatewayRouteDTO gatewayRouteDto) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(gatewayRouteDto, gatewayRoute);
        gatewayRoute.setCreatedate(new Date());
        gatewayRoute.setCreatorid(1);
        return gatewayRouteDao.insertSelective(gatewayRoute);
    }

    public Integer update(GatewayRouteDTO gatewayRouteDto) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(gatewayRouteDto, gatewayRoute);
        gatewayRoute.setUpdatedate(new Date());
        gatewayRoute.setUpdateid(1);
        return gatewayRouteDao.updateByPrimaryKeySelective(gatewayRoute);
    }

    public Integer delete(int id) {
        return gatewayRouteDao.deleteByPrimaryKey(id);
    }

    public List<GatewayRoute> getAllRoutes() {
        return gatewayRouteDao.queryAllRoutes();
    }

}