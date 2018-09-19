package com.ttg.service.notice.dao;

import com.ttg.service.notice.entity.SysNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * <p>Title: SysNoticeDao</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 9:48
 */
@Repository
public interface SysNoticeDao extends JpaRepository<SysNoticeEntity, Integer> {

    //查询公告列表
    List<SysNoticeEntity> findAll();

    //分页查询  查询公告列表
    Page<SysNoticeEntity> findAll(Pageable pageable);

    //查询指定公告详情
    SysNoticeEntity findById(String id);

    //分页查询 查询指定公告类型列表
    List<SysNoticeEntity> findByCategoryId(String categoryId);

    //公告新增或更新（实时）
    @Override
    <S extends SysNoticeEntity> S save(S s);

    //公告新增或更新
    @Override
    <S extends SysNoticeEntity> S saveAndFlush(S s);

    /*@Transactional
    @Modifying
    @Query(value="update SysNoticeEntity t set t.categoryId = :#{#s.categoryId},t.categoryCode=:#{#s.categoryCode},t.noticeStatus=:#{#s.noticeStatus}," +
            "t.noticeTitleZh=:#{#s.noticeTitleZh},t.noticeTitleCn=:#{#s.noticeTitleCn},t.noticeTextZh=:#{#s.noticeTextZh},t.noticeTextCn=:#{#s.noticeTextCn}," +
            "t.isHide=:#{#s.isHide},t.isExpire=:#{#s.isExpire},t.updateBy=:#{#s.updateBy} where t.id=:#{#s.id}")
    int updateByEntity(@Param("s")SysNoticeEntity s);*/

    /**
     *  审核公告
     * @Modifing  指定该操作是update或者delete
     * nativeQuery：使用原生sql 否则就通过entity和属性操作sql
     * @param noticeId
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update sys_notice set notice_status = 1 where id = ?1", nativeQuery = true)
    int updateByCategoryIdStatus(String id);

    //设置公告隐藏
    @Modifying
    @Transactional
    @Query(value = "update sys_notice set is_hide = 1 where id = ?1",nativeQuery = true)
    int updateByCategoryidHide(String id);

    //设置公告过期
    @Modifying
    @Transactional
    @Query(value = "update sys_notice set is_expire = 1 where id = ?1",nativeQuery = true)
    int updateByCategoryidExpire(String id);
}
