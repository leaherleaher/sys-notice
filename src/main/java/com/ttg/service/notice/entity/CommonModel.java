package com.ttg.service.notice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: CommonModel</p>
 * <p>Description: </p>
 * @MapperSuperclass使用环境：
 * 1.@MappedSuperclass注解使用在父类上面，是用来标识父类的
 * 2.@MappedSuperclass标识的类表示其不能映射到数据库表，因为其不是一个完整的实体类，但是它所拥有的属性能够隐射在其子类对用的数据库表中
 * 3.@MappedSuperclass标识得嘞不能再有@Entity或@Table注解
 * @Author yangtao
 * @Date 2018/9/18 13:28
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP) //设置数据库存储格式
    @Column(name="create_date",updatable = false) //表示在做update操作是该字段不会同步到数据库
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    //@JsonIgnore 返回json中不包含这个字段属性
    @Column(name="update_date")
    @UpdateTimestamp
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    @Column(name="create_by",updatable = false)
    @CreatedBy
    private int createBy;

    @Column(name="update_by")
    @LastModifiedBy
    private int updateBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }
}
