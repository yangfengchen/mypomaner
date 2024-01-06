package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.dto.FieldConfigSaveDto;
import com.ddzj.mypomaner.dto.FieldConfigSearchPageDto;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.mapper.TblFieldConfigMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblFieldConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目配置; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblFieldConfigServiceImpl extends ServiceImpl<TblFieldConfigMapper, TblFieldConfig> implements ITblFieldConfigService {

    @Autowired
    private DateService dateService;

    @Override
    public IPage<TblFieldConfig> queryPageByEntityDto(Page<TblFieldConfig> page, FieldConfigSearchPageDto entityDto) {
        return this.baseMapper.selectPage(page, buildLambdaQueryWrapper(entityDto));
    }

    @Override
    public TblFieldConfig findById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public TblFieldConfig saveDto(FieldConfigSaveDto entity) {
        TblFieldConfig tblFieldConfig = this.findById(entity.getId());
        if(tblFieldConfig == null){
            tblFieldConfig = new TblFieldConfig();
            tblFieldConfig.setCreatedTime(dateService.getLocalDateTimeNow());
            tblFieldConfig.setId(entity.getId());
        }
        tblFieldConfig.setDatabaseType(entity.getDatabaseType());
        tblFieldConfig.setFieldDbType(entity.getFieldDbType());
        tblFieldConfig.setFieldCodeType(entity.getFieldCodeType());
        tblFieldConfig.setFieldBaseType(entity.getFieldBaseType());
        tblFieldConfig.setFieldDefLen(entity.getFieldDefLen());
        tblFieldConfig.setFieldDefDecimal(entity.getFieldDefDecimal());
        tblFieldConfig.setUpdatedTime(dateService.getLocalDateTimeNow());
        this.saveOrUpdate(tblFieldConfig);
        return tblFieldConfig;
    }

    @Override
    public void delteById(String id) {
        this.removeById(id);
    }

    @Override
    public List<TblFieldConfig> findByDatabaseType(String databaseType) {
        FieldConfigSearchPageDto fieldConfigSearchPageDto = new FieldConfigSearchPageDto();
        fieldConfigSearchPageDto.setDatabaseType(databaseType);
        return this.list(buildLambdaQueryWrapper(fieldConfigSearchPageDto));
    }

    public LambdaQueryWrapper<TblFieldConfig> buildLambdaQueryWrapper(FieldConfigSearchPageDto fieldConfigSearchPageDto){
        LambdaQueryWrapper<TblFieldConfig> lambdaQueryWrapper = new LambdaQueryWrapper<TblFieldConfig>();
        if(StringUtils.isNotBlank(fieldConfigSearchPageDto.getDatabaseType())){
            lambdaQueryWrapper.eq(TblFieldConfig::getDatabaseType, fieldConfigSearchPageDto.getDatabaseType());
        }
        if(StringUtils.isNotBlank(fieldConfigSearchPageDto.getFieldDbType())){
            lambdaQueryWrapper.eq(TblFieldConfig::getFieldDbType, fieldConfigSearchPageDto.getFieldDbType());
        }
        return lambdaQueryWrapper;
    }
}
