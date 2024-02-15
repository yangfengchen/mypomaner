package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.dto.FileTemplateListDto;
import com.ddzj.mypomaner.dto.FileTemplateSaveDto;
import com.ddzj.mypomaner.dto.FileTemplateSearchDto;
import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.dto.converterdto.FileTemplateDtoConverter;
import com.ddzj.mypomaner.entity.TblFileTemplate;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.service.ITblFileTemplateService;
import com.ddzj.mypomaner.service.ITblTableTemplateService;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
public class FileTemplateController {

    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;
    @Autowired
    private ITblFileTemplateService iTblFileTemplateService;
    @Autowired
    private FileTemplateDtoConverter fileTemplateDtoConverter;
    @Autowired
    private ITblTableTemplateService iTblTableTemplateService;

    /**
     * 初始化查询方法
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch(){
        FileTemplateListDto listDto = new FileTemplateListDto();
        List<TblTableTemplate> tableTemplates = iTblTableTemplateService.list();
        tableTemplates = tableTemplates.stream()
                .filter(a-> BooleanUtils.isTrue(a.getEnabled()))
                .collect(Collectors.toList());
        List<SelectDto> tableTemplateList = Lists.newArrayList();
        for(TblTableTemplate tblTableTemplate : tableTemplates){
            tableTemplateList.add(new SelectDto(tblTableTemplate.getName(), tblTableTemplate.getCode()));
        }
        listDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        listDto.setTableTemplateList(tableTemplateList);
        return AjaxResultVo.ok(listDto);
    }

    /**
     * 获取所有的字段模板
     * @returnÂ
     */
    @PostMapping("/restList")
    public AjaxResultVo restList(@RequestBody FileTemplateSearchDto searchDto){
        List<TblFileTemplate> tblFileTemplateList = iTblFileTemplateService.findBySearchDto(searchDto);
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
