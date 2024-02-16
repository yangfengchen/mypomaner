package com.ddzj.mypomaner.buildcode.service.impl;

import com.ddzj.mypomaner.buildcode.entity.EntityClass;
import com.ddzj.mypomaner.buildcode.entity.TableClass;
import com.ddzj.mypomaner.buildcode.entity.TableColumn;
import com.ddzj.mypomaner.buildcode.service.IBuildCodeTemplateService;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-16 22:56
 * @Description:
 * @Version:1.0
 **/
public class BuildCodeMyBatisPlugsServiceImpl extends BuildCodeTemplateServiceImpl implements IBuildCodeTemplateService {

    @Override
    public void preProcessDate(TableClass tableClass,  EntityClass entityClass) {
        // 数据库字段都转换小写
        tableClass.setTableName(tableClass.getTableName().toLowerCase());

        if(CollectionUtils.isNotEmpty(tableClass.getColumnList())){
            for(TableColumn tableColumn : tableClass.getColumnList()){
                tableColumn.setColumnName(tableColumn.getColumnName().toLowerCase());
            }
        }

        if(CollectionUtils.isNotEmpty(tableClass.getStaticTableColumns())){
            for(TableColumn tableColumn : tableClass.getStaticTableColumns()){
                tableColumn.setColumnName(tableColumn.getColumnName().toLowerCase());
            }
        }


        //设置实体类继承的公共类
        entityClass.setExtendName("AbstractEntity");

    }
}
