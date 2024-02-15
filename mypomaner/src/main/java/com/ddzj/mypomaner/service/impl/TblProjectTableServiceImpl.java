package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.*;
import com.ddzj.mypomaner.dto.converterdto.ProjectFieldDtoConverter;
import com.ddzj.mypomaner.entity.*;
import com.ddzj.mypomaner.mapper.TblProjectFieldMapper;
import com.ddzj.mypomaner.mapper.TblProjectTableMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblProjectTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目表管理; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblProjectTableServiceImpl extends ServiceImpl<TblProjectTableMapper, TblProjectTable> implements ITblProjectTableService {

    @Autowired
    private DateService dateService;
    @Autowired
    private TblProjectFieldMapper tblProjectFieldMapper;
    @Autowired
    private ProjectFieldDtoConverter projectFieldDtoConverter;

    @Override
    public IPage<TblProjectTable> queryPageByEntityDto(IPage<TblProjectTable> page, ProjectTableSearchPageDto searchPageDto) {
        return this.baseMapper.selectPage(page, buildLambdaQueryWrapper(searchPageDto));
    }

    @Override
    public TblProjectTable findById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public TblProjectTable saveDto(ProjectTableSaveDto saveDto) {
        TblProjectTable entity = buildSaveDtoToEntity(saveDto);
        this.saveOrUpdate(entity);

        tblProjectFieldMapper.delete(buildConfigLambdaUpdateWrapper(entity.getProjectCode(), entity.getId()));

        List<ProjectFieldSaveDto> projectFieldSaveDtos = saveDto.getFieldSaveDtoList();
        if(CollectionUtils.isNotEmpty(projectFieldSaveDtos)){
            for(ProjectFieldSaveDto projectFieldSaveDto : projectFieldSaveDtos){
                TblProjectField tblProjectField = projectFieldDtoConverter.saveDtoToFiledEntity(projectFieldSaveDto);
                tblProjectField.setProjectCode(entity.getProjectCode());
                tblProjectField.setTableId(entity.getId());
                tblProjectFieldMapper.insert(tblProjectField);
            }
        }
        return entity;
    }

    @Override
    public void delteById(String id) {
        TblProjectTable tblProjectInfo = this.baseMapper.selectById(id);
        tblProjectFieldMapper.delete(buildConfigLambdaUpdateWrapper(tblProjectInfo.getProjectCode(), tblProjectInfo.getId()));
        this.removeById(id);
    }

    public LambdaQueryWrapper<TblProjectTable> buildLambdaQueryWrapper(ProjectTableSearchPageDto searchPageDto){
        LambdaQueryWrapper<TblProjectTable> lambdaQueryWrapper = new LambdaQueryWrapper<TblProjectTable>();
        if(StringUtils.isNotBlank(searchPageDto.getProjectCode())){
            lambdaQueryWrapper.eq(TblProjectTable::getProjectCode, searchPageDto.getProjectCode());
        }
        if(StringUtils.isNotBlank(searchPageDto.getName())){
            lambdaQueryWrapper.like(TblProjectTable::getName, searchPageDto.getName());
        }
        if(StringUtils.isNotBlank(searchPageDto.getZnName())){
            lambdaQueryWrapper.like(TblProjectTable::getZnName, searchPageDto.getZnName());
        }
        if(StringUtils.isNotBlank(searchPageDto.getCodeName())){
            lambdaQueryWrapper.like(TblProjectTable::getCodeName, searchPageDto.getCodeName());
        }
        lambdaQueryWrapper.orderByDesc(TblProjectTable::getCreatedTime);
        lambdaQueryWrapper.orderByDesc(TblProjectTable::getId);
        return lambdaQueryWrapper;
    }

    private TblProjectTable buildSaveDtoToEntity(ProjectTableSaveDto saveDto){
        TblProjectTable entity = this.findById(saveDto.getId());
        if(entity == null){
            entity = new TblProjectTable();
            entity.setCreatedTime(dateService.getLocalDateTimeNow());
            entity.setId(saveDto.getId());
        }
        entity.setProjectCode(saveDto.getProjectCode());
        if(BooleanUtils.isTrue(saveDto.getEnabled())){
            entity.setEnabled(Boolean.TRUE);
        }else{
            entity.setEnabled(Boolean.FALSE);
        }
        entity.setName(saveDto.getName());
        entity.setCodeName(saveDto.getCodeName());
        entity.setPrefixName(saveDto.getPrefixName());
        entity.setZnName(saveDto.getZnName());
        entity.setPackageName(saveDto.getPackageName());
        entity.setUpdatedTime(dateService.getLocalDateTimeNow());
        return entity;
    }

    public LambdaUpdateWrapper<TblProjectField> buildConfigLambdaUpdateWrapper(String projectCode, String tableId){
        LambdaUpdateWrapper<TblProjectField> lambdaUpdateWrapper = new LambdaUpdateWrapper<TblProjectField>();
        lambdaUpdateWrapper.eq(TblProjectField::getProjectCode, projectCode);
        lambdaUpdateWrapper.eq(TblProjectField::getTableId, tableId);
        return lambdaUpdateWrapper;
    }

}
