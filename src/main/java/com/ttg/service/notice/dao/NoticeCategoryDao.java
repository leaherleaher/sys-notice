package com.ttg.service.notice.dao;

import com.ttg.service.notice.entity.NoticeCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>Title: NoticeCategoryDao</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/12 9:02
 */
@Repository
public interface NoticeCategoryDao extends JpaRepository<NoticeCategoryEntity,Integer> {

    //查询所有
    List<NoticeCategoryEntity> findAll();
    //分页查询
    Page<NoticeCategoryEntity> findAll(Pageable pageable);
    
    //查询指定品类
    NoticeCategoryEntity findById(String id);

    //插入品类信息
    @Override
    <S extends NoticeCategoryEntity> S save(S entity);

    //更新
    @Override
    <S extends NoticeCategoryEntity> S saveAndFlush(S s);

    //删除
    @Transactional
    @Modifying
    void deleteById(String id);
}
