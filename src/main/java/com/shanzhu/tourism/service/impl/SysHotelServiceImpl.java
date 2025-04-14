package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.domain.SysHotel;
import com.shanzhu.tourism.mapper.SysHotelMapper;
import com.shanzhu.tourism.service.SysHotelService;
import org.springframework.stereotype.Service;

@Service
public class SysHotelServiceImpl extends ServiceImpl<SysHotelMapper, SysHotel> implements SysHotelService {
    @Override
    public SysHotel getById(String id) {
        return this.baseMapper.selectSysHotelById(id);
    }

    @Override
    public boolean save(SysHotel sysHotel) {
        return this.baseMapper.insertSysHotel(sysHotel) > 0;
    }

    @Override
    public boolean updateSysHotel(SysHotel sysHotel) {
        return this.baseMapper.updateSysHotelById(sysHotel) > 0;
    }

    @Override
    public boolean removeSysHotel(String id) {
        return this.baseMapper.deleteSysHotelById(id) > 0;
    }

}
