<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<#include "/java_imports.include">

<#include "/java_description.include">
 *
 */
@RestController
@RequestMapping("/${classNameLowerCase}")
public class ${className}Controller extends BaseController{
	
	private ${className}Service ${classNameFirstLower}Service;

	@RequestMapping(value = "/${classNameLowerCase}s.do",method = RequestMethod.POST)
    public List<${className}> list(HttpServletRequest request){
        return ${classNameFirstLower}Service.findList(RequestUtil.getParamMap(request));
    }
    @RequestMapping(value ="/delete.do",method = RequestMethod.POST)
    public Map<String,Object> delete(@RequestParam("id")String id){
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("flag",${classNameFirstLower}Service.delete(id)==1?true:false);
        return returnMap;
    }
    @RequestMapping(value ="/${classNameFirstLower}.do",method = RequestMethod.POST)
    public Map<String,Object> insertOrUpdate(@RequestBody ${className} ${classNameFirstLower}){
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("flag",${classNameFirstLower}Service.insertOrUpdate(${classNameFirstLower})==1?true:false);
        return returnMap;
    }
	
}

