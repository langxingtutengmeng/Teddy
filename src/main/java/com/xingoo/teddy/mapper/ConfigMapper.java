package com.xingoo.teddy.mapper;

import com.xingoo.teddy.entity.Config;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ConfigMapper {

    @Select("select count(1) from config")
    Integer count() throws Exception;

    @Update("create table config(" +
            "id generated by default as identity," +
            "settings       VARCHAR(3000)," +
            "clazz          VARCHAR(500)," +
            "jars           VARCHAR(3000)," +
            "jar            VARCHAR(500)," +
            "args           VARCHAR(3000)," +
            "modify_time    TIMESTAMP default CURRENT_TIMESTAMP," +
            "primary key (id))")
    void create();

    @Insert("insert into config(settings,clazz,jars,jar,args) values(#{c.settings},#{c.clazz},#{c.jars},#{c.jar},#{c.args})")
    Long insert(@Param("c") Config config);
}