/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author DinhTu
 */
public class PermissionBO extends BasicBO{
    private Integer permId;
    private String name;
    private String descript;
    private Boolean status;

    public PermissionBO() {
    }

    public PermissionBO(Integer permId, String name, String descript, Boolean status) {
        this.permId = permId;
        this.name = name;
        this.descript = descript;
        this.status = status;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
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
