package com.ddzj.mypomaner;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.ddzj.mypomaner.buildcode.entity.ColumnClass;
import com.ddzj.mypomaner.buildcode.entity.EntityClass;
import com.ddzj.mypomaner.utils.JacksonUtil;
import com.ddzj.mypomaner.utils.JdbcUtils;
import com.ddzj.mypomaner.utils.UnderlineToCamelUtils;
import com.ddzj.mypomaner.vo.TableInfoVo;
import com.mysql.cj.xdevapi.Column;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yangzibo
 * @CreateTime:2024-05-01 00:20
 * @Description:
 * @Version:1.0
 **/
public class TestDb {

    private static final Map<String, String> DBTYPE_JAVATYPE_MAP = new HashMap<>();

    static {
        DBTYPE_JAVATYPE_MAP.put("bigint", "Long");
        DBTYPE_JAVATYPE_MAP.put("int", "Integer");
        DBTYPE_JAVATYPE_MAP.put("varchar", "String");
        DBTYPE_JAVATYPE_MAP.put("text", "String");
        DBTYPE_JAVATYPE_MAP.put("tinytext", "String");
        DBTYPE_JAVATYPE_MAP.put("tinyint", "Boolean");
    }

    public static void main(String[] args) throws SQLException {
        Map<String, List<TableInfoVo>> tableInfoVoMap = getTableInfo();
        // 组装table信息
        List<EntityClass> entityClasses = Lists.newArrayList();
        for (Map.Entry<String, List<TableInfoVo>> entity : tableInfoVoMap.entrySet()) {
            EntityClass entityClass = new EntityClass();
            entityClass.setDes("");
            entityClass.setCreateFileDateYear("2024");
            entityClass.setCreateFileDate("2024-05-01");
            entityClass.setCreateFileAuth("hndy");
            entityClass.setClassPath("com.hndy.usercenter");
            entityClass.setTableName(entity.getKey());
            entityClass.setClassName(UnderlineToCamelUtils.underlineToCamel(entity.getKey().replace("t_", ""), false));
            List<ColumnClass> columnClassList = Lists.newArrayList();
            for (TableInfoVo tableInfoVo : entity.getValue()) {
                ColumnClass columnClass = new ColumnClass();
                columnClass.setColomnDbName(tableInfoVo.getColumnName());
                columnClass.setColumnName(tableInfoVo.getColumnName());
                columnClass.setChangeColumnName(tableInfoVo.getColumnName());
                columnClass.setColumnComment(tableInfoVo.getColumnComment());
                columnClass.setColumnType(DBTYPE_JAVATYPE_MAP.get(tableInfoVo.getDataType()));
                if(StringUtils.isNotBlank(tableInfoVo.getExtra()) && StringUtils.equals(tableInfoVo.getExtra(), "auto_increment")){
                    columnClass.setAutoIncrement(true);
                }else{
                    columnClass.setAutoIncrement(false);
                }
                columnClassList.add(columnClass);
            }
            entityClass.setColumnClassList(columnClassList);
            entityClasses.add(entityClass);
        }
        String codeTemplateFilePath = "/Users/zz/Documents/work/studywork/mypomaner/mypomaner/src/main/resources/codetemplate/dy-mybatis-plugs";
        String codeOutPutFilePath = "/Users/zz/Documents/temp/my-hndy";
        for(EntityClass entityClass : entityClasses){
            buildEntityJava(entityClass, codeTemplateFilePath, codeOutPutFilePath );
            buildServiceAndRepositoryJava(entityClass, codeTemplateFilePath, codeOutPutFilePath);
        }
    }

    private static void buildEntityJava(EntityClass entityClass, String codeTemplateFilePath, String codeOutPutFilePath){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.getVersion());
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(codeTemplateFilePath));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("className",entityClass.getClassName());
            dataMap.put("tableName",entityClass.getTableName());
            dataMap.put("model_column",entityClass.getColumnClassList());
            dataMap.put("classPath",entityClass.getClassPath());
            dataMap.put("classDes",entityClass.getDes());
            dataMap.put("createFileDate",entityClass.getCreateFileDate());
            dataMap.put("createFileAuth",entityClass.getCreateFileAuth());
            dataMap.put("createFileDateYear",entityClass.getCreateFileDateYear());
            dataMap.put("abstractDomainPath",entityClass.getAbstractDomainPath());
            dataMap.put("extendName",entityClass.getExtendName());
            // step4 加载模版文件
            Template template = configuration.getTemplate("entity.ftl");
            // step5 生成数据
            File docFile = createFile(codeOutPutFilePath + "/entity/" + entityClass.getClassName() +".java");

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    private static File createFile(String filePath){
        String parentPath = filePath.substring(0,filePath.lastIndexOf("/"));
        File files = new File(parentPath);
        if(!files.exists()){
            files.mkdirs();
        }
        File file = new File(filePath);

        return file;
    }

    private static void buildServiceAndRepositoryJava(EntityClass entityClass, String codeTemplateFilePath, String codeOutPutFilePath){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.getVersion());
        Writer out = null;
        Writer serviceImplOut = null;
        Writer repositoryOut = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(codeTemplateFilePath));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("className",entityClass.getClassName());
            dataMap.put("tableName",entityClass.getTableName());
            dataMap.put("classPath",entityClass.getClassPath().replace(".domain",""));
            dataMap.put("classDes",entityClass.getDes());
            dataMap.put("createFileDate",entityClass.getCreateFileDate());
            dataMap.put("createFileAuth",entityClass.getCreateFileAuth());
            dataMap.put("createFileDateYear",entityClass.getCreateFileDateYear());
            dataMap.put("abstractDomainPath",entityClass.getAbstractDomainPath());
            // step4 加载模版文件
            Template template = configuration.getTemplate("service.ftl");
            // step5 生成数据
            File docFile = createFile(codeOutPutFilePath + "/service/" + entityClass.getClassName() +"Service.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);

            Template serviceImplTemplate = configuration.getTemplate("serviceImpl.ftl");
            // step5 生成数据
            File serviceImplDocFile = createFile(codeOutPutFilePath + "/service/" + entityClass.getClassName() +"ServiceImpl.java");
            serviceImplOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplDocFile)));
            // step6 输出文件
            serviceImplTemplate.process(dataMap, serviceImplOut);

            Template repositoryTemplate = configuration.getTemplate("mapper.ftl");
            // step5 生成数据
            File repositoryDocFile = createFile(codeOutPutFilePath + "/mapper/" + entityClass.getClassName() +"Mapper.java");
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryDocFile)));
            // step6 输出文件
            repositoryTemplate.process(dataMap, repositoryOut);

            Template mapperXmlTemplate = configuration.getTemplate("mapperxml.ftl");
            // step5 生成数据
            File repositoryXmlDocFile = createFile(codeOutPutFilePath + "/mapperxml/" + entityClass.getClassName() +"Mapper.xml");
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryXmlDocFile)));
            // step6 输出文件
            mapperXmlTemplate.process(dataMap, repositoryOut);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Map<String, List<TableInfoVo>> getTableInfo() throws SQLException {
        Map<String, List<TableInfoVo>> tableInfoVoMap = new HashMap<>();
        String url = "jdbc:mysql://localhost:3306/hndy_user?useUnicode=true&characterEncodidng=utf-8&allowMultiQueries=true&useSLL=false&serverTimezone=GMT%2B8";
        String name = "root";
        String password = "root123!@#";
        Connection connection = JdbcUtils.getConnection(url, name, password);
        String sql = "SELECT  t.table_name, t.COLUMN_NAME,t.data_type,t.EXTRA ,t.COLUMN_COMMENT  FROM  " +
                " information_schema.COLUMNS t WHERE     TABLE_SCHEMA = 'hndy_user' order by t.TABLE_NAME ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String table_name = resultSet.getString("table_name"); // 假设表有一个名为"id"的列
            String COLUMN_NAME = resultSet.getString("COLUMN_NAME"); // 假设表有一个名为"name"的列
            String data_type = resultSet.getString("data_type"); // 假设表有一个名为"name"的列
            String EXTRA = resultSet.getString("EXTRA"); // 假设表有一个名为"name"的列
            String COLUMN_COMMENT = resultSet.getString("COLUMN_COMMENT"); // 假设表有一个名为"name"的列
            List<TableInfoVo> tableInfoVos = tableInfoVoMap.get(table_name);
            if (CollectionUtils.isEmpty(tableInfoVos)) {
                tableInfoVos = Lists.newArrayList();
            }
            TableInfoVo tableInfoVo = new TableInfoVo();
            tableInfoVo.setTableName(table_name);
            tableInfoVo.setColumnName(COLUMN_NAME);
            tableInfoVo.setDataType(data_type);
            tableInfoVo.setExtra(EXTRA);
            tableInfoVo.setColumnComment(COLUMN_COMMENT);
            tableInfoVos.add(tableInfoVo);
            tableInfoVoMap.put(table_name, tableInfoVos);
        }
        return tableInfoVoMap;
    }
}
