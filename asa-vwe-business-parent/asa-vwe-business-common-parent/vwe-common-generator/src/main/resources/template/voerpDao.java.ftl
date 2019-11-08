package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
<#if cfg.isRepository??>
import org.springframework.stereotype.Repository;
</#if>


/**
* <p>
* ${table.comment!} Mapper 接口
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
    <#if cfg.isRepository??>
@Repository
    </#if>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
}
</#if>
