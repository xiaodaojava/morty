package com.platform.oecp.models.dos;
import red.lixiang.tools.common.mybatis.model.SqlField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiang
 */
public class OecpOrgDO implements Serializable{

   
   /** 主键UUID  */
   @SqlField
   private Long id;

   /** 父级编号  */
   @SqlField
   private String parentId;

   /** 所有父级编号  */
   @SqlField
   private String parentsId;

   /** 名称  */
   @SqlField
   private String name;

   /** 排序  */
   @SqlField
   private Integer sort;

   /** 归属区域  */
   @SqlField
   private String areaId;

   /** 区域编码  */
   @SqlField
   private String areaCode;

   /** 机构类型  */
   @SqlField
   private Integer type;

   /** 机构等级  */
   @SqlField
   private Integer grade;

   /** 联系地址  */
   @SqlField
   private String address;

   /** 邮政编码  */
   @SqlField
   private String zipCode;

   /** 负责人  */
   @SqlField
   private String master;

   /** 电话  */
   @SqlField
   private String phone;

   /** 传真  */
   @SqlField
   private String fax;

   /** 邮箱  */
   @SqlField
   private String email;

   /** 是否启用，0:启用；1:不启用  */
   @SqlField
   private Integer useable;

   /** 主负责人  */
   @SqlField
   private String primaryPerson;

   /** 副负责人  */
   @SqlField
   private String deputyPerson;

   /** 企业微信组织机构编号  */
   @SqlField
   private String wechatOrgId;

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

   


   
   public Long getId() {
        return this.id;
   }

   public OecpOrgDO setId(Long id) {
        this.id = id;
        return this;
   }
   public String getParentId() {
        return this.parentId;
   }

   public OecpOrgDO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
   }
   public String getParentsId() {
        return this.parentsId;
   }

   public OecpOrgDO setParentsId(String parentsId) {
        this.parentsId = parentsId;
        return this;
   }
   public String getName() {
        return this.name;
   }

   public OecpOrgDO setName(String name) {
        this.name = name;
        return this;
   }
   public Integer getSort() {
        return this.sort;
   }

   public OecpOrgDO setSort(Integer sort) {
        this.sort = sort;
        return this;
   }
   public String getAreaId() {
        return this.areaId;
   }

   public OecpOrgDO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
   }
   public String getAreaCode() {
        return this.areaCode;
   }

   public OecpOrgDO setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
   }
   public Integer getType() {
        return this.type;
   }

   public OecpOrgDO setType(Integer type) {
        this.type = type;
        return this;
   }
   public Integer getGrade() {
        return this.grade;
   }

   public OecpOrgDO setGrade(Integer grade) {
        this.grade = grade;
        return this;
   }
   public String getAddress() {
        return this.address;
   }

   public OecpOrgDO setAddress(String address) {
        this.address = address;
        return this;
   }
   public String getZipCode() {
        return this.zipCode;
   }

   public OecpOrgDO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
   }
   public String getMaster() {
        return this.master;
   }

   public OecpOrgDO setMaster(String master) {
        this.master = master;
        return this;
   }
   public String getPhone() {
        return this.phone;
   }

   public OecpOrgDO setPhone(String phone) {
        this.phone = phone;
        return this;
   }
   public String getFax() {
        return this.fax;
   }

   public OecpOrgDO setFax(String fax) {
        this.fax = fax;
        return this;
   }
   public String getEmail() {
        return this.email;
   }

   public OecpOrgDO setEmail(String email) {
        this.email = email;
        return this;
   }
   public Integer getUseable() {
        return this.useable;
   }

   public OecpOrgDO setUseable(Integer useable) {
        this.useable = useable;
        return this;
   }
   public String getPrimaryPerson() {
        return this.primaryPerson;
   }

   public OecpOrgDO setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
        return this;
   }
   public String getDeputyPerson() {
        return this.deputyPerson;
   }

   public OecpOrgDO setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson;
        return this;
   }
   public String getWechatOrgId() {
        return this.wechatOrgId;
   }

   public OecpOrgDO setWechatOrgId(String wechatOrgId) {
        this.wechatOrgId = wechatOrgId;
        return this;
   }
   public String getRemarks() {
        return this.remarks;
   }

   public OecpOrgDO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
   }
   public Integer getDelFlag() {
        return this.delFlag;
   }

   public OecpOrgDO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
   }
   public Date getCreateDate() {
        return this.createDate;
   }

   public OecpOrgDO setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
   }
   public String getCreateBy() {
        return this.createBy;
   }

   public OecpOrgDO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
   }
   public Date getUpdateDate() {
        return this.updateDate;
   }

   public OecpOrgDO setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
   }
   public String getUpdateBy() {
        return this.updateBy;
   }

   public OecpOrgDO setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
   }
   

   public static OecpOrgDO create(){
       return new OecpOrgDO();
   }

   public OecpOrgDO build(){
       return this;
   }

}