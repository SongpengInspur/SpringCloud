package com.gettop.configclient.business.dao;

import com.gettop.configclient.business.model.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GatewayRouteDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GatewayRoute record);

    int insertSelective(GatewayRoute record);

    GatewayRoute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatewayRoute record);

    int updateByPrimaryKey(GatewayRoute record);
}