package com.rest.demo.common;

import lombok.Data;

import java.util.List;

/**
 * 分页数据
 * @param <T> 泛型
 */
@Data
public class PageResult<T> {

    private List<T> list;      // 当前页数据
    private long total;        // 总记录数
    private int page;          // 当前页码
    private int size;          // 每页大小
    private int totalPages;    // 总页数

    public PageResult(List<T> list, long total, int page, int size) {
        this.list = list;
        this.total = total;
        this.page = page;
        this.size = size;
        this.totalPages = (int) Math.ceil((double) total / size);
    }

}
