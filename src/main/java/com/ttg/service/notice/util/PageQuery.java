package com.ttg.service.notice.util;

import com.ttg.service.notice.common.xss.SQLFilter;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: PageQuery</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 16:34
 */
public class PageQuery extends LinkedHashMap<String, Object> {

    /**
     * mybatis-plus分页参数
     */
    private Pageable pageable;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    private String sidx;

    private Sort.Direction order;

    public PageQuery(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        if (params.get("page") != null) {
            currPage = Integer.parseInt((String) params.get("page"));
        }
        if (params.get("limit") != null) {
            limit = Integer.parseInt((String) params.get("limit"));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx_after = SQLFilter.sqlInject((String) params.get("sidx"));
        String order_after = SQLFilter.sqlInject((String) params.get("order"));

        //排序
        if (StringUtils.isNotBlank(sidx_after) && StringUtils.isNotBlank(order_after)) {
            this.sidx = sidx_after;
            //处理sql注入时候作了小写处理
            this.order = order_after == "desc" ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        //jpa封装的hibernate分页
        this.pageable = PageRequest.of(this.getCurrPage(), this.getLimit(), this.getOrder(), this.getSidx());

    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public Sort.Direction getOrder() {
        return order;
    }

    public void setOrder(Sort.Direction order) {
        this.order = order;
    }
}
