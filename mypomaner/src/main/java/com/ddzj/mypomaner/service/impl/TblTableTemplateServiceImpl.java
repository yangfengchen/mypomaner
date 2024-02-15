package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.FieldConfigSaveDto;
import com.ddzj.mypomaner.dto.FieldConfigSearchPageDto;
import com.ddzj.mypomaner.dto.TableTemplateSaveDto;
import com.ddzj.mypomaner.dto.TableTemplateSearchPageDto;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.mapper.TblTableTemplateMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblTableTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表模板; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblTableTemplateServiceImpl extends ServiceImpl<TblTableTemplateMapper, TblTableTemplate> implements ITblTableTemplateService {

    @Autowired
    private DateService dateService;

    @Override
    public IPage<TblTableTemplate> queryPageByEntityDto(IPage<TblTableTemplate> page, TableTemplateSearchPageDto entityDto) {
        return this.baseMapper.selectPage(page, buildLambdaQueryWrapper(entityDto));
    }

    @Override
    public TblTableTemplate findById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public TblTableTemplate saveDto(TableTemplateSaveDto saveDto) {
        TblTableTemplate entity = buildSaveDtoToEntity(saveDto);
        this.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delteById(String id) {
        this.removeById(id);
    }

    public LambdaQueryWrapper<TblTableTemplate> buildLambdaQueryWrapper(TableTemplateSearchPageDto entityDto){
        LambdaQueryWrapper<TblTableTemplate> lambdaQueryWrapper = new LambdaQueryWrapper<TblTableTemplate>();
        if(StringUtils.isNotBlank(entityDto.getName())){
            lambdaQueryWrapper.like(TblTableTemplate::getName, entityDto.getName());
        }
        if(StringUtils.isNotBlank(entityDto.getCode())){
            lambdaQueryWrapper.eq(TblTableTemplate::getCode, entityDto.getCode());
        }
        return lambdaQueryWrapper;
    }

    private TblTableTemplate buildSaveDtoToEntity(TableTemplateSaveDto saveDto){
        TblTableTemplate entity = this.findById(saveDto.getId());
        if(entity == null){
            entity = new TblTableTemplate();
            entity.setCreatedTime(dateService.getLocalDateTimeNow());
            entity.setId(entity.getId());
        }
        entity.setName(saveDto.getName());
        entity.setCode(saveDto.getCode());
        if(BooleanUtils.isTrue(saveDto.getEnabled())){
            entity.setEnabled(Boolean.TRUE);
        }else{
            entity.setEnabled(Boolean.FALSE);
        }
        entity.setUpdatedTime(dateService.getLocalDateTimeNow());
        return entity;
    }
}
