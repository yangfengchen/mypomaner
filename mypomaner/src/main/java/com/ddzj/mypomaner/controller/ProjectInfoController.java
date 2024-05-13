package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.*;
import com.ddzj.mypomaner.entity.TblProjectConfig;
import com.ddzj.mypomaner.entity.TblProjectInfo;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.service.ITblProjectConfigService;
import com.ddzj.mypomaner.service.ITblProjectInfoService;
import com.ddzj.mypomaner.service.ITblTableTemplateService;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.ProjectInfoListVo;
import com.ddzj.mypomaner.vo.TableTemplateListVo;
import com.ddzj.mypomaner.vo.convertervo.ProjectInfoVoConverter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 项目信息表; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@RestController
@RequestMapping("/api/projectInfo")
public class ProjectInfoController {

    @Autowired
    private ITblProjectInfoService iTblProjectInfoService;
    @Autowired
    private ProjectInfoVoConverter projectInfoVoConverter;
    @Autowired
    private ITblProjectConfigService iTblProjectConfigService;
    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;
    @Autowired
    private ITblTableTemplateService iTblTableTemplateService;

    /**
     * 初始化查询方法
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch(){
        return AjaxResultVo.ok("");
    }

    /**
     * 列表查询方法
     * @param searchDto
     * @return
     */
    @PostMapping("/rest")
    public AjaxResultVo rest(@RequestBody ProjectInfoSearchPageDto searchDto){
        Page<TblProjectInfo> page = new Page<>(searchDto.getCurrent(), searchDto.getPageSize());
        IPage<TblProjectInfo> pageResult = iTblProjectInfoService.queryPageByEntityDto(page, searchDto);
        PageListDto<ProjectInfoListVo> pagetListVo = new PageListDto<ProjectInfoListVo>(pageResult);
        List<ProjectInfoListVo> listVos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(pageResult.getRecords())){
            List<String> projectCodes = pageResult.getRecords().stream()
                    .map(a-> a.getProjectCode())
                    .collect(Collectors.toList());

            List<TblProjectConfig> tblProjectConfigs =  iTblProjectConfigService.findByProjectCodeList(projectCodes);
            Map<String, TblProjectConfig> projectConfigMap = tblProjectConfigs.stream()
                    .collect(Collectors.toMap(TblProjectConfig::getProjectCode, a->a));
            Map<String, String> dbMap = iSelectDictDataCommonService.getDbTypeSelectMap();
            Map<String, String> codeFrameMap = iSelectDictDataCommonService.getCodeFrameTypeSelectMap();
            Map<String, String> tableTemplateMap = getTblTableTemplateMap();
            for(TblProjectInfo tblProjectInfo : pageResult.getRecords()){
                ProjectInfoListVo projectInfoListVo = projectInfoVoConverter.entityToListVo(tblProjectInfo);
                TblProjectConfig tblProjectConfig = projectConfigMap.get(tblProjectInfo.getProjectCode());
                projectInfoListVo.setCodeTypeName(codeFrameMap.get(tblProjectConfig.getCodeType()));
                projectInfoListVo.setDatabaseTypeName(dbMap.get(tblProjectConfig.getDatabaseType()));
                projectInfoListVo.setTableTemplateCodeName(tableTemplateMap.get(tblProjectConfig.getTableTemplateCode()));
                listVos.add(projectInfoListVo);
            }
        }
        pagetListVo.setResults(listVos);
        return AjaxResultVo.ok(pagetListVo);
    }


    /**
     * 新增按钮逻辑
     * @return
     */
    @GetMapping("/add")
    public AjaxResultVo add(){
        ProjectInfoEditDto projectInfoEditDto = new ProjectInfoEditDto();

        ProjectInfoSaveDto saveDto = new ProjectInfoSaveDto();
        saveDto.setId(IdUtils.getSnowflakeIdWorkerId());
        projectInfoEditDto.setSaveDto(saveDto);

        projectInfoEditDto.setCodeTypeList(iSelectDictDataCommonService.getCodeFrameTypeSelectList());
        projectInfoEditDto.setTableTemplateList(getTblTableTemplateList());
        projectInfoEditDto.setDbTypeList(iSelectDictDataCommonService.getDbTypeSelectList());

        return AjaxResultVo.ok(projectInfoEditDto);
    }

    /**
     * 编辑按钮逻辑
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public AjaxResultVo edit(@PathVariable String id){
        TblProjectInfo entity = iTblProjectInfoService.findById(id);

        if(entity == null){
            return AjaxResultVo.error("找不到记录");
        }
        ProjectInfoEditDto editDto = new ProjectInfoEditDto();
        ProjectInfoSaveDto saveDto = new ProjectInfoSaveDto();
        saveDto.setId(entity.getId());
        saveDto.setProjectCode(entity.getProjectCode());
        saveDto.setProjectName(entity.getProjectName());
        saveDto.setProjectZnName(entity.getProjectZnName());
        saveDto.setPackageName(entity.getPackageName());

        TblProjectConfig tblProjectConfig = iTblProjectConfigService.findByProjectCode(entity.getProjectCode());
        if(tblProjectConfig != null){
            saveDto.setDatabaseType(tblProjectConfig.getDatabaseType());
            saveDto.setCodeType(tblProjectConfig.getCodeType());
            saveDto.setTableTemplateCode(tblProjectConfig.getTableTemplateCode());
            saveDto.setFileNameConvert(tblProjectConfig.getFileNameConvert());
        }

        editDto.setSaveDto(saveDto);

        editDto.setCodeTypeList(iSelectDictDataCommonService.getCodeFrameTypeSelectList());
        editDto.setTableTemplateList(getTblTableTemplateList());
        editDto.setDbTypeList(iSelectDictDataCommonService.getDbTypeSelectList());
        return AjaxResultVo.ok(editDto);
    }

    /**
     * 保存数据
     * @param saveDto
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@RequestBody ProjectInfoSaveDto saveDto){
        TblProjectInfo entity = iTblProjectInfoService.saveDto(saveDto);
        if(entity != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblProjectInfoService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }

    private List<SelectDto> getTblTableTemplateList(){
        TableTemplateSearchPageDto tableTemplateSearchPageDto = new TableTemplateSearchPageDto();
        tableTemplateSearchPageDto.setEnabled(true);
        List<SelectDto> selectDtos = Lists.newArrayList();
        List<TblTableTemplate> tblTableTemplates = iTblTableTemplateService.findListBySearchDto(tableTemplateSearchPageDto);
        for(TblTableTemplate tblTableTemplate : tblTableTemplates){
            selectDtos.add(new SelectDto(tblTableTemplate.getName(), tblTableTemplate.getCode()));
        }
        return selectDtos;
    }

    private Map<String, String> getTblTableTemplateMap(){
        Map<String, String> dataMap = Maps.newHashMap();
        List<SelectDto> tblTableTemplates = getTblTableTemplateList();
        if(CollectionUtils.isNotEmpty(tblTableTemplates)){
            dataMap = tblTableTemplates.stream()
                    .collect(Collectors.toMap(SelectDto::getValue, SelectDto::getLabel, (k1,k2)->k2));
        }
        return dataMap;
    }
}
