package com.ddzj.mypomaner.customexception;

public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(){

    }

    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(String msg, String code){
        super(msg);
        this.code = code;
    }

    /**
     * 获取
     *
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
