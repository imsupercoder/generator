<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import java.util.List;
import java.util.Map;

import ${basepackage}.model.${className};

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
public interface ${className}Service {

	/** 
	 * 创建/更新${className}
	 **/
	int insertOrUpdate(${className} ${classNameLower});
    
	/** 
	 * 删除${className}
	 **/
    int delete(String id);
    
	/** 
	 * 根据ID得到${className}
	 **/    
    ${className} findById(String id);
    
	/** 
	 * 查询: ${className}
	 **/      
	List<${className}> findList(Map<String,String> params);
    
}
