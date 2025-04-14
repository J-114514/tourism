package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysHotelItem;
import org.apache.ibatis.annotations.*;

public interface SysHotelItemMapper extends BaseMapper<SysHotelItem> {
    @Select("SELECT * FROM sys_hotel_item WHERE id = #{id}")
    SysHotelItem selectSysHotelItemById(@Param("id") String id);

    // 添加资讯
    @Insert("INSERT INTO sys_hotel_item (id,hotel_id,price,num,) VALUES (#{id},#{hotel_id},#{name},#{price},#{num})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSysHotelItem(SysHotelItem sysHotelItem);

    // 编辑资讯
    @Update("UPDATE sys_hotel_item SET name = #{name}, price = #{price},num = #{num}" +
            "WHERE id = #{id}")
    int updateSysHotelItemById(SysHotelItem sysHotelItem);

    // 根据 ID 删除酒店
    @Delete("DELETE FROM sys_hotel_item WHERE id = #{id}")
    int deleteSysHotelItemById(String id);

}