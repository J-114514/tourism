package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysHotelItem;
import com.shanzhu.tourism.domain.SysHotelItem;

public interface SysHotelItemService extends IService<SysHotelItem> {
    SysHotelItem getById(String id);

    boolean save(SysHotelItem sysHotelItem);

    boolean updateSysHotelItem(SysHotelItem sysHotelItem);

    boolean removeSysHotelItem(String id);
}
