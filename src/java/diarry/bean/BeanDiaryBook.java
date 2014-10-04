/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diarry.bean;

import java.util.Date;

/**
 *
 * @author DinhTu
 */
public class BeanDiaryBook {
    private String name;
    private String coverPhoto;
    private String backgroundImages;
    private Long userId;
    private Long dbkId;
    private Date dateCreate;

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
    

    public Long getDbkId() {
        return dbkId;
    }

    public void setDbkId(Long dbkId) {
        this.dbkId = dbkId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getBackgroundImages() {
        return backgroundImages;
    }

    public void setBackgroundImages(String backgroundImages) {
        this.backgroundImages = backgroundImages;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
}
