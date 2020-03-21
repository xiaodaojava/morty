package com.platform.oecp.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @className: TreeEntity
 * @author: LILIANG
 * @date: Create In 2020/3/16 10:15
 * @description:
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;
	/**
	 * 父级编号
	 */
	protected T parent;
	/**
	 * 所有父级编号
	 */
	protected String parentIds;
	/**
	 * 名称
	 */
	protected String name;
	/**
	 *  排序
	 */
	protected Integer sort;
	/**
	 * 是否有子节点
	 */
	private boolean hasChildren;
	
	public TreeEntity() {
		super();
		this.sort = 30;
	}
	
	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	@JsonBackReference
	@NotNull
	public abstract T getParent();

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	public abstract void setParent(T parent);

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getParentId() {
		String id = null;
		if (parent != null){
			id = (String)Reflections.getFieldValue(parent, "id");
		}
		return StringUtils.isEmpty(id) ? "0" : id;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
}
