package com.sandra.msc.common.core.utils;

import org.springframework.util.StringUtils;

import com.sandra.msc.common.core.entity.PageCriteria;

/**
 * 
 * PaginationUtil
 *
 * @author sandra
 * @date 2019年12月11日
 */
public class PaginationUtil {

    public static String getOrderBy(final PageCriteria pageCriteria) {

        final StringBuilder orderBy = new StringBuilder();
        final String filed = pageCriteria.getFiled();
        final String order = pageCriteria.getOrder();

        if (StringUtils.isEmpty(filed)) {
            return null;
        }
        orderBy.append(filed);

        if (!StringUtils.isEmpty(order) && PageCriteria.DESC.equals(order)) {
            orderBy.append(PageCriteria.DESC);
        }

        orderBy.append(PageCriteria.ASC);
        return null;
    }
}
