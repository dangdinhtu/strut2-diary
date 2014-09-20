/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author DinhTu
 */
public class RoleBO extends BasicBO{
    private Integer roleId;
    private String name;
    private String descript;
    private Boolean status;

    public RoleBO() {
    }

    public RoleBO(Integer roleId, String name, String descript, Boolean status) {
        this.roleId = roleId;
        this.name = name;
        this.descript = descript;
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
