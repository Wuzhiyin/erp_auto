package cn.itcast.erp.entity;

/**
 * 员工角色 实体类
 */
public class Emp_role {
    	private Long uuid;//编号
	private Long empuuid;//员工编号
	private Long roleuuid;//角色编号

    	public Long getUuid() {		
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Long getEmpuuid() {		
		return empuuid;
	}
	public void setEmpuuid(Long empuuid) {
		this.empuuid = empuuid;
	}
	public Long getRoleuuid() {		
		return roleuuid;
	}
	public void setRoleuuid(Long roleuuid) {
		this.roleuuid = roleuuid;
	}

}
