package com.shanzhu.tourism.controller.hotel;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.tourism.domain.Result;
import com.shanzhu.tourism.domain.SysHotelItem;
import com.shanzhu.tourism.domain.SysHotelOrder;
import com.shanzhu.tourism.service.SysHotelItemService;
import com.shanzhu.tourism.service.SysHotelOrderService;
import com.shanzhu.tourism.service.SysHotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("order")
public class SysHotelOrderController {

    @Resource
    private SysHotelOrderService sysHotelOrderService;
    @Resource
    private SysHotelService sysHotelService;
    @Resource
    private SysHotelItemService sysHotelItemService;

    /** 分页获取酒店预约 */
    @PostMapping("getSysHotelOrderPage")
    public Result getSysHotelOrderPage(@RequestBody SysHotelOrder sysHotelOrder) {
        Page<SysHotelOrder> page = new Page<>(sysHotelOrder.getPageNumber(),sysHotelOrder.getPageSize());
        QueryWrapper<SysHotelOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(StringUtils.isNotBlank(sysHotelOrder.getHotelId()),SysHotelOrder::getHotelId,sysHotelOrder.getHotelId())
                .like(StringUtils.isNotBlank(sysHotelOrder.getName()),SysHotelOrder::getName,sysHotelOrder.getName())
                .eq(sysHotelOrder.getState() != null,SysHotelOrder::getState,sysHotelOrder.getState())
                .eq(StringUtils.isNotBlank(sysHotelOrder.getUserId()),SysHotelOrder::getUserId,sysHotelOrder.getUserId())
                .eq(StringUtils.isNotBlank(sysHotelOrder.getItemId()),SysHotelOrder::getItemId,sysHotelOrder.getItemId())
                .like(StringUtils.isNotBlank(sysHotelOrder.getCreateBy()),SysHotelOrder::getCreateBy,sysHotelOrder.getCreateBy())
                .eq(sysHotelOrder.getCreateTime() != null,SysHotelOrder::getCreateTime,sysHotelOrder.getCreateTime());
        Page<SysHotelOrder> sysHotelOrderPage = sysHotelOrderService.page(page, queryWrapper);
        return Result.success(sysHotelOrderPage);
    }

    /** 根据id获取酒店预约 */
    @GetMapping("getSysHotelOrderById")
    public Result getSysHotelOrderById(@RequestParam("id")String id) {
        List<SysHotelOrder> orderList = sysHotelOrderService.getOrderById(id);
        return Result.success(orderList);
    }

    /** 保存酒店预约 */
    @PostMapping("saveSysHotelOrder")
    @Transactional(rollbackFor = Exception.class)
    public Result saveSysHotelOrder(@RequestBody SysHotelOrder sysHotelOrder) {
        SysHotelItem item = sysHotelItemService.getById(sysHotelOrder.getHotelId());
        if(item.getNum() <= 0) {
            throw new RuntimeException("房间已售罄");
        }
        item.setNum(item.getNum()-1);
        int i = sysHotelOrderService.saveOrder(sysHotelOrder);
        return Result.success(i);

    }

    /** 编辑酒店预约 */
    @PostMapping("editSysHotelOrder")
    public Result editSysHotelOrder(@RequestBody SysHotelOrder sysHotelOrder) {
        int i = sysHotelOrderService.update(sysHotelOrder);
        return Result.success(i);

    }

    /** 删除酒店预约 */
    @GetMapping("removeSysHotelOrder")
    public Result removeSysHotelOrder(@RequestParam("ids")String ids) {

        int delete = sysHotelOrderService.delete(ids);
        return Result.success(delete);
    }

}
