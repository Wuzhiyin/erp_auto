package cn.itcast.erp.entity;

/**
 * 角色 实体类
 */
public class Role {
    	private Long uuid;//编号
	private String name;//名称

    	public Long getUuid() {		
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
