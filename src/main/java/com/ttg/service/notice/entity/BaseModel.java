package com.ttg.service.notice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>Title: RandomBean</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/18 13:37
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseModel extends CommonModel {
    @Id
    @GeneratedValue(generator="UUIDHexGenerator")
    @GenericGenerator(name="UUIDHexGenerator", strategy="uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
