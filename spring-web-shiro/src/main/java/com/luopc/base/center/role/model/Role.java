package com.luopc.base.center.role.model;

import java.util.Date;
import java.util.Set;

import com.luopc.base.center.resource.model.Resource;

public class Role {
    private String roleId;

    private String name;

    private String code;

    private String comments;

    private String tenantId;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private Short status;

    private Short approvalStatus;

    private Short showOrder;

    private String systemId;

    private Short isPublic;

    private String unitId;

    private String nameFirstSpell;
    
    private Set<Resource> resources;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Short approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Short getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Short showOrder) {
        this.showOrder = showOrder;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public Short getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Short isPublic) {
        this.isPublic = isPublic;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getNameFirstSpell() {
        return nameFirstSpell;
    }

    public void setNameFirstSpell(String nameFirstSpell) {
        this.nameFirstSpell = nameFirstSpell == null ? null : nameFirstSpell.trim();
    }

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
    
    
}