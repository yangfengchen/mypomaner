package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.dto.FieldTemplateSaveDto;
import com.ddzj.mypomaner.dto.FieldTemplateListDto;
import com.ddzj.mypomaner.dto.FieldTemplateSearchDto;
import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.dto.converterdto.FieldTemplateDtoConverter;
import com.ddzj.mypomaner.entity.TblFieldTemplate;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.service.ITblFieldTemplateService;
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
@RequestMapping("/api/fieldTemplate")
public class FieldTemplateController {

    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;
    @Autowired
    private ITblFieldTemplateService iTblFieldTemplateService;
    @Autowired
    private FieldTemplateDtoConverter fieldTemplateDtoConverter;
    @Autowired
    private ITblTableTemplateService iTblTableTemplateService;

    /**
     * 初始化查询方法
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch(){
        FieldTemplateListDto listDto = new FieldTemplateListDto();
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
    public AjaxResultVo restList(@RequestBody FieldTemplateSearchDto searchDto){
        List<TblFieldTemplate> tblFieldTemplateList = iTblFieldTemplateService.findBySearchDto(searchDto);
        List<FieldTemplateSaveDto> fieldTemplateSaveDtos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(tblFieldTemplateList)){
            fieldTemplateSaveDtos = fieldTemplateDtoConverter.entityToSaveDto(tblFieldTemplateList);
        }
        return AjaxResultVo.ok(fieldTemplateSaveDtos);
    }

    /**
     * 保存所有的字段模板
     * @return
     */
    @PostMapping("/saveList")
    public AjaxResultVo saveList(@RequestBody List<FieldTemplateSaveDto> entitys){
        List<TblFieldTemplate> tblFieldTemplateList = iTblFieldTemplateService.saveDtoList(entitys);
        if(tblFieldTemplateList != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

}
