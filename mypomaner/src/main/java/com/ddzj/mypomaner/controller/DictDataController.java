package com.ddzj.mypomaner.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.DictDataEditDto;
import com.ddzj.mypomaner.dto.DictDataListDto;
import com.ddzj.mypomaner.dto.DictDataSaveDto;
import com.ddzj.mypomaner.dto.DictDataSearchDto;
import com.ddzj.mypomaner.dto.converterdto.DictDataDtoConverter;
import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.service.ITblDictDataService;
import com.ddzj.mypomaner.service.ITblDictTypeService;
import com.ddzj.mypomaner.utils.BindingResultUtils;
import com.ddzj.mypomaner.utils.IdUtils;
import com.ddzj.mypomaner.vo.AjaxResultVo;
import com.ddzj.mypomaner.vo.DictDataListVo;
import com.ddzj.mypomaner.vo.DictDataViewVo;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.vo.convertervo.DictDataVoConverter;
import com.ddzj.mypomaner.vo.convertervo.DictTypeVoConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 22:53
 * @Description:
 * @Version:1.0
 **/
@RestController
@RequestMapping("/api/dictData")
@Validated
public class DictDataController {

    @Autowired
    private ITblDictTypeService iTblDictTypeService;
    @Autowired
    private DictTypeVoConverter dictTypeVoConverter;
    @Autowired
    private DictDataVoConverter dictDataVoConverter;
    @Autowired
    private ITblDictDataService iTblDictDataService;
    @Autowired
    private DictDataDtoConverter dictDataDtoConverter;

    /**
     * 初始化查询方法
     *
     * @return
     */
    @GetMapping("/initsearch")
    public AjaxResultVo initsearch() {
        DictDataListDto dictDataListDto = new DictDataListDto();
        dictDataListDto.setDictTypeList(iTblDictTypeService.findSelectDtoAll());
        return AjaxResultVo.ok(dictDataListDto);
    }

    /**
     * 列表查询方法
     *
     * @param entity
     * @return
     */
    @PostMapping("/rest")
    public AjaxResultVo rest(@RequestBody DictDataSearchDto entity) {
        Page<TblDictData> tblDictTypePage = new Page<>(entity.getCurrent(), entity.getPageSize());
        IPage<TblDictData> dictDataIPage = iTblDictDataService.queryPageByEntityDto(tblDictTypePage, entity);
        PageListDto<DictDataListVo> dictDataListVoPage = new PageListDto<DictDataListVo>(dictDataIPage);
        List<DictDataListVo> dictDataListVos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dictDataIPage.getRecords())) {
            Map<String, TblDictType> tblDictTypeMap = new HashMap<>();
            if (StringUtils.isNotBlank(entity.getDictCode())) {
                TblDictType tblDictType = iTblDictTypeService.findByDictType(entity.getDictCode());
                if (tblDictType != null) {
                    tblDictTypeMap.put(tblDictType.getDictType(), tblDictType);
                }
            } else {
                List<String> dictTypes = dictDataIPage.getRecords().stream()
                        .map(a -> a.getDictCode())
                        .collect(Collectors.toList());
                List<TblDictType> tblDictTypes = iTblDictTypeService.findListByDictType(dictTypes);
                tblDictTypeMap = tblDictTypes.stream()
                        .collect(Collectors.toMap(TblDictType::getDictType, a -> a));
            }

            for (TblDictData tblDictData : tblDictTypePage.getRecords()) {
                DictDataListVo dictDataListVo = dictDataVoConverter.dictDataToListVo(tblDictData);
                if (tblDictTypeMap.get(dictDataListVo.getDictCode()) != null) {
                    dictDataListVo.setDictName(tblDictTypeMap.get(dictDataListVo.getDictCode()).getDictName());
                }
                dictDataListVos.add(dictDataListVo);
            }
        }
        dictDataListVoPage.setResults(dictDataListVos);
        return AjaxResultVo.ok(dictDataListVoPage);
    }

    /**
     * 查看页面
     *
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    public AjaxResultVo view(@PathVariable String id) {
        Optional<TblDictData> tblDictDataOptional = iTblDictDataService.getOptById(id);
        if (tblDictDataOptional.isEmpty()) {
            return AjaxResultVo.error("找不到记录");
        }
        DictDataViewVo dictDataToViewVo = dictDataVoConverter.dictDataToViewVo(tblDictDataOptional.get());
        TblDictType tblDictType = iTblDictTypeService.findByDictType(dictDataToViewVo.getDictCode());
        if (tblDictType != null) {
            dictDataToViewVo.setDictName(tblDictType.getDictName());
        }
        return AjaxResultVo.ok(dictDataToViewVo);
    }

    /**
     * 新增按钮逻辑
     *
     * @return
     */
    @GetMapping("/add")
    public AjaxResultVo add(@RequestParam("dictCode") String dictCode) {
        DictDataEditDto dictDataEditDto = new DictDataEditDto();
        DictDataSaveDto dictDataSaveDto = new DictDataSaveDto();
        dictDataSaveDto.setId(IdUtils.getSnowflakeIdWorkerId());
        dictDataSaveDto.setDictCode(dictCode);
        dictDataEditDto.setDictDataSaveVo(dictDataSaveDto);
        dictDataEditDto.setDictTypeList(iTblDictTypeService.findSelectDtoAll());
        return AjaxResultVo.ok(dictDataEditDto);
    }

    /**
     * 编辑按钮逻辑
     *
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public AjaxResultVo edit(@PathVariable String id) {
        TblDictData tblDictData = iTblDictDataService.getById(id);
        DictDataEditDto dictDataEditDto = new DictDataEditDto();
        dictDataEditDto.setDictDataSaveVo(dictDataDtoConverter.tblDictDataToDictDataSaveDto(tblDictData));
        dictDataEditDto.setDictTypeList(iTblDictTypeService.findSelectDtoAll());
        return AjaxResultVo.ok(dictDataEditDto);
    }

    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public AjaxResultVo save(@Validated @RequestBody DictDataSaveDto entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResultVo.error(BindingResultUtils.bindingResultConverterString(bindingResult));
        }
        TblDictData tblDictData = iTblDictDataService.saveDto(entity);
        if (tblDictData != null) {
            return AjaxResultVo.ok("保存成功");
        }
        return AjaxResultVo.error("保存失败");
    }

    @GetMapping("/deleteById/{id}")
    public AjaxResultVo deleteById(@PathVariable("id")String id){
        iTblDictDataService.delteById(id);
        return AjaxResultVo.ok("删除数据成功");
    }
}
