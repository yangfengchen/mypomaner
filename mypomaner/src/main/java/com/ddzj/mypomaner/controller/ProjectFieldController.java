package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.dto.ProjectFieldSaveDto;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 项目字段表; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Controller
@RequestMapping("/api/projectField")
public class ProjectFieldController {

    /**
     * 新增按钮逻辑
     * @return
     */
    @GetMapping("/add")
    public AjaxResultVo add(){
        ProjectFieldSaveDto saveDto = new ProjectFieldSaveDto();

        saveDto.setId(IdUtils.getSnowflakeIdWorkerId());

        return AjaxResultVo.ok(saveDto);
    }
}
