package com.ddzj.mypomaner.buildcode.service;

import com.ddzj.mypomaner.buildcode.entity.EntityClass;
import com.ddzj.mypomaner.buildcode.entity.TableClass;

/**
 * 生成代码工厂类
 * @Author:yangzibo
 * @CreateTime:2024-02-16 22:54
 * @Description:
 * @Version:1.0
 **/
public interface IBuildCodeTemplateService {

    /**
     * 生成代码文件
     * @param tableClass
     * @param entityClass
     * @param codeTemplateFilePath
     * @param codeOutPutFilePath
     */
    void buildCodeFile(TableClass tableClass,  EntityClass entityClass, String codeTemplateFilePath,
                       String codeOutPutFilePath);

    /**
     * 先处理数据
     * @param tableClass
     * @param entityClass
     */
    void preProcessDate(TableClass tableClass,  EntityClass entityClass);

}
