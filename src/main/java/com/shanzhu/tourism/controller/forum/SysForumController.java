package com.shanzhu.tourism.controller.forum;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.tourism.domain.Result;
import com.shanzhu.tourism.domain.SysForum;
import com.shanzhu.tourism.enums.ResultCode;
import com.shanzhu.tourism.service.SysForumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.shanzhu.tourism.utils.JwtUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 资讯controller
 */
@Controller
@ResponseBody
@RequestMapping("forum")
@Api(value = "SysForumController", tags = "旅游资讯相关接口")
public class SysForumController {

    @Resource
    private SysForumService sysForumService;

    /**
     * 分页获取资讯
     */
    @ApiOperation("分页获取资讯")
    @PostMapping("getSysForumPage")
    public Result getSysForumPage(@RequestBody SysForum sysForum) {
        Page<SysForum> page = new Page<>(sysForum.getPageNumber(), sysForum.getPageSize());
        IPage<SysForum> sysForumPage = sysForumService.page(page, sysForum.getTitle());
        return Result.success(sysForumPage);
    }
    /*public Result getSysForumPage(@RequestBody SysForum sysForum) {
        Page<SysForum> page = new Page<>(sysForum.getPageNumber(),sysForum.getPageSize());
        QueryWrapper<SysForum> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(StringUtils.isNotBlank(sysForum.getTitle()),SysForum::getTitle,sysForum.getTitle())
                .orderByDesc(SysForum::getCreateTime);
        Page<SysForum> sysForumPage = sysForumService.page(page, queryWrapper);
        return Result.success(sysForumPage);
    }*/

    /**
     * 根据id获取资讯
     */
    @ApiOperation("根据id获取资讯")
    @GetMapping("getSysForumById")
    public Result getSysForumById(@RequestParam("id") String id) {
        SysForum sysForum = sysForumService.getById(id);
        return Result.success(sysForum);
    }

    /**
     * 添加资讯
     */
    @ApiOperation("添加资讯")
    @PostMapping("saveSysForum")
    /*public Result saveSysForum(@RequestBody SysForum sysForum, @RequestParam("userId") String userId) {
        sysForum.setCreateBy(userId);
        sysForum.setUpdateBy(userId);
        boolean save = sysForumService.save(sysForum);
        if (save) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.COMMON_DATA_OPTION_ERROR.getMessage());
        }
    }*/
    public Result saveSysForum(@RequestBody SysForum sysForum, HttpServletRequest request) {
        String userId = JwtUtil.getUserIdByToken(request);

        sysForum.setCreateBy(userId);
        sysForum.setUpdateBy(userId);

        boolean save = sysForumService.save(sysForum);
        if (save) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.COMMON_DATA_OPTION_ERROR.getMessage());
        }
    }

    /**
     * 编辑资讯
     */
    @ApiOperation("编辑资讯")
    @PostMapping("editSysForum")
    public Result editSysForum(@RequestBody SysForum sysForum,HttpServletRequest request) {
        String userId = JwtUtil.getUserIdByToken(request);

        sysForum.setCreateBy(userId);
        sysForum.setUpdateBy(userId);
        boolean update = sysForumService.updateSysForum(sysForum);
        if (update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.COMMON_DATA_OPTION_ERROR.getMessage());
        }
    }

    /**
     * 删除资讯
     */
    @ApiOperation("删除资讯")
    @GetMapping("removeSysForum")
    public Result removeSysForum(@RequestParam("ids") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            String[] asList = ids.split(",");
            for (String id : asList) {
                sysForumService.removeSysForum(id);
            }
            return Result.success();
        } else {
            return Result.fail("资讯id不能为空！");
        }
    }

}