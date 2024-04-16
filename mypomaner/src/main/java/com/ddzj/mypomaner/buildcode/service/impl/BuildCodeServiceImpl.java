package com.ddzj.mypomaner.buildcode.service.impl;

import com.ddzj.mypomaner.buildcode.entity.ColumnClass;
import com.ddzj.mypomaner.buildcode.entity.EntityClass;
import com.ddzj.mypomaner.buildcode.entity.TableClass;
import com.ddzj.mypomaner.buildcode.entity.TableColumn;
import com.ddzj.mypomaner.buildcode.service.IBuildCodeService;
import com.ddzj.mypomaner.buildcode.service.IBuildCodeTemplateService;
import com.ddzj.mypomaner.entity.*;
import com.ddzj.mypomaner.service.DateService;
import com.ddzj.mypomaner.utils.UnderlineToCamelUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 生成代码服务类
 * @Author:yangzibo
 * @CreateTime:2024-02-16 22:16
 * @Description:
 * @Version:1.0
 **/
@Service
public class BuildCodeServiceImpl implements IBuildCodeService {

    @Autowired
    private DateService dateService;
    @Autowired
    private Environment environment;

    @Override
    public void buildCodeFile(TblProjectInfo tblProjectInfo, TblProjectConfig tblProjectConfig,
                              Map<String, TblFieldConfig> tblFieldConfigMap, TblProjectTable tblProjectTable,
                              List<TblProjectField> tblProjectFieldList, Map<String, String> fieldTemplateMap) {
        // 组装TableCLass 类数据, 字段和表名默认大写
        TableClass tableClass = new TableClass();
        tableClass.setTableDesc(tblProjectTable.getZnName());
        tableClass.setTableName(tblProjectTable.getName());

        // 组装EntityClass 实体类
        EntityClass entityClass = new EntityClass();
        if(StringUtils.isNotBlank(tblProjectTable.getPackageName())){
            entityClass.setClassPath(tblProjectTable.getPackageName());
        }else{
            entityClass.setClassPath(tblProjectInfo.getPackageName());
        }
        Date currentTime = dateService.getCurrentTime();
        entityClass.setCreateFileDate(DateFormatUtils.format(currentTime, "yyyy-MM-dd HH:mm:ss"));
        entityClass.setCreateFileDateYear(DateFormatUtils.format(currentTime, "yyyy"));
        entityClass.setCreateFileAuth("default");
        entityClass.setClassName(tblProjectTable.getCodeName());
        entityClass.setTableName(tblProjectTable.getName());
        entityClass.setDes(tblProjectTable.getZnName());
        // extendName 还没组装


        List<TableColumn> columnList = Lists.newArrayList();
        List<TableColumn> staticTableColumns = Lists.newArrayList();

        List<ColumnClass> columnClassList = Lists.newArrayList();

        for(TblProjectField tblProjectField : tblProjectFieldList){
            // 组装数据库表
            TableColumn tableColumn = buildTableColumn(tblProjectField, tblFieldConfigMap);
            if(StringUtils.isNotBlank(fieldTemplateMap.get(tblProjectField.getFieldCode()))){
                staticTableColumns.add(tableColumn);
            }else{
                columnList.add(tableColumn);
            }
            // 组装实体类 基础类跳过
            if(!StringUtils.isNotBlank(fieldTemplateMap.get(tblProjectField.getFieldCode()))){
                columnClassList.add(buildEntityClass(tableColumn, tblProjectField, tblFieldConfigMap));
            }
        }

        tableClass.setColumnList(columnList);
        tableClass.setStaticTableColumns(staticTableColumns);

        entityClass.setColumnClassList(columnClassList);

        String codeTemplateFilePath = environment.getProperty("codeTemplateFilePath");
        String codeOutPutFilePath = environment.getProperty("codeOutPutFilePath");
        IBuildCodeTemplateService iBuildCodeTemplateService = null;
        if(StringUtils.equals(tblProjectConfig.getCodeType(), "mybatis-plugs")){
            iBuildCodeTemplateService = new BuildCodeMyBatisPlugsServiceImpl();
        }
        codeTemplateFilePath += "/"+tblProjectConfig.getCodeType() ;
        iBuildCodeTemplateService.buildCodeFile(tableClass, entityClass, codeTemplateFilePath, codeOutPutFilePath);

    }

    public ColumnClass buildEntityClass(TableColumn tableColumn, TblProjectField tblProjectField, Map<String, TblFieldConfig> tblFieldConfigMap){
        ColumnClass columnClass = new ColumnClass();
        columnClass.setColumnName(tableColumn.getColumnName());
        if(tblFieldConfigMap.get(tblProjectField.getFieldDataType()) != null) {
            TblFieldConfig tblFieldConfig = tblFieldConfigMap.get(tblProjectField.getFieldDataType());
            columnClass.setColumnType(tblFieldConfig.getFieldCodeType());
            if(StringUtils.isNotBlank(tblFieldConfig.getFieldDefLen()) ||
                    StringUtils.isBlank(tblFieldConfig.getFieldDefDecimal())){
                columnClass.setColumnLength(tblFieldConfig.getFieldDefLen());
            }
        }
        columnClass.setChangeColumnName(UnderlineToCamelUtils.underlineToCamel(tableColumn.getColumnName(), false));
        columnClass.setColumnComment(tableColumn.getDes());
        columnClass.setChangeColumnNameDx(getDx(columnClass.getChangeColumnName()));
        return columnClass;
    }

    public TableColumn buildTableColumn(TblProjectField tblProjectField, Map<String, TblFieldConfig> tblFieldConfigMap){
        TableColumn tableColumn = new TableColumn();
        tableColumn.setColumnName(tblProjectField.getFieldCode());
        if(tblFieldConfigMap.get(tblProjectField.getFieldDataType()) != null){
            TblFieldConfig tblFieldConfig = tblFieldConfigMap.get(tblProjectField.getFieldDataType());
            String columnType = "";
            if(StringUtils.isNotBlank(tblFieldConfig.getFieldDefLen())){
                if(StringUtils.isNotBlank(tblFieldConfig.getFieldDefDecimal())){
                    columnType += tblFieldConfig.getFieldBaseType() + "("+tblFieldConfig.getFieldDefLen()+","+ tblFieldConfig.getFieldDefDecimal()+")";
                }else{
                    columnType += tblFieldConfig.getFieldBaseType() + "("+tblFieldConfig.getFieldDefLen()+")";
                }
            }else{
                columnType += tblFieldConfig.getFieldBaseType() ;
            }
            tableColumn.setColumnType(columnType);
        }
        tableColumn.setDes(tblProjectField.getFieldName());
        return tableColumn;
    }

    private static String getDx(String file){
        return file.substring(0,1).toUpperCase() + file.substring(1);
    }
}
