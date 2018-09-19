package com.ttg.service.notice.entity;


import com.ttg.service.notice.common.validator.group.AddGroup;
import com.ttg.service.notice.common.validator.group.UpdateGroup;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * <p>Title: NoticeCategoryEntity</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/12 9:32
 */
@Entity
@Table(name="notice_category")
public class NoticeCategoryEntity extends BaseModel {

    @NotEmpty(message = "公告类型不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String categoryCode;

    @NotBlank(message = "公告类型名称（英文）不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String categoryDescZh;
    @NotBlank(message = "公告类型名称（中文）不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String categoryDescCn;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryDescZh() {
        return categoryDescZh;
    }

    public void setCategoryDescZh(String categoryDescZh) {
        this.categoryDescZh = categoryDescZh;
    }

    public String getCategoryDescCn() {
        return categoryDescCn;
    }

    public void setCategoryDescCn(String categoryDescCn) {
        this.categoryDescCn = categoryDescCn;
    }
}
