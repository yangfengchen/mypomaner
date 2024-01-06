package com.ddzj.mypomaner.service.common.impl;

import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.dto.converterdto.SelectDtoConverter;
import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.service.ITblDictDataService;
import com.ddzj.mypomaner.service.common.ISelectDictDataCommonService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-02 07:27
 * @Description:
 * @Version:1.0
 **/
@Service
public class SelectDictDataCommonServiceImpl implements ISelectDictDataCommonService {

    @Autowired
    private ITblDictDataService iTblDictDataService;
    @Autowired
    private SelectDtoConverter selectDtoConverter;
    
    @Override
    public List<SelectDto> getDbTypeSelectList() {
        return findByDictCode(DB_TYPE);
    }

    @Override
    public Map<String, String> getDbTypeSelectMap() {
        return buildSelectMap(DB_TYPE);
    }

    @Override
    public List<SelectDto> getFieldDbTypeSelectList() {
        return findByDictCode(FIELD_DB_TYPE);
    }

    @Override
    public Map<String, String> getFieldDbTypeSelectMap() {
        return buildSelectMap(FIELD_DB_TYPE);
    }

    private Map<String, String> buildSelectMap(String dictCode){
        List<SelectDto> selectDtoList = findByDictCode(dictCode);
        return selectDtoList.stream()
                .collect(Collectors.toMap(SelectDto::getValue, SelectDto::getLabel, (k1,k2)->k2));
    }
    
    private List<SelectDto> findByDictCode(String dictCode){
        List<TblDictData> tblDictData = iTblDictDataService.findByDictCode(dictCode);
        if(CollectionUtils.isEmpty(tblDictData)){
            return new ArrayList<>();
        }
        return selectDtoConverter.tblDictDataToSelectDto(tblDictData);
    }
}
