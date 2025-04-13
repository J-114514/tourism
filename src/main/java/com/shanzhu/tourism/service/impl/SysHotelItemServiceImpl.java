package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysHotelItem;
import com.shanzhu.tourism.domain.SysHotelItem;
import com.shanzhu.tourism.mapper.SysHotelItemMapper;
import com.shanzhu.tourism.service.SysHotelItemService;
import org.springframework.stereotype.Service;

/**
 * @author 超级管理员
 * @version 1.0
 * @description: 房型service实现类
 */
@Service
public class SysHotelItemServiceImpl extends ServiceImpl<SysHotelItemMapper, SysHotelItem> implements SysHotelItemService {
    @Override
    public SysHotelItem getById(String id) {
        return this.baseMapper.selectSysHotelItemById(id);
    }

    @Override
    public boolean save(SysHotelItem sysHotelItem) {
        return this.baseMapper.insertSysHotelItem(sysHotelItem) > 0;
    }

    @Override
    public boolean updateSysHotelItem(SysHotelItem sysHotelItem) {
        return this.baseMapper.updateSysHotelItemById(sysHotelItem) > 0;
    }

    @Override
    public boolean removeSysHotelItem(String id) {
        return this.baseMapper.deleteSysHotelItemById(id) > 0;
    }
}
