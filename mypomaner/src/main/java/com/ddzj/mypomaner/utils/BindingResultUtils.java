package com.ddzj.mypomaner.utils;

import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 16:57
 * @Description:
 * @Version:1.0
 **/
public class BindingResultUtils {

    public static String bindingResultConverterString(BindingResult bindingResult) {
        // 打印全部的错误信息
        return bindingResult.getAllErrors().stream()
                .map(a -> a.getDefaultMessage())
                .collect(Collectors.joining(";"));
    }
}
