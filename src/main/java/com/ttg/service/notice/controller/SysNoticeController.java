package com.ttg.service.notice.controller;

import com.ttg.service.notice.common.validator.ValidatorUtils;
import com.ttg.service.notice.common.validator.group.AddGroup;
import com.ttg.service.notice.common.validator.group.UpdateGroup;
import com.ttg.service.notice.entity.SysNoticeEntity;
import com.ttg.service.notice.service.SysNoticeService;
import com.ttg.service.notice.util.PageUtils;
import com.ttg.service.notice.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>Title: SysNoticeController</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 9:58
 */
@Api(description = "公告管理")
@RestController
@RequestMapping(value = "/notices")
public class SysNoticeController {
    //注入service
    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * @Description: 获取公告列表
     * @Date: 13:16 2018/9/11
     * @Param: []
     * @return: com.ttg.service.notice.entity.SysNoticeEntity
     **/
    @ApiOperation(value = "公告列表", notes = "获取公告列表")
    @GetMapping(value = "/list")
    public R list(@RequestParam Map<String,Object> map){
        //判断请求参数是否为空  page、limit、sidx(排序字段) order(排序方式)
        //获取到Page关键信息 封装成json数据并返回
        PageUtils page = sysNoticeService.queryPage(map);
        return R.ok().put("data", page);
    }

    /**
     * @Description: 获取当前类型的公告列表
     * @Date: 14:02 2018/9/11
     * @Param: [categoryId]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "获取当前类型公告列表", notes = "获取当前类型的公告列表")
    @GetMapping(value = "/list/{categoryId}")
    public R list(@PathVariable("categoryId") String categoryId) {

        List<SysNoticeEntity> list = sysNoticeService.findByCategoryId(categoryId);

        return R.ok().put("data", list);
    }

    /**
     * @Description: 获取公告详情
     * @Date: 13:16 2018/9/11
     * @Param: [id]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "公告详情", notes = "获取公告详情")
    @GetMapping(value = "/info/{id}")
    public R info(@PathVariable("id") String id) {

        SysNoticeEntity sysNoticeEntity = sysNoticeService.findById(id);
        return R.ok().put("data", sysNoticeEntity);
    }

    /**
     * @Description: 新建公告
     * @Date: 13:17 2018/9/11
     * @Param: [sysNotice]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "新建公告", notes = "新建公告")
    @PostMapping(value = "/save")
    public R save(@RequestBody SysNoticeEntity sysNotice) {
        ValidatorUtils.validateEntity(sysNotice, AddGroup.class);
        SysNoticeEntity sysNoticeEntity = sysNoticeService.save(sysNotice);
        return R.ok();
    }

    /**
     * @Description: 更新公告
     * @Date: 13:19 2018/9/11
     * @Param: [sysNoticeEntity]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "更新公告", notes = "更新公告")
    @PutMapping(value = "/update")
    public R update(@RequestBody SysNoticeEntity sysNotice) {
        ValidatorUtils.validateEntity(sysNotice, UpdateGroup.class);
        sysNoticeService.update(sysNotice);
        return R.ok();
    }

    /**
     * @Description: 审核公告
     * @Date: 13:27 2018/9/11
     * @Param: [statusDto]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "审核公告", notes = "审核公告")
    @PatchMapping(value = "/examine/{id}")
    public R examine(@PathVariable(value = "id") String id) {
        sysNoticeService.examine(id);
        return R.ok();
    }

    /**
     * @Description: 设置公告过期
     * @Date: 13:35 2018/9/11
     * @Param: [expireDto]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "设置公告过期", notes = "设置公告过期")
    @PatchMapping(value = "/expire/{id}")
    public R expire(@PathVariable(value = "id") String id) {
        sysNoticeService.expire(id);
        return R.ok();
    }

    /**
     * @Description: 设置发布公告隐藏
     * @Date: 13:36 2018/9/11
     * @Param: [hideDto]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value = "设置公告隐藏", notes = "设置公告隐藏")
    @PatchMapping(value = "/hide/{id}")
    public R hide(@PathVariable(value = "id") String id) {
        sysNoticeService.hide(id);
        return R.ok();
    }
}
