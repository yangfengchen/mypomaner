package com.ddzj.mypomaner.buildcode.service;

import com.ddzj.mypomaner.entity.*;

import java.util.List;
import java.util.Map;

/**
 * 生成代码服务类
 * @Author:yangzibo
 * @CreateTime:2024-02-16 22:16
 * @Description:
 * @Version:1.0
 **/
public interface IBuildCodeService {

    /**
     * 生成代码文件
     * @param tblProjectInfo
     * @param tblProjectConfig
     * @param tblFieldConfigMap
     * @param tblProjectTable
     */
    void buildCodeFile(TblProjectInfo tblProjectInfo, TblProjectConfig tblProjectConfig,
                       Map<String, TblFieldConfig> tblFieldConfigMap, TblProjectTable tblProjectTable,
                       List<TblProjectField> tblProjectFieldList, Map<String, String> fieldTemplateMap);
}
