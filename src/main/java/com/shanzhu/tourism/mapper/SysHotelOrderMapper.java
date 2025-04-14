package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysHotelOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysHotelOrderMapper extends BaseMapper<SysHotelOrder> {
    @Select("SELECT o.*, h.name as hotel_name, h.introduce, h.images " +
            "FROM sys_hotel_order o " +
            "LEFT JOIN sys_hotel h ON o.hotel_id = h.id " +
            "WHERE o.user_id = #{userId} AND o.status = 'CONFIRMED'")
    @Results({
            @Result(property = "id", column = "o.id"),
            @Result(property = "userId", column = "o.user_id"),
            @Result(property = "hotelId", column = "o.hotel_id"),
            // 映射关联的酒店信息（一对一）
            @Result(property = "hotelInfo", column = "hotel_id",
                    one = @One(select = "com.example.mapper.SysHotelMapper.selectById"))
    })
    List<SysHotelOrder> selectOrdersWithHotel(String userId);
    @Insert({
            "INSERT INTO sys_hotel_order(",
            "hotel_id, item_id, user_id, state, price, num,",
            "time, images, people, create_by, create_time",
            ") VALUES (",
            " #{hotelId}, #{itemId}, #{userId}, #{state}, #{price}, #{num},",
            "#{time}, #{images,jdbcType=LONGTEXT}, #{people,jdbcType=LONGTEXT},",
            "#{createBy}, #{createTime}",
            ")"
    })

    int insertOrder(SysHotelOrder order);

    @Update({
            "UPDATE sys_hotel_order SET",
            "item_name = #{itemName},",
            "num = #{num},",
            "price = #{price},",
            "time = #{time},",
            "people = #{people},",
            "update_by = #{updateBy},",
            "update_time = NOW()",
            "WHERE id = #{id} AND user_id = #{userId}"
    })
    int updateOrderFields(SysHotelOrder order);

    @Delete("DELETE FROM sys_hotel_order WHERE id = #{id}")
    int deleteById(String stringd);
}
