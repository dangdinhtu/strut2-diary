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
    private Integer userId;
    private Integer dbkId;
    private Date dateCreate;
    private String title;
    private String content;
    private Date dateWritten;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }
    
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
    

    public Integer getDbkId() {
        return dbkId;
    }

    public void setDbkId(Integer dbkId) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
}
