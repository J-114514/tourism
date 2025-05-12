package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysFavor;
import com.shanzhu.tourism.mapper.SysFavorMapper;
import com.shanzhu.tourism.service.SysFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysFavorServiceImpl extends ServiceImpl<SysFavorMapper, SysFavor> implements SysFavorService {
    @Autowired
    SysFavorMapper sysFavorMapper;



    @Override
    public List<SysFavor> getById(String id) {
        return  sysFavorMapper.selectById(id);
    }

    @Override
    public int saveFavor(SysFavor sysFavor) {
        return sysFavorMapper.insertFavor(sysFavor);

    }


    @Override
    public int delete(String id) {
        return sysFavorMapper.deleteById(id);
    }

    @Override
    public int update(SysFavor sysFavor) {
      return   sysFavorMapper.update(sysFavor);

    }
}
