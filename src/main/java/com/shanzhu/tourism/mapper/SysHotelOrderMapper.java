package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysHotelOrder;
import org.apache.ibatis.annotations.*;

public interface SysHotelOrderMapper extends BaseMapper<SysHotelOrder> {
    @Select("SELECT * FROM sys_hotel_order WHERE id = #{id}")
    SysHotelOrder selectSysHotelOrderById(@Param("id") String id);

    // 添加预约信息
    @Insert("INSERT INTO sys_hotel_order (id,home_id,name,introduce,image,num,time,people,state,user_id,item_id,item_name,price,create_by,create_time,update_by,update_time) " +
            "VALUES (#{id},#{hotel_id},#{name},#{introduce},#{image},#{introduce},#{people},#{people},#{user_id},#{item_id},#{item_name},#{price},#{createBy},NOW(),#{updateTy}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSysHotelOrder(SysHotelOrder sysHotelOrder);

    // 编辑预约信息
    @Update("UPDATE sys_hotel_order SET  time = #{time},people = #{people},update_time = NOW()" +
            "WHERE id = #{id}")
    int updateSysHotelOrderById(SysHotelOrder sysHotelOrder);

    // 根据 ID 删除酒预约信息
    @Delete("DELETE FROM sys_hotel_order WHERE id = #{id}")
    int deleteSysHotelOrderById(String id);
}
