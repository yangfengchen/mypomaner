package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ddzj.mypomaner.dto.FileTemplateSaveDto;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.entity.TblFileTemplate;
import com.ddzj.mypomaner.mapper.TblFileTemplateMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblFileTemplateService;
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
public class TblFileTemplateServiceImpl extends ServiceImpl<TblFileTemplateMapper, TblFileTemplate> implements ITblFileTemplateService {

    @Autowired
    private DateService dateService;

    @Override
    public List<TblFileTemplate> saveDtoList(List<FileTemplateSaveDto> entitys) {
        if(CollectionUtils.isEmpty(entitys)){
            return Lists.newArrayList();
        }
        this.remove(new QueryWrapper<TblFileTemplate>());
        List<TblFileTemplate> tblFileTemplateList = entitys.stream().map(entity->{
            return buildTblFileTemplate(entity);
        }).collect(Collectors.toList());
        this.saveOrUpdateBatch(tblFileTemplateList);
        return tblFileTemplateList;
    }

    public TblFileTemplate buildTblFileTemplate(FileTemplateSaveDto fileTemplateSaveDto){
        TblFileTemplate entity = new TblFileTemplate();
        entity.setCreatedTime(dateService.getLocalDateTimeNow());
        entity.setId(entity.getId());
        entity.setFileCode(fileTemplateSaveDto.getFileCode());
        entity.setFileName(fileTemplateSaveDto.getFileName());
        entity.setFilePrimary(fileTemplateSaveDto.getFilePrimary());
        entity.setFileNull(fileTemplateSaveDto.getFileNull());
        entity.setFileAuto(fileTemplateSaveDto.getFileAuto());
        entity.setFileType(fileTemplateSaveDto.getFileType());
        entity.setFileDataType(fileTemplateSaveDto.getFileDataType());
        entity.setFileLen(fileTemplateSaveDto.getFileLen());
        entity.setFileDecimal(fileTemplateSaveDto.getFileDecimal());
        entity.setFileDec(fileTemplateSaveDto.getFileDec());
        entity.setFileDefaultVal(fileTemplateSaveDto.getFileDefaultVal());
        entity.setFileHtmlType(fileTemplateSaveDto.getFileHtmlType());
        entity.setTableId(fileTemplateSaveDto.getTableId());
        entity.setEnabled(fileTemplateSaveDto.getEnabled());
        return entity;
    }
}
