package com.ddzj.mypomaner.service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 00:04
 * @Description:
 * @Version:1.0
 **/
public interface DateService {
    /**
     * 获取当前时间
     * @return
     */
    Date getCurrentTime();

    /**
     * 获取当前时间
     * @return
     */
    LocalDateTime getLocalDateTimeNow();
}
