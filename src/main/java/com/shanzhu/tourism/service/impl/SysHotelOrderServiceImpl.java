package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysHotelOrder;
import com.shanzhu.tourism.mapper.SysHotelOrderMapper;
import com.shanzhu.tourism.service.SysHotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysHotelOrderServiceImpl extends ServiceImpl<SysHotelOrderMapper, SysHotelOrder> implements SysHotelOrderService {
    @Autowired
    SysHotelOrderMapper sysHotelOrderMapper;
    @Override
    public List<SysHotelOrder> getOrderById(String id) {
        List<SysHotelOrder> list = sysHotelOrderMapper.selectOrdersWithHotel(id);
        return list;
    }

    @Override
    public int saveOrder(SysHotelOrder sysHotelOrder) {

        return sysHotelOrderMapper.insertOrder(sysHotelOrder);
    }

    @Override
    public int delete(String id) {
        return sysHotelOrderMapper.deleteById(id);
    }

    @Override
    public int update(SysHotelOrder sysHotelOrder) {
        return sysHotelOrderMapper.updateById(sysHotelOrder);
    }
}
