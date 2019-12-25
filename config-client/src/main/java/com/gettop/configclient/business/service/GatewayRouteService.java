package com.gettop.configclient.business.service;


import com.gettop.configclient.business.dao.GatewayRouteDao;
import com.gettop.configclient.business.model.GatewayRoute;
import com.gettop.configclient.common.GatewayRouteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GatewayRouteService {

    @Autowired
    private GatewayRouteDao gatewayRouteDao;

    public Integer add(GatewayRouteDto gatewayRouteDto) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(gatewayRouteDto, gatewayRoute);
        gatewayRoute.setCreatedate(new Date());
        gatewayRoute.setCreatorid(1);
        return gatewayRouteDao.insertSelective(gatewayRoute);
    }

    public Integer update(GatewayRouteDto gatewayRouteDto) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(gatewayRouteDto, gatewayRoute);
        gatewayRoute.setUpdatedate(new Date());
        gatewayRoute.setUpdateid(1);
        return gatewayRouteDao.updateByPrimaryKeySelective(gatewayRoute);
    }

    public Integer delete(int id) {
        return gatewayRouteDao.deleteByPrimaryKey(id);
    }

    //add by songpeng for test
    public GatewayRoute selectById(int id) {
        return gatewayRouteDao.selectByPrimaryKey(id);
    }

}