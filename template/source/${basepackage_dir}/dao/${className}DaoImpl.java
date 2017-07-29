<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ${basepackage}.model.${className};
import ${basepackage}.util.SQLUtil;
import ${basepackage}.util.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Repository
public class ${className}DaoImpl extends SmartDaoSupport<${className}> implements ${className}Dao{
	
	@Override
    public List<${className}> findList(Map<String, String> params) {
        String sql = SQLUtil.queryAllSql(${className}.class);
        List<String> values = new LinkedList<>();
		/*
        if(StringUtil.isNotEmpty(params.get("userName"))) {
            sql += " and USERNAME like ?";
            values.add("%"+params.get("userName")+"%");
        }
        if(StringUtil.isNotEmpty(params.get("gender"))) {
            sql += " and GENDER =?";
            values.add(params.get("gender"));
        }*/
		//TODO. 按照示例填充SQL和请求参数
        sql = sql.replaceFirst("and","where");
        return getJdbcTemplate().query(sql,BeanPropertyRowMapper.newInstance(${className}.class),values.toArray(new String[0]));
    }

}
