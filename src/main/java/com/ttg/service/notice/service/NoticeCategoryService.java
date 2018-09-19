package com.ttg.service.notice.service;

import com.ttg.service.notice.entity.NoticeCategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>Title: NoticeCategoryService</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/12 9:53
 */
public interface NoticeCategoryService {

    //查询所有
    List<NoticeCategoryEntity> findAll();
    //分页查询
    Page<NoticeCategoryEntity> queryPage(Pageable pageable);

    //查询指定品类
    NoticeCategoryEntity findById(String id);

    //插入品类信息
    NoticeCategoryEntity save(NoticeCategoryEntity noticeCategoryEntity);

    //更新
    NoticeCategoryEntity saveAndFlush(NoticeCategoryEntity noticeCategoryEntity);

    //删除
     void deleteById(String id);
}
