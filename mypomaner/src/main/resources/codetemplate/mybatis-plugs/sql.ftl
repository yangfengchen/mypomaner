
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
                 <#if model.indexStatus>
                     <#if model.indexName?exists>
                         CREATE INDEX ${model.indexName?upper_case}${model.columnName?upper_case} ON ${tableModel.tableName} (${model.columnName});
                     <#else>
                         CREATE INDEX IDX_${model.columnName?upper_case} ON ${tableModel.tableName} (${model.columnName});
                     </#if>
                 </#if>
            </#list>
        </#if>

    </#list>
</#if>



