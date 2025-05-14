package com.shanzhu.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.tourism.domain.SysLine;
import org.apache.ibatis.annotations.Select;

public interface SysLineMapper extends BaseMapper<SysLine> {
    @Select("select  * from sys_line where id=#{id}")
    SysLine selectById(String id);
}