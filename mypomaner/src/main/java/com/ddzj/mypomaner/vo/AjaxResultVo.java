package com.ddzj.mypomaner.vo;

import com.ddzj.mypomaner.common.AjaxResultStatus;

import java.io.Serializable;

public class AjaxResultVo implements Serializable {
    //状态
    private String status;
    //信息
    private String message;
    //数据体
    private Object data;

    /**
     * 构造成功数据结构
     * @param data
     * @return
     */
    public static AjaxResultVo ok(Object data){
        AjaxResultVo ajaxResultVo = new AjaxResultVo();
        ajaxResultVo.setStatus(AjaxResultStatus.SUCCESS_CODE);
        ajaxResultVo.setData(data);
        return ajaxResultVo;
    }

    /**
     * 自定义返回失败消息
     * @param msg
     * @return
     */
    public static AjaxResultVo error(String msg){
        AjaxResultVo ajaxResultVo = new AjaxResultVo();
        ajaxResultVo.setStatus(AjaxResultStatus.ERROR_CODE);
        ajaxResultVo.setMessage(msg);
        return ajaxResultVo;
    }

    /**
     * 自定义返回失败编码及消息
     * @param code
     * @param msg
     * @return
     */
    public static AjaxResultVo error(String code, String msg){
        AjaxResultVo ajaxResultVo = new AjaxResultVo();
        ajaxResultVo.setStatus(code);
        ajaxResultVo.setMessage(msg);
        return ajaxResultVo;
    }

    /**
     * 获取 状态
     *
     * @return status 状态
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置 状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取 信息
     *
     * @return message 信息
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置 信息
     *
     * @param message 信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取 数据体
     *
     * @return data 数据体
     */
    public Object getData() {
        return this.data;
    }

    /**
     * 设置 数据体
     *
     * @param data 数据体
     */
    public void setData(Object data) {
        this.data = data;
    }
}
