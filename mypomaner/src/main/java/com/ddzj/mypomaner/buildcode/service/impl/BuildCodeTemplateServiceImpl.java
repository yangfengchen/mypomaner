package com.ddzj.mypomaner.buildcode.service.impl;

import com.ddzj.mypomaner.buildcode.entity.EntityClass;
import com.ddzj.mypomaner.buildcode.entity.TableClass;
import com.ddzj.mypomaner.buildcode.service.IBuildCodeTemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-16 22:55
 * @Description:
 * @Version:1.0
 **/
public abstract class BuildCodeTemplateServiceImpl implements IBuildCodeTemplateService {

    private Logger logger = LoggerFactory.getLogger(BuildCodeTemplateServiceImpl.class);

    public abstract void preProcessDate(TableClass tableClass, EntityClass entityClass);

    @Override
    public void buildCodeFile(TableClass tableClass, EntityClass entityClass, String codeTemplateFilePath,
                              String codeOutPutFilePath) {
        // 前置处理数据
        preProcessDate(tableClass, entityClass);

        buildEntityJava(entityClass, codeTemplateFilePath, codeOutPutFilePath);

        buildServiceAndRepositoryJava(entityClass, codeTemplateFilePath, codeOutPutFilePath);

        buildTableSql(tableClass, codeTemplateFilePath, codeOutPutFilePath);
    }

    private void buildEntityJava(EntityClass entityClass, String codeTemplateFilePath, String codeOutPutFilePath){
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
            logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^" + entityClass.getClassName() + " 文件创建成功 !");
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


    private File createFile(String filePath){
        String parentPath = filePath.substring(0,filePath.lastIndexOf("/"));
        File files = new File(parentPath);
        if(!files.exists()){
            files.mkdirs();
        }
        File file = new File(filePath);

        return file;
    }

    private void buildServiceAndRepositoryJava(EntityClass entityClass, String codeTemplateFilePath, String codeOutPutFilePath){
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
            File repositoryDocFile = createFile(codeOutPutFilePath + "/mapper/" + entityClass.getClassName() +"Repository.java");
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryDocFile)));
            // step6 输出文件
            repositoryTemplate.process(dataMap, repositoryOut);

            Template mapperXmlTemplate = configuration.getTemplate("mapperxml.ftl");
            // step5 生成数据
            File repositoryXmlDocFile = createFile(codeOutPutFilePath + "/mapperxml/" + entityClass.getClassName() +"Mapper.xml");
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryXmlDocFile)));
            // step6 输出文件
            mapperXmlTemplate.process(dataMap, repositoryOut);

            logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^" + entityClass.getClassName() + " 文件创建成功 !");
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

    private void buildTableSql(TableClass tableClass, String codeTemplateFilePath, String codeOutPutFilePath){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.getVersion());
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(codeTemplateFilePath));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("sqlFile", tableClass.getTableName());
            dataMap.put("tableList", Arrays.asList(tableClass));
            // step4 加载模版文件
            Template template = configuration.getTemplate("sql.ftl");
            // step5 生成数据
            File docFile = createFile(codeOutPutFilePath + "/sql/" + tableClass.getTableName() + ".sql");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^" + tableClass.getTableName() + " 文件创建成功 !");
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
}
