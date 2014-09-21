/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.logging.Logger;

/**
 *
 * @author DinhTu
 */
public class RolePermBO extends BasicBO{
    private Integer rpmId;
    private Integer permId;
    private Integer roleId;
    private Integer functionId;

    public RolePermBO() {
    }

    public RolePermBO(Integer rpmId, Integer permId, Integer roleId, Integer functionId) {
        this.rpmId = rpmId;
        this.permId = permId;
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public Integer getRpmId() {
        return rpmId;
    }

    public void setRpmId(Integer rpmId) {
        this.rpmId = rpmId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
   
    
}
