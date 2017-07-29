<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.List;
import java.util.Map;

import ${basepackage}.model.${className};

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
public interface ${className}Dao{
	
	List<${className}> findList(Map<String, String> params);
    List<${className}> findAll();
    ${className} findById(String id);
    int insertOrUpdate(${className} entity);
    int delete(String id);

}
