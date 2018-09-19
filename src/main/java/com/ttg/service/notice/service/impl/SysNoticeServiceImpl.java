package com.ttg.service.notice.service.impl;

import com.ttg.service.notice.dao.SysNoticeDao;
import com.ttg.service.notice.entity.SysNoticeEntity;
import com.ttg.service.notice.service.SysNoticeService;
import com.ttg.service.notice.util.PageQuery;
import com.ttg.service.notice.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: SysNoticeServiceImpl</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 9:53
 */
@Service
public class SysNoticeServiceImpl implements SysNoticeService {
    //注入mapper
    @Autowired
    private SysNoticeDao sysNoticeDao;

    //分页查询获取公告列表
    @Override
    public PageUtils queryPage(Map<String, Object> map) {

      //获取参数，通过工具类封装成Jpa中的Pageable对象
      Pageable page = new PageQuery(map).getPageable();

      //通过pageable对象获取Page对象，并通过工具类对Page关键信息封装并返回
      return new PageUtils(sysNoticeDao.findAll(page));

    }

    //获取公告列表
    @Override
    public List<SysNoticeEntity> findAll() {
        return sysNoticeDao.findAll();
    }

    //根据类型获取对应的公告列表
    @Override
    public List<SysNoticeEntity> findByCategoryId(String categoryId) {
        return sysNoticeDao.findByCategoryId(categoryId);
    }

    //根据公告id获取公告详情
    @Override
    public SysNoticeEntity findById(String noticeId) {
        return sysNoticeDao.findById(noticeId);
    }

    //新建公告
    @Override
    public SysNoticeEntity save(SysNoticeEntity sysNoticeEntity) {
        //初始化新建公告：未发布0，未过期0，未隐藏0
        sysNoticeEntity.setNoticeStatus(0);
        sysNoticeEntity.setIsExpire(0);
        sysNoticeEntity.setIsHide(0);
        return sysNoticeDao.save(sysNoticeEntity);
    }

    //更新公告
    @Override
    public SysNoticeEntity update(SysNoticeEntity sysNoticeEntity) {
        //return sysNoticeDao.update(sysNoticeEntity);
        return sysNoticeDao.save(sysNoticeEntity);
    }

    //审核公告
    @Override
    public int examine(String id) {
        return sysNoticeDao.updateByCategoryIdStatus(id);
    }

    //隐藏公告
    @Override
    public int hide(String id) {
        return sysNoticeDao.updateByCategoryidHide(id);
    }

    //过期公告
    @Override
    public int expire(String id) {
        return sysNoticeDao.updateByCategoryidExpire(id);
    }
}
