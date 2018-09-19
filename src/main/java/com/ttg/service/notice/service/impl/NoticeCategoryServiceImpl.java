package com.ttg.service.notice.service.impl;

import com.ttg.service.notice.dao.NoticeCategoryDao;
import com.ttg.service.notice.entity.NoticeCategoryEntity;
import com.ttg.service.notice.service.NoticeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: NoticeCategoryServiceImpl</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/12 9:54
 */
@Service
public class NoticeCategoryServiceImpl implements NoticeCategoryService {

    @Autowired
    private NoticeCategoryDao noticeCategoryDao;

    //查询公告类型列表
    @Override
    public List<NoticeCategoryEntity> findAll() {
        return noticeCategoryDao.findAll();
    }

    //分页查询公告类型列表
    public Page<NoticeCategoryEntity> queryPage(Pageable pageable) {

        return noticeCategoryDao.findAll(pageable);
    }

    //查询公告类型详情
    @Override
    public NoticeCategoryEntity findById(String id) {
        return noticeCategoryDao.findById(id);
    }

    //新建公告类型
    @Override
    public NoticeCategoryEntity save(NoticeCategoryEntity noticeCategoryEntity) {
        return noticeCategoryDao.save(noticeCategoryEntity);
    }
    //更新公告类型
    @Override
    public NoticeCategoryEntity saveAndFlush(NoticeCategoryEntity noticeCategoryEntity) {
        return noticeCategoryDao.save(noticeCategoryEntity);
    }
    //根据id删除公告类型
    @Override
    public void deleteById(String id) {
        noticeCategoryDao.deleteById(id);
    }
}
