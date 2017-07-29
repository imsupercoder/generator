<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.List;
import java.util.Map;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.model.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Service
@Transactional
public class ${className}ServiceImpl implements ${className}Service {

	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	/** 
	 * 创建/更新${className}
	 **/
	public int insertOrUpdate(${className} ${classNameLower}) {
	    return this.${classNameLower}Dao.insertOrUpdate(${classNameLower});
	}	
    
	/** 
	 * 删除${className}
	 **/
    public void delete(String id) {
        this.${classNameLower}Dao.delete(id);
    }
    
	/** 
	 * 根据ID得到${className}
	 **/    
    public ${className} findById(String id) {
        return this.${classNameLower}Dao.findById(id);
    }
    
	/** 
	 * 查询: ${className}
	 **/      
	@Transactional(readOnly=true)
	public List<${className}> findList(Map<String,String> params) {
		return ${classNameLower}Dao.findList(params);
	}
	
}
