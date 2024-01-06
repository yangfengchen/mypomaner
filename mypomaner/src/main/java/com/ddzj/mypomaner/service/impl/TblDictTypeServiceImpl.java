package com.ddzj.mypomaner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddzj.mypomaner.customexception.ServiceException;
import com.ddzj.mypomaner.dto.DictTypeEditDto;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.mapper.TblDictDataMapper;
import com.ddzj.mypomaner.mapper.TblDictTypeMapper;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.service.ITblDictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典表; 服务实现类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@Service
public class TblDictTypeServiceImpl extends ServiceImpl<TblDictTypeMapper, TblDictType> implements ITblDictTypeService {

    @Autowired
    private DateService dateService;
    @Autowired
    private TblDictDataMapper tblDictDataMapper;

    @Override
    public TblDictType findByDictType(String dictType) {
        return this.baseMapper.findByDictType(dictType);
    }

    @Override
    public IPage<TblDictType> queryPageByEntityDto(IPage<?> page, DictTypeSearchPageDto entityDto) {
        return this.baseMapper.queryPageByEntityDto(page, entityDto);
    }

    @Override
    public TblDictType findById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public TblDictType saveDto(DictTypeEditDto dictTypeEditDto) {
        TblDictType entity = this.baseMapper.selectById(dictTypeEditDto.getId());
        if (entity == null) {
            entity = new TblDictType();
            entity.setId(dictTypeEditDto.getId());
            entity.setCreatedTime(dateService.getLocalDateTimeNow());
        }
        TblDictType oldDictType = this.baseMapper.findByDictType(dictTypeEditDto.getDictType());
        if (oldDictType != null) {
            if (!StringUtils.equals(oldDictType.getId(), entity.getId())) {
                throw new ServiceException("类型已经存在！");
            }
        }
        entity.setDictType(dictTypeEditDto.getDictType());
        entity.setDictName(dictTypeEditDto.getDictName());
        entity.setUpdatedTime(dateService.getLocalDateTimeNow());
        /*int i = 0;
        if(isUpdate){
            i = this.baseMapper.update(entity, new UpdateWrapper<TblDictType>().eq("id", entity.getId()));
        }else{
            i = this.baseMapper.insert(entity);
        }*/

        if (this.saveOrUpdate(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public List<SelectDto> findSelectDtoAll() {
        List<TblDictType> tblDictTypes = this.list();
        return tblDictTypes.stream()
                .map(a -> {
                    SelectDto selectDto = new SelectDto();
                    selectDto.setLabel(a.getDictName());
                    selectDto.setValue(a.getDictType());
                    return selectDto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<TblDictType> findListByDictType(List<String> dictTypes) {
        return this.baseMapper.findListByDictType(dictTypes);
    }

    @Override
    public void delteById(String id) {
        TblDictType tblDictType = this.baseMapper.selectById(id);
        tblDictDataMapper.delete(new UpdateWrapper<TblDictData>().eq("dict_code", tblDictType.getDictType()));
        this.baseMapper.delete(new UpdateWrapper<TblDictType>().eq("id", id));
    }
}
