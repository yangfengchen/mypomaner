package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.*;
import com.ddzj.mypomaner.dto.converterdto.ProjectFieldDtoConverter;
import com.ddzj.mypomaner.entity.*;
import com.ddzj.mypomaner.service.*;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.ProjectTableListVo;
import com.ddzj.mypomaner.vo.convertervo.ProjectTableVoConverter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 项目表管理; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@RestController
@RequestMapping("/api/projectTable")
public class ProjectTableController {

    @Autowired
    private ITblProjectTableService iTblProjectTableService;
    @Autowired
    private ITblProjectFieldService iTblProjectFieldService;
    @Autowired
    private ISelectDictDataCommonService iSelectDictDataCommonService;
    @Autowired
    private ProjectTableVoConverter projectTableVoConverter;
    @Autowired
    private ProjectFieldDtoConverter projectFieldDtoConverter;
    @Autowired
    private ITblProjectConfigService iTblProjectConfigService;
    @Autowired
    private ITblFieldTemplateService iTblFieldTemplateService;
    @Autowired
    private ITblProjectInfoService iTblProjectInfoService;
    @Autowired
    private ITblFieldConfigService iTblFieldConfigService;

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
    public AjaxResultVo rest(@RequestBody ProjectTableSearchPageDto searchDto){
        Page<TblProjectTable> page = new Page<>(searchDto.getCurrent(), searchDto.getPageSize());
        IPage<TblProjectTable> pageResult = iTblProjectTableService.queryPageByEntityDto(page, searchDto);
        PageListDto<ProjectTableListVo> pagetListVo = new PageListDto<ProjectTableListVo>(pageResult);
        List<ProjectTableListVo> listVos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(pageResult.getRecords())){
            listVos = projectTableVoConverter.entityListToListVos(pageResult.getRecords());
        }
        pagetListVo.setResults(listVos);
        return AjaxResultVo.ok(pagetListVo);
    }


    /**
     * 新增按钮逻辑
     * @return
     */
    @GetMapping("/add/{projectCode}")
    public AjaxResultVo add(@PathVariable String projectCode){
        ProjectTableEditDto editDto = new ProjectTableEditDto();

        ProjectTableSaveDto saveDto = new ProjectTableSaveDto();
        saveDto.setId(IdUtils.getSnowflakeIdWorkerId());
        saveDto.setProjectCode(projectCode);

        TblProjectConfig tblProjectConfig = iTblProjectConfigService.findByProjectCode(projectCode);
        TblProjectInfo tblProjectInfo = iTblProjectInfoService.findByProjectCode(projectCode);
        saveDto.setFileNameConvert(tblProjectConfig.getFileNameConvert());
        saveDto.setPackageName(tblProjectInfo.getPackageName());

        FieldTemplateSearchDto fieldTemplateSearchDto = new FieldTemplateSearchDto();
        fieldTemplateSearchDto.setTableId(tblProjectConfig.getTableTemplateCode());
        fieldTemplateSearchDto.setEnabled(Boolean.TRUE);
        List<TblFieldTemplate> tblFieldTemplateList = iTblFieldTemplateService.findBySearchDto(fieldTemplateSearchDto);
        List<ProjectFieldSaveDto> projectFiledList = Lists.newArrayList();
        for(TblFieldTemplate tblFieldTemplate : tblFieldTemplateList){
            ProjectFieldSaveDto projectFieldSaveDto = projectFieldDtoConverter.templateEntityToSaveDto(tblFieldTemplate);
            projectFieldSaveDto.setId(IdUtils.getSnowflakeIdWorkerId());
            projectFieldSaveDto.setProjectCode(projectCode);
            projectFieldSaveDto.setTableId(saveDto.getId());
            projectFiledList.add(projectFieldSaveDto);
        }
        saveDto.setFieldSaveDtoList(projectFiledList);

        editDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        editDto.setSaveDto(saveDto);

        return AjaxResultVo.ok(editDto);
    }

    /**
     * 编辑按钮逻辑
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public AjaxResultVo edit(@PathVariable String id){
        TblProjectTable entity = iTblProjectTableService.findById(id);

        if(entity == null){
            return AjaxResultVo.error("找不到记录");
        }
        ProjectTableEditDto editDto = new ProjectTableEditDto();
        ProjectTableSaveDto saveDto = new ProjectTableSaveDto();
        saveDto.setId(entity.getId());
        saveDto.setProjectCode(entity.getProjectCode());
        saveDto.setName(entity.getName());
        saveDto.setPrefixName(entity.getPrefixName());
        saveDto.setEnabled(entity.getEnabled());
        saveDto.setZnName(entity.getZnName());
        saveDto.setCodeName(entity.getCodeName());
        saveDto.setPackageName(entity.getPackageName());
        saveDto.setFileNameConvert(entity.getFileNameConvert());
        saveDto.setIndexName(entity.getIndexName());
        saveDto.setCreateName(entity.getCreateName());

        List<TblProjectField> tblProjectFields = iTblProjectFieldService.findByProjectCodeAndTableId(entity.getProjectCode(), entity.getId());
        List<ProjectFieldSaveDto> projectFieldSaveDtos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(tblProjectFields)){
            projectFieldSaveDtos = projectFieldDtoConverter.entityListToSaveDtos(tblProjectFields);
        }
        saveDto.setFieldSaveDtoList(projectFieldSaveDtos);
        editDto.setSaveDto(saveDto);

        editDto.setFieldDbTypeList(iSelectDictDataCommonService.getFieldDbTypeSelectList());
        return AjaxResultVo.ok(editDto);
    }

    /**
     * 保存数据
     * @param saveDto
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@RequestBody ProjectTableSaveDto saveDto){
        TblProjectTable entity = iTblProjectTableService.saveDto(saveDto);
        if(entity != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblProjectTableService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }

}
