package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.ProjectConfigSearchDto;
import com.ddzj.mypomaner.dto.ProjectInfoSaveDto;
import com.ddzj.mypomaner.dto.ProjectInfoSearchPageDto;
import com.ddzj.mypomaner.entity.*;
import com.ddzj.mypomaner.mapper.TblProjectConfigMapper;
import com.ddzj.mypomaner.mapper.TblProjectFieldMapper;
import com.ddzj.mypomaner.mapper.TblProjectInfoMapper;
import com.ddzj.mypomaner.mapper.TblProjectTableMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblProjectInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddzj.mypomaner.utils.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目信息表; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblProjectInfoServiceImpl extends ServiceImpl<TblProjectInfoMapper, TblProjectInfo> implements ITblProjectInfoService {

    @Autowired
    private DateService dateService;
    @Autowired
    private TblProjectConfigMapper tblProjectConfigMapper;
    @Autowired
    private TblProjectTableMapper tblProjectTableMapper;
    @Autowired
    private TblProjectFieldMapper tblProjectFieldMapper;

    @Override
    public IPage<TblProjectInfo> queryPageByEntityDto(IPage<TblProjectInfo> page, ProjectInfoSearchPageDto searchPageDto) {
        return this.baseMapper.selectPage(page, buildLambdaQueryWrapper(searchPageDto));
    }

    @Override
    public TblProjectInfo findById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public TblProjectInfo saveDto(ProjectInfoSaveDto saveDto) {
        TblProjectInfo entity = buildSaveDtoToEntity(saveDto);
        this.saveOrUpdate(entity);

        ProjectConfigSearchDto configSearchDto = new ProjectConfigSearchDto();
        configSearchDto.setProjectCode(saveDto.getProjectCode());
        TblProjectConfig configEntity = tblProjectConfigMapper.selectOne(buildConfigLambdaQueryWrapper(configSearchDto));
        boolean isUpdate = true;
        if(configEntity == null){
            configEntity = new TblProjectConfig();
            configEntity.setId(IdUtils.getSnowflakeIdWorkerId());
            configEntity.setCreatedTime(dateService.getLocalDateTimeNow());
            isUpdate = false;
        }
        configEntity.setProjectCode(saveDto.getProjectCode());
        configEntity.setCodeType(saveDto.getCodeType());
        configEntity.setDatabaseType(saveDto.getDatabaseType());
        configEntity.setTableTemplateCode(saveDto.getTableTemplateCode());
        if(isUpdate){
            tblProjectConfigMapper.updateById(configEntity);
        }else{
            tblProjectConfigMapper.insert(configEntity);
        }
        return entity;
    }

    @Override
    public void delteById(String id) {
        TblProjectInfo tblProjectInfo = this.baseMapper.selectById(id);
        tblProjectConfigMapper.delete(buildConfigLambdaUpdateWrapper(tblProjectInfo.getProjectCode()));
        tblProjectTableMapper.delete(buildTableLambdaUpdateWrapper(tblProjectInfo.getProjectCode()));
        tblProjectFieldMapper.delete(buildFiledLambdaUpdateWrapper(tblProjectInfo.getProjectCode()));
        this.removeById(id);
    }

    @Override
    public List<TblProjectInfo> findListBySearchDto(ProjectInfoSearchPageDto searchDto) {
        return this.baseMapper.selectList(buildLambdaQueryWrapper(searchDto));
    }

    @Override
    public TblProjectInfo findByProjectCode(String projectCode) {
        ProjectInfoSearchPageDto searchPageDto = new ProjectInfoSearchPageDto();
        searchPageDto.setProjectCode(projectCode);
        return this.baseMapper.selectOne(buildLambdaQueryWrapper(searchPageDto));
    }

    public LambdaQueryWrapper<TblProjectInfo> buildLambdaQueryWrapper(ProjectInfoSearchPageDto searchPageDto){
        LambdaQueryWrapper<TblProjectInfo> lambdaQueryWrapper = new LambdaQueryWrapper<TblProjectInfo>();
        if(StringUtils.isNotBlank(searchPageDto.getProjectName())){
            lambdaQueryWrapper.like(TblProjectInfo::getProjectName, searchPageDto.getProjectName());
        }
        if(StringUtils.isNotBlank(searchPageDto.getProjectCode())){
            lambdaQueryWrapper.eq(TblProjectInfo::getProjectCode, searchPageDto.getProjectCode());
        }
        if(StringUtils.isNotBlank(searchPageDto.getProjectZnName())){
            lambdaQueryWrapper.like(TblProjectInfo::getProjectZnName, searchPageDto.getProjectZnName());
        }
        lambdaQueryWrapper.orderByDesc(TblProjectInfo::getCreatedTime);
        lambdaQueryWrapper.orderByDesc(TblProjectInfo::getId);
        return lambdaQueryWrapper;
    }

    private TblProjectInfo buildSaveDtoToEntity(ProjectInfoSaveDto saveDto){
        TblProjectInfo entity = this.findById(saveDto.getId());
        if(entity == null){
            entity = new TblProjectInfo();
            entity.setCreatedTime(dateService.getLocalDateTimeNow());
            entity.setId(saveDto.getId());
        }
        entity.setProjectCode(saveDto.getProjectCode());
        entity.setProjectName(saveDto.getProjectName());
        entity.setProjectZnName(saveDto.getProjectZnName());
        entity.setPackageName(saveDto.getPackageName());
        entity.setUpdatedTime(dateService.getLocalDateTimeNow());
        return entity;
    }

    public LambdaQueryWrapper<TblProjectConfig> buildConfigLambdaQueryWrapper(ProjectConfigSearchDto searchPageDto){
        LambdaQueryWrapper<TblProjectConfig> lambdaQueryWrapper = new LambdaQueryWrapper<TblProjectConfig>();
        if(StringUtils.isNotBlank(searchPageDto.getProjectCode())){
            lambdaQueryWrapper.like(TblProjectConfig::getProjectCode, searchPageDto.getProjectCode());
        }
        return lambdaQueryWrapper;
    }

    public LambdaUpdateWrapper<TblProjectConfig> buildConfigLambdaUpdateWrapper(String projectCode){
        LambdaUpdateWrapper<TblProjectConfig> lambdaUpdateWrapper = new LambdaUpdateWrapper<TblProjectConfig>();
        lambdaUpdateWrapper.eq(TblProjectConfig::getProjectCode, projectCode);
        return lambdaUpdateWrapper;
    }

    public LambdaUpdateWrapper<TblProjectTable> buildTableLambdaUpdateWrapper(String projectCode){
        LambdaUpdateWrapper<TblProjectTable> lambdaUpdateWrapper = new LambdaUpdateWrapper<TblProjectTable>();
        lambdaUpdateWrapper.eq(TblProjectTable::getProjectCode, projectCode);
        return lambdaUpdateWrapper;
    }

    public LambdaUpdateWrapper<TblProjectField> buildFiledLambdaUpdateWrapper(String projectCode){
        LambdaUpdateWrapper<TblProjectField> lambdaUpdateWrapper = new LambdaUpdateWrapper<TblProjectField>();
        lambdaUpdateWrapper.like(TblProjectField::getProjectCode, projectCode);
        return lambdaUpdateWrapper;
    }

}
