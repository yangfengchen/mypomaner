package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.DictDataSaveDto;
import com.ddzj.mypomaner.dto.DictDataSearchDto;
import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.mapper.TblDictDataMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典数据表; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblDictDataServiceImpl extends ServiceImpl<TblDictDataMapper, TblDictData> implements ITblDictDataService {

    @Autowired
    private DateService dateService;

    @Override
    public List<TblDictData> findByDictCode(String dictCode) {
        return this.baseMapper.findByDictCode(dictCode);
    }

    @Override
    public IPage<TblDictData> queryPageByEntityDto(IPage<?> page, DictDataSearchDto entityDto) {
        return this.baseMapper.queryPageByEntityDto(page, entityDto);
    }

    @Override
    public TblDictData saveDto(DictDataSaveDto entityDto) {
        TblDictData entity = this.baseMapper.selectById(entityDto.getId());
        if (entity == null) {
            entity = new TblDictData();
            entity.setId(entityDto.getId());
            entity.setCreatedTime(dateService.getLocalDateTimeNow());
        }
        if(entityDto.getDictSort() == null){
            Integer dictSort = this.baseMapper.getMaxSortByDictCode(entityDto.getDictCode());
            dictSort = dictSort == null ? 0 : dictSort+1;
            entity.setDictSort(dictSort);
        }

        entity.setDictLabel(entityDto.getDictLabel());
        entity.setDictValue(entityDto.getDictValue());
        entity.setDictCode(entityDto.getDictCode());
        entity.setUpdatedTime(dateService.getLocalDateTimeNow());

        if (this.saveOrUpdate(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public void delteById(String id) {
        this.remove(new QueryWrapper<TblDictData>().eq("id", id));
    }
}
