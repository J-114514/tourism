package com.shanzhu.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.tourism.domain.SysFavor;

import java.util.List;

public interface SysFavorService extends IService<SysFavor> {
//   Page<SysFavor> page(SysFavor sysFavor);

   List<SysFavor> getById(String id);

   int saveFavor(SysFavor sysFavor);
   int delete(String id);

   int update(SysFavor sysFavor);
}
