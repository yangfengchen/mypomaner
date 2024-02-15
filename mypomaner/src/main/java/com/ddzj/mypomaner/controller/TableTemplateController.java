package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.DictTypeEditDto;
import com.ddzj.mypomaner.dto.TableTemplateSaveDto;
import com.ddzj.mypomaner.dto.TableTemplateSearchPageDto;
import com.ddzj.mypomaner.dto.converterdto.TableTemplateDtoConverter;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.service.ITblTableTemplateService;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.TableTemplateListVo;
import com.ddzj.mypomaner.vo.convertervo.TableTemplateVoConverter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 表模板; 前端控制器
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@RestController
@RequestMapping("/api/tableTemplate")
public class TableTemplateController {
    @Autowired
    private ITblTableTemplateService iTblTableTemplateService;
    @Autowired
    private TableTemplateVoConverter tableTemplateVoConverter;
    @Autowired
    private TableTemplateDtoConverter tableTemplateDtoConverter;

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
     * @param entityDto
     * @return
     */
    @PostMapping("/rest")
    public AjaxResultVo rest(@RequestBody TableTemplateSearchPageDto entityDto){
        Page<TblTableTemplate> tblTableTemplatePage = new Page<>(entityDto.getCurrent(), entityDto.getPageSize());
        IPage<TblTableTemplate> pageResult = iTblTableTemplateService.queryPageByEntityDto(tblTableTemplatePage, entityDto);
        PageListDto<TableTemplateListVo> pagetListVo = new PageListDto<TableTemplateListVo>(pageResult);
        List<TableTemplateListVo> listVos = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(pageResult.getRecords())){
            listVos = tableTemplateVoConverter.tableTemplateToListVo(pageResult.getRecords());
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
        TableTemplateSaveDto editDto = new TableTemplateSaveDto();
        editDto.setId(IdUtils.getSnowflakeIdWorkerId());
        return AjaxResultVo.ok(editDto);
    }

    /**
     * 编辑按钮逻辑
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public AjaxResultVo edit(@PathVariable String id){
        TblTableTemplate entity = iTblTableTemplateService.findById(id);
        if(entity == null){
            return AjaxResultVo.error("找不到记录");
        }
        return AjaxResultVo.ok(tableTemplateDtoConverter.tableTemplateToEditDto(entity));
    }

    /**
     * 保存数据
     * @param saveDto
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@RequestBody TableTemplateSaveDto saveDto){
        TblTableTemplate entity = iTblTableTemplateService.saveDto(saveDto);
        if(entity != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblTableTemplateService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }

}
