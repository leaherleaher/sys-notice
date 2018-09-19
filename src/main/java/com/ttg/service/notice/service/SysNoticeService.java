package com.ttg.service.notice.service;

import com.ttg.service.notice.entity.SysNoticeEntity;
import com.ttg.service.notice.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: SysNoticeService</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 9:51
 */
public interface SysNoticeService {
    /**
     * @Description: 分页查询
     * @Param: [map]
     * @return: com.ttg.service.notice.util.PageUtils
     **/
    PageUtils queryPage(Map<String, Object> map);

    //公告查询
    List<SysNoticeEntity> findAll();

    //根据类型查询公告
    List<SysNoticeEntity> findByCategoryId(String categoryId);

    //查询公告详情
    SysNoticeEntity findById(String id);

    //公告新增
    SysNoticeEntity save(SysNoticeEntity sysNoticeEntity);

    //公告更新
    SysNoticeEntity update(SysNoticeEntity sysNoticeEntity);

    //公告审核
    int examine(String id);

    //公告隐藏
    int hide(String id);

    //公告过期
    int expire(String id);
}
