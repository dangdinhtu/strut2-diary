/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author DinhTu
 */
public class UserDiaryBookBO extends BasicBO{
    private Integer udbId;
    private Boolean status;
    private Integer userId;
    private Integer dbkId;
    private Integer remindId;

    public Integer getUdbId() {
        return udbId;
    }

    public void setUdbId(Integer udbId) {
        this.udbId = udbId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDbkId() {
        return dbkId;
    }

    public void setDbkId(Integer dbkId) {
        this.dbkId = dbkId;
    }

    public Integer getRemindId() {
        return remindId;
    }

    public void setRemindId(Integer remindId) {
        this.remindId = remindId;
    }
    
}
