package com.platform.oecp.common;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.utils.UserUtil;
import red.lixiang.tools.common.mybatis.model.SqlField;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @className: DataEntity
 * @author: LILIANG
 * @date: Create In 2020/3/16 10:15
 * @description:
 */
public abstract class DataEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键UUID  */
	@SqlField
	private Long id;
	/** 备注信息  */
	@SqlField
	private String remarks;

	/** 逻辑删除标记（0：显示；1：隐藏）  */
	@SqlField
	private Integer delFlag;

	/** 创建时间  */
	@SqlField
	private Date createDate;

	/** 创建人  */
	@SqlField
	private String createBy;

	/** 更新时间  */
	@SqlField
	private Date updateDate;

	/** 更新人  */
	@SqlField
	private String updateBy;
	
	public DataEntity() {
		super();
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(){
		OecpSysUserDO user = UserUtil.currentUser();
		if (user.getId() != null){
			String userId = String.valueOf(user.getId());
			this.updateBy = userId;
			this.createBy = userId;
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(){
		OecpSysUserDO user = UserUtil.currentUser();
		if (user.getId() != null){
			String userId = String.valueOf(user.getId());
			this.updateBy = userId;
		}
		this.updateDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
