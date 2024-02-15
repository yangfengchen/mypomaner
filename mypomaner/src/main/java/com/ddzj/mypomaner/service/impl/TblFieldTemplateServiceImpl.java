package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ddzj.mypomaner.dto.FieldTemplateSaveDto;
import com.ddzj.mypomaner.dto.FieldTemplateSearchDto;
import com.ddzj.mypomaner.entity.TblFieldTemplate;
import com.ddzj.mypomaner.mapper.TblFieldTemplateMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblFieldTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字段模板表; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblFieldTemplateServiceImpl extends ServiceImpl<TblFieldTemplateMapper, TblFieldTemplate> implements ITblFieldTemplateService {

    @Autowired
    private DateService dateService;

    @Override
    public List<TblFieldTemplate> findBySearchDto(FieldTemplateSearchDto searchDto) {
        return this.baseMapper.selectList(buildLambdaQueryWrapper(searchDto));
    }

    public LambdaQueryWrapper<TblFieldTemplate> buildLambdaQueryWrapper(FieldTemplateSearchDto searchDto){
        LambdaQueryWrapper<TblFieldTemplate> lambdaQueryWrapper = new LambdaQueryWrapper<TblFieldTemplate>();
        if(StringUtils.isNotBlank(searchDto.getTableId())){
            lambdaQueryWrapper.eq(TblFieldTemplate::getTableId, searchDto.getTableId());
        }
        if(searchDto.getEnabled() != null){
            lambdaQueryWrapper.eq(TblFieldTemplate::getEnabled, searchDto.getEnabled());
        }
        return lambdaQueryWrapper;
    }

    @Override
    public List<TblFieldTemplate> saveDtoList(List<FieldTemplateSaveDto> entitys) {
        if(CollectionUtils.isEmpty(entitys)){
            return Lists.newArrayList();
        }
        this.remove(buildTblFieldTempalteLambdaUpdateWrapper(entitys.get(0).getTableId()));
        List<TblFieldTemplate> tblFieldTemplateList = entitys.stream().map(entity->{
            return buildTblFieldTemplate(entity);
        }).collect(Collectors.toList());
        this.saveOrUpdateBatch(tblFieldTemplateList);
        return tblFieldTemplateList;
    }

    public LambdaUpdateWrapper<TblFieldTemplate> buildTblFieldTempalteLambdaUpdateWrapper(String code){
        LambdaUpdateWrapper<TblFieldTemplate> lambdaUpdateWrapper = new LambdaUpdateWrapper<TblFieldTemplate>();
        lambdaUpdateWrapper.eq(TblFieldTemplate::getTableId, code);
        return lambdaUpdateWrapper;
    }

    public TblFieldTemplate buildTblFieldTemplate(FieldTemplateSaveDto fieldTemplateSaveDto){
        TblFieldTemplate entity = new TblFieldTemplate();
        entity.setCreatedTime(dateService.getLocalDateTimeNow());
        entity.setId(fieldTemplateSaveDto.getId());
        entity.setFieldCode(fieldTemplateSaveDto.getFieldCode());
        entity.setFieldName(fieldTemplateSaveDto.getFieldName());
        entity.setFieldPrimary(fieldTemplateSaveDto.getFieldPrimary());
        entity.setFieldNull(fieldTemplateSaveDto.getFieldNull());
        entity.setFieldAuto(fieldTemplateSaveDto.getFieldAuto());
        entity.setFieldType(fieldTemplateSaveDto.getFieldType());
        entity.setFieldDataType(fieldTemplateSaveDto.getFieldDataType());
        entity.setFieldLen(fieldTemplateSaveDto.getFieldLen());
        entity.setFieldDecimal(fieldTemplateSaveDto.getFieldDecimal());
        entity.setFieldDec(fieldTemplateSaveDto.getFieldDec());
        entity.setFieldDefaultVal(fieldTemplateSaveDto.getFieldDefaultVal());
        entity.setFieldHtmlType(fieldTemplateSaveDto.getFieldHtmlType());
        entity.setTableId(fieldTemplateSaveDto.getTableId());
        entity.setEnabled(fieldTemplateSaveDto.getEnabled());
        entity.setFieldDtoStatus(fieldTemplateSaveDto.getFieldDtoStatus());
        entity.setFieldVoStatus(fieldTemplateSaveDto.getFieldVoStatus());
        return entity;
    }
}
