package com.gettop.schedule.task.dao;

import com.gettop.schedule.task.model.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

}