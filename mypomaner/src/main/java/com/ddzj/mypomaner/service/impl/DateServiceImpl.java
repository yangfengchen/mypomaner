package com.ddzj.mypomaner.service.impl;

import com.ddzj.mypomaner.service.DateService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 00:05
 * @Description:
 * @Version:1.0
 **/
@Service
public class DateServiceImpl implements DateService
{
    @Override
    public Date getCurrentTime() {
        return new Date();
    }

    @Override
    public LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.now();
    }
}
