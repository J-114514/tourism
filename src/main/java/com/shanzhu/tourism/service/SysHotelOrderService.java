package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysHotelOrder;

import java.util.List;

//extends IService<SysHotelOrder>
public interface SysHotelOrderService extends IService<SysHotelOrder> {

     List<SysHotelOrder> getOrderById(String id);

      int saveOrder(SysHotelOrder sysHotelOrder);
    int delete(String id);

    int update(SysHotelOrder sysHotelOrder);
}