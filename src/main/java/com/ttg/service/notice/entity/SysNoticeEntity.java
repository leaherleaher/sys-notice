package com.ttg.service.notice.entity;

import com.ttg.service.notice.common.validator.group.AddGroup;
import com.ttg.service.notice.common.validator.group.UpdateGroup;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>Title: SysNoticeEntity</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/18 10:47
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="sys_notice")
public class SysNoticeEntity extends BaseModel {

    @NotNull(message="公告类型不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String categoryId;

    @NotEmpty(message="公告类型不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String categoryCode;

    @NotNull(message="公告状态不能为空",groups = UpdateGroup.class)
    private int noticeStatus;

    @NotEmpty(message="公告标题不能为空（英文）",groups = {AddGroup.class, UpdateGroup.class})
    private String noticeTitleZh;

    @NotEmpty(message="公告标题不能为空（英文）",groups = {AddGroup.class, UpdateGroup.class})
    private String noticeTitleCn;

    @NotEmpty(message="公告正文不能为空（英文）",groups = {AddGroup.class, UpdateGroup.class})
    private String noticeTextZh;

    @NotEmpty(message="公告正文不能为空（中文）",groups = {AddGroup.class, UpdateGroup.class})
    private String noticeTextCn;

    @NotNull(message="过期标志不能为空",groups = UpdateGroup.class)
    private int isExpire;

    @NotNull(message="隐藏标志不能为空",groups = UpdateGroup.class)
    private int isHide;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(int noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeTitleZh() {
        return noticeTitleZh;
    }

    public void setNoticeTitleZh(String noticeTitleZh) {
        this.noticeTitleZh = noticeTitleZh;
    }

    public String getNoticeTitleCn() {
        return noticeTitleCn;
    }

    public void setNoticeTitleCn(String noticeTitleCn) {
        this.noticeTitleCn = noticeTitleCn;
    }

    public String getNoticeTextZh() {
        return noticeTextZh;
    }

    public void setNoticeTextZh(String noticeTextZh) {
        this.noticeTextZh = noticeTextZh;
    }

    public String getNoticeTextCn() {
        return noticeTextCn;
    }

    public void setNoticeTextCn(String noticeTextCn) {
        this.noticeTextCn = noticeTextCn;
    }

    public int getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(int isExpire) {
        this.isExpire = isExpire;
    }

    public int getIsHide() {
        return isHide;
    }

    public void setIsHide(int isHide) {
        this.isHide = isHide;
    }

}
