package com.sandra.msc.common.core.entity;

import lombok.Data;

/**
 * 
 * 分页
 *
 * @author sandra
 * @date 2019年12月10日
 */
@Data
@SuppressWarnings("nls")
public class PageCriteria {

    /**
     * 升序
     */
    public static final String ASC = "asc";

    /**
     * 降序
     */
    public static final String DESC = "desc";

    /**
     * 分页大小
     */
    private int pageSize = 10;

    /**
     * 页数
     */
    private int pageNumber = 1;

    /**
     * 排序字段
     */
    private String filed;

    /**
     * desc降序，asc升序
     */
    private String order;

}
