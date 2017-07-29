<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import ${basepackage}.annotation.Table;

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Table("${className}")
public class ${className}  extends BaseEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	<#list table.columns as column>
	<#if column.columnNameLower!="id"&&column.columnNameLower!="addby"&&column.columnNameLower!="addtime"&&column.columnNameLower!="updateby"&&column.columnNameLower!="updatetime">
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */ 
	private ${column.javaType} ${column.columnNameLower};
	</#if>
	</#list>

<@generateConstructor className/>
<@generateJavaColumns/>

}
<#macro generateJavaColumns>
	<#list table.columns as column>
	<#if column.columnNameLower!="id"&&column.columnNameLower!="addby"&&column.columnNameLower!="addtime"&&column.columnNameLower!="updateby"&&column.columnNameLower!="updatetime">
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	</#if>
	</#list>
</#macro>
