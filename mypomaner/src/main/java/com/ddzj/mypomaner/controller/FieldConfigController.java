package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.*;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.service.ITblFieldConfigService;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.DictTypeListVo;
import com.ddzj.mypomaner.vo.FieldConfigListVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.convertervo.FieldConfigVoConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目配置; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@RestController
@RequestMapping("/fieldConfig")
public class FieldConfigController {

    @Autowired
    private ITblFieldConfigService iTblFieldConfigService;
    @Autowired
    private FieldConfigVoConverter fieldConfigVoConverter;
    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;

    /**
     * 初始化查询方法
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch(){
        return AjaxResultVo.ok("");
    }

    @PostMapping("/rest")
    public AjaxResultVo rest(@RequestBody FieldConfigSearchPageDto entityDto){
        Page<TblFieldConfig> entityPage = new Page<>(entityDto.getCurrent(), entityDto.getPageSize());
        IPage<TblFieldConfig> entityIpage = iTblFieldConfigService.queryPageByEntityDto(entityPage, entityDto);
        PageListDto<FieldConfigListVo> resultPage = new PageListDto<FieldConfigListVo>(entityIpage);
        if(CollectionUtils.isNotEmpty(entityIpage.getRecords())){
            List<FieldConfigListVo> fieldConfigListVoList = new ArrayList<>(resultPage.getResults().size());
            Map<String, String> dbTypeMap = iSelectDictDataCommonService.getDbTypeSelectMap();
            Map<String, String> fieldDbTypeMap = iSelectDictDataCommonService.getFieldDbTypeSelectMap();
            for(TblFieldConfig entity : entityIpage.getRecords()){
                FieldConfigListVo entityVo = fieldConfigVoConverter.tblFieldConfigToFieldConfigListVo(entity);
                entityVo.setFieldDbTypeName(dbTypeMap.get(entityVo.getFieldDbType()));
                entityVo.setFieldDbTypeName(fieldDbTypeMap.get(entityVo.getFieldDbType()));
                fieldConfigListVoList.add(entityVo);
            }
            resultPage.setResults(fieldConfigListVoList);
        }
        return AjaxResultVo.ok(resultPage);
    }

    /**
     * 添加数据对象
     * @return
     */
    @GetMapping("/add/{databaseType}")
    public AjaxResultVo add(@PathVariable("databaseType")String databaseType){
        TblFieldConfig tblFieldConfig = new TblFieldConfig();
        tblFieldConfig.setId(IdUtils.getSnowflakeIdWorkerId());
        tblFieldConfig.setDatabaseType(databaseType);
        return AjaxResultVo.ok(tblFieldConfig);
    }

    /**
     * 初始化新增逻辑
     * @return
     */
    @GetMapping("/addList/{databaseType}")
    public AjaxResultVo addList(@PathVariable("databaseType")String databaseType){
        FieldConfigEditDto fieldConfigEditDto = new FieldConfigEditDto();
        fieldConfigEditDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        fieldConfigEditDto.setDbList(iSelectDictDataCommonService.getDbTypeSelectList());
        List<TblFieldConfig> tblFieldConfigs = iTblFieldConfigService.findByDatabaseType(databaseType);
        if(CollectionUtils.isNotEmpty(tblFieldConfigs)){
            fieldConfigEditDto.setFieldConfigSaveDtos(fieldConfigVoConverter.tblFieldConfigToFieldConfigSaveDto(tblFieldConfigs));
        }
        return AjaxResultVo.ok(fieldConfigEditDto);
    }

    /**
     * 编辑按钮逻辑
     * @param databaseType
     * @return
     */
    @GetMapping("/editList/{databaseType}")
    public AjaxResultVo edit(@PathVariable String databaseType){
        List<TblFieldConfig> tblFieldConfigs = iTblFieldConfigService.findByDatabaseType(databaseType);
        FieldConfigEditDto fieldConfigEditDto = new FieldConfigEditDto();
        List<FieldConfigSaveDto> fieldConfigSaveDtos = fieldConfigVoConverter.tblFieldConfigToFieldConfigSaveDto(tblFieldConfigs);
        fieldConfigEditDto.setFieldConfigSaveDtos(fieldConfigSaveDtos);
        fieldConfigEditDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        fieldConfigEditDto.setDbList(iSelectDictDataCommonService.getDbTypeSelectList());
        return AjaxResultVo.ok(fieldConfigEditDto);
    }

    /**
     * 保存数据
     * @param entitys
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@RequestBody List<FieldConfigSaveDto> entitys){
        List<TblFieldConfig> tblFieldConfigs = iTblFieldConfigService.saveDtoList(entitys);
        if(tblFieldConfigs != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblFieldConfigService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }

}
