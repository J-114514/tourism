package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysHotelItem;
import org.apache.ibatis.annotations.Select;

public interface SysHotelItemMapper extends BaseMapper<SysHotelItem> {
    @Select("select  * from sys_hotel_item where id=#{id}")
    SysHotelItem selectById(String id);
}