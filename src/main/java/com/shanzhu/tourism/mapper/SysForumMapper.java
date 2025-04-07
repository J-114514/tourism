package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.tourism.domain.SysForum;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysForumMapper extends BaseMapper<SysForum> {
    // 分页查询
    @Select("<script> SELECT * FROM sys_forum " +
            "<where> " +
            "   <if test='title != null'>" +
            "    AND title LIKE CONCAT('%', #{title}, '%')</if>" +
            "</where>" +
            "</script>")
    IPage<SysForum> selectPageVo(Page<SysForum> page, @Param("title") String title);

    // 根据 ID 获取资讯
    @Select("SELECT * FROM sys_forum WHERE id = #{id}")
    SysForum selectSysForumById(@Param("id") String id);

    // 添加资讯
    @Insert("INSERT INTO sys_forum (id,title, content, create_time) VALUES (#{id},#{title}, #{content}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSysForum(SysForum sysForum);

    // 编辑资讯
    @Update("UPDATE sys_forum SET title = #{title}, content = #{content}, update_time = NOW()" +
            "WHERE id = #{id}")
    int updateSysForumById(@Param("id") String id, @Param("title") String title, @Param("content") String content);

    // 根据 ID 删除资讯
    @Delete("DELETE FROM sys_forum WHERE id = #{id}")
    int deleteSysForumById(String id);
}
