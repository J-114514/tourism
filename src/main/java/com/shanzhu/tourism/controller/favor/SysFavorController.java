package com.shanzhu.tourism.controller.favor;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.tourism.domain.Result;
import com.shanzhu.tourism.domain.SysFavor;
import com.shanzhu.tourism.domain.SysLine;
import com.shanzhu.tourism.service.SysFavorService;
import com.shanzhu.tourism.service.SysLineService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("favor")
public class SysFavorController {

    @Resource
    private SysFavorService sysFavorService;
    @Resource
    private SysLineService sysLineService;

    /** 分页获取收藏 */
    @PostMapping("getSysFavorPage")
    public Result getSysFavorPage(@RequestBody SysFavor sysFavor) {

        Page<SysFavor> page = new Page<>(sysFavor.getPageNumber(),sysFavor.getPageSize());

        QueryWrapper<SysFavor> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda()
                .eq(StringUtils.isNotBlank(sysFavor.getLineId()),SysFavor::getLineId,sysFavor.getLineId())
                .eq(StringUtils.isNotBlank(sysFavor.getName()),SysFavor::getName,sysFavor.getName())
                .eq(StringUtils.isNotBlank(sysFavor.getIntroduce()),SysFavor::getIntroduce,sysFavor.getIntroduce())
                .eq(StringUtils.isNotBlank(sysFavor.getImages()),SysFavor::getImages,sysFavor.getImages())
                .eq(StringUtils.isNotBlank(sysFavor.getUserId()),SysFavor::getUserId,sysFavor.getUserId());
        Page<SysFavor> sysFavorPage = sysFavorService.page(page, queryWrapper);
        return Result.success(sysFavorPage);

    }



    /** 根据id获取收藏 */
    @GetMapping("getSysFavorById")
    public Result getSysFavorById(@RequestParam("id")String id) {
        List<SysFavor> byId = sysFavorService.getById(id);
        return Result.success(byId);
    }

    /** 保存收藏 */
    @PostMapping("saveSysFavor")
    @Transactional(rollbackFor = Exception.class)
    public Result saveSysFavor(@RequestBody SysFavor sysFavor) {
        SysLine sysLine = sysLineService.getById(sysFavor.getLineId());
        if(sysLine==null) {
            throw new RuntimeException("线路已下线");
        }
        int i = sysFavorService.saveFavor(sysFavor);
        return Result.success(i);
    }

//    @PostMapping("/offlineLine")
//    @Transactional(rollbackFor = Exception.class)
//    public Result offlineLine(@RequestParam String lineId) {
//
//        sysLineService.lambdaUpdate()
//                .eq(SysLine::getId, lineId)
//                .set(SysLine::getStatus, 0)
//                .update();
//
//        sysFavorService.lambdaUpdate()
//                .eq(SysFavor::getLineId, lineId)
//                .remove();
//
//        return Result.success();
//    }

    /** 编辑收藏 */
    @PostMapping("editSysFavor")
    public Result editSysFavor(@RequestBody SysFavor sysFavor) {
        int i = sysFavorService.update(sysFavor);
        return Result.success(i);
    }

    /** 删除收藏 */
    @GetMapping("removeSysFavor")

    public Result removeSysFavor(@RequestParam("ids")String ids) {
        int i = sysFavorService.delete(ids);
        return Result.success(i);
    }

}