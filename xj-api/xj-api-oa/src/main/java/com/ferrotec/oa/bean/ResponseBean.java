package com.ferrotec.oa.bean;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 响应的接口格式
 *
 * @author H
 * @version 1.0
 * @date 2020/1/4
 **/
@Component
public class ResponseBean<T> {

    private int status=HttpStatus.OK.value();

    private T data;

    private Long totalCount;

    public ResponseBean() {
    }

    public ResponseBean(T data) {
        this.data = data;
    }

    public ResponseBean(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
