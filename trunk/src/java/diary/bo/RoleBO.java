/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.List;

/**
 *
 * @author DinhTu
 */
public class RoleBO extends BasicBO{
    private Integer roleId;
    private String name;
    private String descript;
    private Boolean status;
    private String[] listPerm;
    private List<Boolean> ckeckedRole;
    private Integer permId;
    private Integer functionId;

    public RoleBO() {
    }

    public RoleBO(Integer roleId, String name, String descript, Boolean status, String[] listPerm, Integer permId, Integer functionId) {
        this.roleId = roleId;
        this.name = name;
        this.descript = descript;
        this.status = status;
        this.listPerm = listPerm;
        this.permId = permId;
        this.functionId = functionId;
    }

    public List<Boolean> getCkeckedRole() {
        return ckeckedRole;
    }

    public void setCkeckedRole(List<Boolean> ckeckedRole) {
        this.ckeckedRole = ckeckedRole;
    }

    public String[] getListPerm() {
        return listPerm;
    }

    public void setListPerm(String[] listPerm) {
        this.listPerm = listPerm;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
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
