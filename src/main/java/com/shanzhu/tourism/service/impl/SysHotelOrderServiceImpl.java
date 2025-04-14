package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysHotelOrder;
import com.shanzhu.tourism.domain.SysHotelOrder;
import com.shanzhu.tourism.mapper.SysHotelOrderMapper;
import com.shanzhu.tourism.service.SysHotelOrderService;
import org.springframework.stereotype.Service;

@Service
public class SysHotelOrderServiceImpl extends ServiceImpl<SysHotelOrderMapper, SysHotelOrder> implements SysHotelOrderService {
    @Override
    public SysHotelOrder getById(String id) {
        return this.baseMapper.selectSysHotelOrderById(id);
    }

    @Override
    public boolean save(SysHotelOrder sysHotelOrder) {
        return this.baseMapper.insertSysHotelOrder(sysHotelOrder) > 0;
    }

    @Override
    public boolean updateSysHotelOrder(SysHotelOrder sysHotelOrder) {
        return this.baseMapper.updateSysHotelOrderById(sysHotelOrder) > 0;
    }

    @Override
    public boolean removeSysHotelOrder(String id) {
        return this.baseMapper.deleteSysHotelOrderById(id) > 0;
    }
}
