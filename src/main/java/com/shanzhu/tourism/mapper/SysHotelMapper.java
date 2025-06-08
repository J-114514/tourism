package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysHotel;
import org.apache.ibatis.annotations.*;

public interface SysHotelMapper extends BaseMapper<SysHotel> {
    // 根据 ID 获取酒店
    @Select("SELECT * FROM sys_hotel WHERE id = #{id}")
    SysHotel selectSysHotelById(@Param("id") String id);

    // 添加资讯
    @Insert("INSERT INTO sys_hotel (id,attractions_id,attractions,name,address,introduce,images,state,create_by,create_time,update_by,update_time) VALUES (#{id},#{attractions_id},#{attractions},#{name},#{address},#{introduce},#{images},#{state},#{createBy},NOW(),#{updateTy}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSysHotel(SysHotel sysHotel);

    // 编辑资讯
    @Update("UPDATE sys_hotel SET name = #{name}, introduce = #{introduce},images = #{image},state = #{state},update_time = NOW()" +
            "WHERE id = #{id}")
    int updateSysHotelById(SysHotel sysHotel);

    // 根据 ID 删除酒店
    @Delete("DELETE FROM sys_hotel WHERE id = #{id}")
    int deleteSysHotelById(String id);
}
