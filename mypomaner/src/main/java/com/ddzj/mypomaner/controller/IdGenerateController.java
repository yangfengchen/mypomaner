package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.vo.AjaxResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * id 生成控制类
 * @Author:yangzibo
 * @CreateTime:2024-02-14 22:59
 * @Description:
 * @Version:1.0
 **/
@RestController
@RequestMapping("/api/idGenerate")
public class IdGenerateController {

    @GetMapping("/getIdByType/{type}")
    public AjaxResultVo getIdByType(@PathVariable("type") String type){
        return AjaxResultVo.ok(UUID.randomUUID().toString());
    }

}
