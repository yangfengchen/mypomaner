package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ddzj.mypomaner.entity.TblProjectField;
import com.ddzj.mypomaner.mapper.TblProjectFieldMapper;
import com.ddzj.mypomaner.service.ITblProjectFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目字段表; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblProjectFieldServiceImpl extends ServiceImpl<TblProjectFieldMapper, TblProjectField> implements ITblProjectFieldService {

    @Override
    public List<TblProjectField> findByProjectCodeAndTableId(String projectCode, String tableId) {
        return this.baseMapper.selectList(buildLambdaQueryWrapper(projectCode, tableId));
    }

    public LambdaQueryWrapper<TblProjectField> buildLambdaQueryWrapper(String project, String tableId){
        LambdaQueryWrapper<TblProjectField> lambdaQueryWrapper = new LambdaQueryWrapper<TblProjectField>();
        lambdaQueryWrapper.eq(TblProjectField::getProjectCode, project);
        lambdaQueryWrapper.eq(TblProjectField::getTableId, tableId);
        return lambdaQueryWrapper;
    }
}
