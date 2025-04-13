package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysHotelOrder;
import com.shanzhu.tourism.domain.SysHotelOrder;

public interface SysHotelOrderService extends IService<SysHotelOrder> {
    SysHotelOrder getById(String id);

    boolean save(SysHotelOrder sysHotelOrder);

    boolean updateSysHotelOrder(SysHotelOrder sysHotelOrder);

    boolean removeSysHotelOrder(String id);
}