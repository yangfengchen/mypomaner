package com.ddzj.mypomaner.utils;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 00:09
 * @Description:
 * @Version:1.0
 **/
public class IdUtils {

    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker();
    public synchronized static String getSnowflakeIdWorkerId(){
        return String.valueOf(snowflakeIdWorker.nextId());
    }
}
