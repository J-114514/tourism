package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysHotel;

public interface SysHotelService extends IService<SysHotel> {
    SysHotel getById(String id);

    boolean save(SysHotel sysHotel);

    boolean updateSysHotel(SysHotel sysHotel);

    boolean removeSysHotel(String id);
}
