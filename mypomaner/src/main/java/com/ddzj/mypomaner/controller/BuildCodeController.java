package com.ddzj.mypomaner.controller;

import com.ddzj.mypomaner.buildcode.service.IBuildCodeService;
import com.ddzj.mypomaner.dto.FieldConfigListDto;
import com.ddzj.mypomaner.dto.FieldConfigSearchPageDto;
import com.ddzj.mypomaner.dto.FieldTemplateSearchDto;
import com.ddzj.mypomaner.entity.*;
import com.ddzj.mypomaner.service.*;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.convertervo.ProjectInfoVoConverter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 创建代码
 * @Author:yangzibo
 * @CreateTime:2024-02-16 20:11
 * @Description:
 * @Version:1.0
 **/
@RestController
@RequestMapping(value="/api/buildCode")
public class BuildCodeController {

    @Autowired
    private ITblProjectInfoService iTblProjectInfoService;
    @Autowired
    private ITblProjectConfigService iTblProjectConfigService;
    @Autowired
    private ITblFieldConfigService iTblFieldConfigService;
    @Autowired
    private ITblProjectTableService iTblProjectTableService;
    @Autowired
    private ITblProjectFieldService iTblProjectFieldService;
    @Autowired
    private ITblFieldTemplateService iTblFieldTemplateService;
    @Autowired
    private IBuildCodeService iBuildCodeService;

    /**
     * 根据项目获取代码
     */
    @GetMapping("getCodeByProject/{projectCode}")
    public AjaxResultVo getCodeByProject(@PathVariable String projectCode){
        TblProjectInfo tblProjectInfo = iTblProjectInfoService.findByProjectCode(projectCode);
        TblProjectConfig tblProjectConfig =  iTblProjectConfigService.findByProjectCode(tblProjectInfo.getProjectCode());
        Map<String, TblFieldConfig> fieldConfigMap = getFieldConfigMap(tblProjectConfig.getDatabaseType());

        Map<String, String> fieldTemplateMap = getFieldTemplateMap(tblProjectConfig);

        List<TblProjectTable> tblProjectTableList = iTblProjectTableService.findByProjectCode(tblProjectInfo.getProjectCode());
        for(TblProjectTable tblProjectTable : tblProjectTableList){
           List<TblProjectField> tblProjectFieldList = iTblProjectFieldService.findByProjectCodeAndTableId(tblProjectInfo.getProjectCode(), tblProjectTable.getId());
            iBuildCodeService.buildCodeFile(tblProjectInfo, tblProjectConfig, fieldConfigMap, tblProjectTable, tblProjectFieldList, fieldTemplateMap);
        }
        return AjaxResultVo.ok(Boolean.TRUE);
    }

    private Map<String, TblFieldConfig> getFieldConfigMap(String databaseType){
        FieldConfigSearchPageDto fieldCOnfigDto = new FieldConfigSearchPageDto();
        fieldCOnfigDto.setDatabaseType(databaseType);
        List<TblFieldConfig> tblFieldConfigList = iTblFieldConfigService.findByDatabaseType(fieldCOnfigDto);
        Map<String, TblFieldConfig> fieldConfigMap = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(tblFieldConfigList)){
            fieldConfigMap = tblFieldConfigList.stream()
                    .collect(Collectors.toMap(TblFieldConfig::getFieldDbType,
                                a->a, (k1,k2)->k2));
        }
        return fieldConfigMap;
    }

    private Map<String, String> getFieldTemplateMap(TblProjectConfig tblProjectConfig){
        FieldTemplateSearchDto fieldTemplateSearchDto = new FieldTemplateSearchDto();
        fieldTemplateSearchDto.setTableId(tblProjectConfig.getTableTemplateCode());
        fieldTemplateSearchDto.setEnabled(Boolean.TRUE);
        List<TblFieldTemplate> tblFieldTemplateList = iTblFieldTemplateService.findBySearchDto(fieldTemplateSearchDto);
        Map<String, String> fieldTemplateMap = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(tblFieldTemplateList)){
            fieldTemplateMap = tblFieldTemplateList.stream()
                    .collect(Collectors.toMap(TblFieldTemplate::getFieldCode,
                            TblFieldTemplate::getFieldName,(k1,k2)->k2));
        }
        return fieldTemplateMap;
    }
}
