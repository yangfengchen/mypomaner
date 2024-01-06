package com.ddzj.mypomaner.service.common;

import com.ddzj.mypomaner.dto.SelectDto;

import java.util.List;
import java.util.Map;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-02 07:27
 * @Description:
 * @Version:1.0
 **/
public interface ISelectDictDataCommonService {

    //数据库类型
    String DB_TYPE = "dbType";

    //数据库字段类型
    String FIELD_DB_TYPE = "fieldDbType";

    /**
     * 获取数据库类型 list
     * @return
     */
    List<SelectDto> getDbTypeSelectList();


    /**
     * 获取数据库字段类型 Map
     * @return
     */
    Map<String, String> getDbTypeSelectMap();
    
    /**
     * 获取数据库字段类型
     * @return
     */
    List<SelectDto> getFieldDbTypeSelectList();

    /**
     * 获取数据库字段类型
     * @return
     */
    Map<String, String> getFieldDbTypeSelectMap();
}
