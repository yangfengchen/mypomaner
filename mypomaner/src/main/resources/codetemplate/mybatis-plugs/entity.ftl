package ${classPath}.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import ${classPath!}.entity.AbstractEntity;

/**
*
* <p>
*  ${classDes!}模型
* </p>
*
* <p>
*   Copyright: ${createFileDateYear} . All rights reserved.
* </p>
* <p>
*   Company: yangzibo
* </p>
* <p>
*   CreateDate:${createFileDate}
* </p>
*
* @author ${createFileAuth}
* @history Mender:${createFileAuth}；Date:${createFileDate}；
*/
@TableName("${tableName!}")
public class ${className!} extends ${extendName!}{

<#if model_column?exists>
    <#list model_column as model>
      //${model.columnComment!}
      private ${model.columnType} ${model.changeColumnName?uncap_first};
    </#list>
</#if>

<#if model_column?exists>
    <#list model_column as model>
      /**
      * 获取属性：${model.columnComment!}
      * @return the ${model.changeColumnName?uncap_first}
      */
      public ${model.columnType} get${model.changeColumnNameDx}() {
        return this.${model.changeColumnName?uncap_first};
      }

      /**
      * 设置属性：${model.columnComment!}
      * @param ${model.changeColumnName?uncap_first} the ${model.changeColumnName?uncap_first} to set
      */
      public void set${model.changeColumnNameDx}(${model.columnType} ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
      }
    </#list>
</#if>
}