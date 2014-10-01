/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author DinhTu
 */
public class UserRoleBO extends BasicBO{
    private Integer ureId;
    private Integer roleId;
    private Integer userId;
    private Boolean status;

    public Integer getUreId() {
        return ureId;
    }

    public void setUreId(Integer ureId) {
        this.ureId = ureId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
