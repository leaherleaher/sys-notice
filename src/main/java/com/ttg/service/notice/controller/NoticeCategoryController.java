package com.ttg.service.notice.controller;

import com.ttg.service.notice.common.validator.ValidatorUtils;
import com.ttg.service.notice.common.validator.group.AddGroup;
import com.ttg.service.notice.common.validator.group.UpdateGroup;
import com.ttg.service.notice.entity.NoticeCategoryEntity;
import com.ttg.service.notice.service.NoticeCategoryService;
import com.ttg.service.notice.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Title: NoticeCategoryController</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/12 9:49
 */
@Api(value="NoticeCategoryController",description = "公告类型管理")
@RestController
@RequestMapping(value="/notices")
public class NoticeCategoryController {

    @Autowired
    private NoticeCategoryService noticeCategoryService;
    
    /**
     * @Description: 公告类型新增
     * @Param: [noticeCategoryEntity]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value="公告类型新增",notes = "公告类型新增",httpMethod = "POST")
    @PostMapping(value="/categories/save")
    public R save(@RequestBody NoticeCategoryEntity noticeCategoryEntity){
        ValidatorUtils.validateEntity(noticeCategoryEntity, AddGroup.class);
        noticeCategoryService.save(noticeCategoryEntity);
        return R.ok();
    }
    
    /**
     * @Description: 公告类型更新
     * @Param: [noticeCategoryEntity]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value="公告类型更新",notes = "公告类型更新")
    @PutMapping(value="/categories/update")
    public R update(@RequestBody NoticeCategoryEntity noticeCategoryEntity){
        ValidatorUtils.validateEntity(noticeCategoryEntity, UpdateGroup.class);
        noticeCategoryService.saveAndFlush(noticeCategoryEntity);
        return R.ok();
    }
    
    /**
     * @Description: 公告类型删除
     * @Param: [categoryId]
     * @return: com.ttg.service.notice.util.R
     **/
    @ApiOperation(value="公告类型删除",notes = "公告类型删除")
    @DeleteMapping(value="/categories/delete/{id}")
    public R delete(@PathVariable(value="id") String id){
        noticeCategoryService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value="公告类型列表查询",notes = "公告类型列表查询")
    @GetMapping(value="/categories/list")
    public R list(){
        List<NoticeCategoryEntity> list = noticeCategoryService.findAll();

        return R.ok().put("data",list);
    }

}
