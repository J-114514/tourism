package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysFavor;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysFavorMapper extends BaseMapper<SysFavor> {
    @Select("SELECT f.*, l.* FROM sys_favor f " +
            "LEFT JOIN sys_line l ON f.line_id = l.id " +
            "WHERE f.user_id = #{userId}")
    @Results({
            @Result(property = "id", column = "f.id"),
            @Result(property = "userId", column = "f.user_id"),
            @Result(property = "lineId", column = "f.line_id"),
            // 映射 sys_line 表的字段到 FavorWithLineDTO 对象
            @Result(property = "lineData", column = "line_id",
                    one = @One(select = "com.example.mapper.SysLineMapper.selectById"))
    })
    List<SysFavor> selectById(String id);

    @Insert("INSERT INTO sys_favor( line_id, user_id) " +
            "VALUES( #{lineId}, #{userId})")
    int insertFavor(SysFavor favor);
    @Delete("DELETE FROM sys_favor " +
            "WHERE line_id = #{lineId} ")
    int deleteById(@Param("lineId") String lineId);

    @Update("UPDATE sys_favor SET line_id = #{lineId} and user_id=#{userId}" +
            "WHERE id = #{id} " )
    int update( SysFavor favor);

}
