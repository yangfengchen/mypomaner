package com.ddzj.mypomaner.handle;

import com.ddzj.mypomaner.common.AjaxResultStatus;
import com.ddzj.mypomaner.customexception.ServiceException;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = Exception.class)
    public AjaxResultVo ajaxErrorHandler(Exception ex) {
        logger.debug("错误信息",ex);
        AjaxResultVo ajaxResultDto = new AjaxResultVo();
        ajaxResultDto.setStatus(AjaxResultStatus.ERROR_CODE);
        ajaxResultDto.setMessage("请求接口出错！");
        return ajaxResultDto;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = ServiceException.class)
    public AjaxResultVo ajaxMyErrorHandler(ServiceException ex) {
        logger.debug("错误信息",ex);
        AjaxResultVo ajaxResultDto = new AjaxResultVo();
        if(StringUtils.equals(ex.getCode(), AjaxResultStatus.ERROR_LOGIN_CODE)){
            ajaxResultDto.setStatus(AjaxResultStatus.ERROR_LOGIN_CODE);
            ajaxResultDto.setMessage("用户未登陆或者登陆失效！");
        }else{
            ajaxResultDto.setStatus(AjaxResultStatus.ERROR_CODE);
            ajaxResultDto.setMessage(ex.getMessage());
        }
        return ajaxResultDto;
    }
}
