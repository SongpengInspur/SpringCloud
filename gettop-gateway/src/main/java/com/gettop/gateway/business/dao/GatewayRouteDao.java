package com.gettop.gateway.business.dao;

import com.gettop.gateway.business.model.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GatewayRouteDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GatewayRoute record);

    int insertSelective(GatewayRoute record);

    GatewayRoute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatewayRoute record);

    int updateByPrimaryKey(GatewayRoute record);

    List<GatewayRoute> queryAllRoutes();
}