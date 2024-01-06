package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.DictTypeEditDto;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.dto.converterdto.DictTypeDtoConverter;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.service.ITblDictTypeService;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.DictTypeListVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.convertervo.DictTypeVoConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 22:53
 * @Description:
 * @Version:1.0
 **/
@RestController
@RequestMapping("/api/dictType")
public class DictTypeController {

    @Autowired
    private ITblDictTypeService iTblDictTypeService;
    @Autowired
    private DictTypeVoConverter dictTypeVoConverter;
    @Autowired
    private DictTypeDtoConverter dictTypeDtoConverter;

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
    public AjaxResultVo rest(@RequestBody DictTypeSearchPageDto entityDto){
        Page<TblDictType> tblDictTypePage = new Page<>(entityDto.getCurrent(), entityDto.getPageSize());
        IPage<TblDictType> dictTypeDtoIPage = iTblDictTypeService.queryPageByEntityDto(tblDictTypePage, entityDto);
        PageListDto<DictTypeListVo> dictTypeListVoPageListDto = new PageListDto<DictTypeListVo>(dictTypeDtoIPage);
        if(CollectionUtils.isNotEmpty(dictTypeDtoIPage.getRecords())){
            dictTypeListVoPageListDto.setResults(dictTypeVoConverter.tblDictTypeToDictTypeListVo(dictTypeDtoIPage.getRecords()));
        }
        return AjaxResultVo.ok(dictTypeListVoPageListDto);
    }

    /**
     * 查看页面
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    public AjaxResultVo view(@PathVariable String id){
        TblDictType tblDictType = iTblDictTypeService.findById(id);
        if(tblDictType == null){
            return AjaxResultVo.error("找不到记录");
        }
        return AjaxResultVo.ok(dictTypeVoConverter.tblDictTypeToDictTypeViewVo(tblDictType));
    }

    /**
     * 新增按钮逻辑
     * @return
     */
    @GetMapping("/add")
    public AjaxResultVo add(){
        DictTypeEditDto dictTypeEditDto = new DictTypeEditDto();
        dictTypeEditDto.setId(IdUtils.getSnowflakeIdWorkerId());
        return AjaxResultVo.ok(dictTypeEditDto);
    }

    /**
     * 编辑按钮逻辑
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public AjaxResultVo edit(@PathVariable String id){
        TblDictType tblDictType = iTblDictTypeService.findById(id);
        if(tblDictType == null){
            return AjaxResultVo.error("找不到记录");
        }
        return AjaxResultVo.ok(dictTypeDtoConverter.tblDictTypeToDictTypeEditDto(tblDictType));
    }

    /**
     * 保存数据
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@RequestBody DictTypeEditDto entity){
        TblDictType tblDictType = iTblDictTypeService.saveDto(entity);
        if(tblDictType != null){
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblDictTypeService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }
}
