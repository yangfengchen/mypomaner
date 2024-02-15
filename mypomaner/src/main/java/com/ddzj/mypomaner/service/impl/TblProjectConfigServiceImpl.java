package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ddzj.mypomaner.dto.ProjectConfigSearchDto;
import com.ddzj.mypomaner.dto.ProjectInfoSearchPageDto;
import com.ddzj.mypomaner.entity.TblProjectConfig;
import com.ddzj.mypomaner.entity.TblProjectInfo;
import com.ddzj.mypomaner.mapper.TblProjectConfigMapper;
import com.ddzj.mypomaner.service.ITblProjectConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class TblProjectConfigServiceImpl extends ServiceImpl<TblProjectConfigMapper, TblProjectConfig> implements ITblProjectConfigService {


    @Override
    public List<TblProjectConfig> findByProjectCodeList(List<String> projectCodeList) {
        return this.baseMapper.selectList(buildLambdaQueryWrapper(projectCodeList));
    }

    @Override
    public TblProjectConfig findByProjectCode(String projectCode) {
        return this.baseMapper.selectOne(buildLambdaQueryWrapper(Arrays.asList(projectCode)));
    }

    public LambdaQueryWrapper<TblProjectConfig> buildLambdaQueryWrapper(List<String> projectCodeList){
        LambdaQueryWrapper<TblProjectConfig> lambdaQueryWrapper = new LambdaQueryWrapper<TblProjectConfig>();
        if(CollectionUtils.isNotEmpty(projectCodeList)){
            lambdaQueryWrapper.in(TblProjectConfig::getProjectCode, projectCodeList);
        }
        return lambdaQueryWrapper;
    }
}
