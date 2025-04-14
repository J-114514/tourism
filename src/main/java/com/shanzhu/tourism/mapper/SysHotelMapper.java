package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysLine;
import org.apache.ibatis.annotations.Select;

public interface SysHotelMapper extends BaseMapper<SysHotel> {
    @Select("select  * from sys_hotel where id=#{id}")
    SysLine selectById(String id);
}
