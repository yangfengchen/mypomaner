package ${classPath}.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@Data
@TableName("${tableName!}")
public class ${className!} implements Serializable{

<#if model_column?exists>
    <#list model_column as model>
      //${model.columnComment!}
      <#if model.autoIncrement>
      @TableId(value = "${model.changeColumnName?uncap_first}", type = IdType.AUTO)
      <#else>
      @TableField(value = "${model.changeColumnName?uncap_first}")
      </#if>
      private ${model.columnType} ${model.changeColumnName?uncap_first};
    </#list>
</#if>


}