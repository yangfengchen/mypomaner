
<#if tableList?exists>
    <#list tableList as tableModel>
        <#if tableModel.staticTableColumns?exists>

CREATE TABLE ${tableModel.tableName} (
            <#list tableModel.staticTableColumns as model>
                <#if model.columnName == "ID" || model.columnName == "id">
${model.columnName} ${model.columnType} NOT NULL PRIMARY KEY,
                <#else>
${model.columnName} ${model.columnType} NULL COMMENT '${model.des}'<#if model_has_next>,</#if>
                </#if>
            </#list>
);
        </#if>

        <#if tableModel.columnList?exists>
            <#list tableModel.columnList as model>
ALTER TABLE ${tableModel.tableName} ADD ${model.columnName} ${model.columnType} NULL  COMMENT '${model.des}';
            </#list>
        </#if>

    </#list>
</#if>



