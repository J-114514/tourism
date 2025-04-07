package com.shanzhu.tourism.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.tourism.domain.SysForum;
import com.shanzhu.tourism.mapper.SysForumMapper;
import com.shanzhu.tourism.service.SysForumService;
import org.springframework.stereotype.Service;

@Service
public class SysForumServiceImpl extends ServiceImpl<SysForumMapper, SysForum> implements SysForumService {
    @Override
    public IPage<SysForum> page(Page<SysForum> page, String title) {
        return this.baseMapper.selectPageVo(page,title);
    }

    @Override
    public SysForum getById(String id) {
        return this.baseMapper.selectSysForumById(id);
    }

    @Override
    public boolean save(SysForum sysForum) {
        return this.baseMapper.insertSysForum(sysForum) > 0;
    }

    @Override
    public boolean updateSysForum(SysForum sysForum) {
        return this.baseMapper.updateSysForumById(sysForum.getId(), sysForum.getTitle(), sysForum.getContent()) > 0;
    }

    @Override
    public boolean removeSysForum(String id) {
        return this.baseMapper.deleteSysForumById(id) > 0;
    }
}
