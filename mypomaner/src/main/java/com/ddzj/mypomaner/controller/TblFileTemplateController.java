package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.dto.FileTemplateListDto;
import com.ddzj.mypomaner.dto.FileTemplateSaveDto;
import com.ddzj.mypomaner.dto.converterdto.FileTemplateDtoConverter;
import com.ddzj.mypomaner.entity.TblFileTemplate;
import com.ddzj.mypomaner.service.ITblFileTemplateService;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字段模板表; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@RestController
@RequestMapping("/api/fileTemplate")
public class TblFileTemplateController {

    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;
    @Autowired
    private ITblFileTemplateService iTblFileTemplateService;
    @Autowired
    private FileTemplateDtoConverter fileTemplateDtoConverter;

    /**
     * 初始化查询方法
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch(){
        FileTemplateListDto listDto = new FileTemplateListDto();
        listDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        return AjaxResultVo.ok(listDto);
    }

    /**
     * 获取所有的字段模板
     * @returnÂ
     */
    @PostMapping("/restList")
    public AjaxResultVo restList(){
        List<TblFileTemplate> tblFileTemplateList = iTblFileTemplateService.list();
        List<FileTemplateSaveDto> fileTemplateSaveDtos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(tblFileTemplateList)){
            fileTemplateSaveDtos = fileTemplateDtoConverter.entityToSaveDto(tblFileTemplateList);
        }
        return AjaxResultVo.ok(fileTemplateSaveDtos);
    }

    /**
     * 保存所有的字段模板
     * @return
     */
    @PostMapping("/saveList")
    public AjaxResultVo saveList(@RequestBody List<FileTemplateSaveDto> entitys){
        List<TblFileTemplate> tblFileTemplateList = iTblFileTemplateService.saveDtoList(entitys);
        if(tblFileTemplateList != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

}
