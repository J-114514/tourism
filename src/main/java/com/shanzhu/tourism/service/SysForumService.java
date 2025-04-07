package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysForum;
import org.springframework.stereotype.Service;

/*public interface SysForumService extends IService<SysForum> {
}*/
@Service
public interface SysForumService {

    IPage<SysForum> page(Page<SysForum> page, String title);

    SysForum getById(String id);

    boolean save(SysForum sysForum);

    boolean updateSysForum(SysForum sysForum);

    boolean removeSysForum(String id);
}
