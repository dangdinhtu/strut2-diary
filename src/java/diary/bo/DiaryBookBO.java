/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.Date;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookBO extends BasicBO{
    private Integer dbkId;
    private Integer categoryId;
    private String name;
    private Date dateCreate;
    private String coverPhoto;
    private String backgroundImages;
    private String backgroundAudio;
    private Boolean audioAutoPlay;

    public DiaryBookBO() {
    }

    public DiaryBookBO(Integer dbkId, Integer categoryId, String name, Date dateCreate, String coverPhoto, String backgroundImages, String backgroundAudio, Boolean audioAutoPlay) {
        this.dbkId = dbkId;
        this.categoryId = categoryId;
        this.name = name;
        this.dateCreate = dateCreate;
        this.coverPhoto = coverPhoto;
        this.backgroundImages = backgroundImages;
        this.backgroundAudio = backgroundAudio;
        this.audioAutoPlay = audioAutoPlay;
    }

   

    public Integer getDbkId() {
        return dbkId;
    }

    public void setDbkId(Integer dbkId) {
        this.dbkId = dbkId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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

    public String getBackgroundAudio() {
        return backgroundAudio;
    }

    public void setBackgroundAudio(String backgroundAudio) {
        this.backgroundAudio = backgroundAudio;
    }

    public Boolean getAudioAutoPlay() {
        return audioAutoPlay;
    }

    public void setAudioAutoPlay(Boolean audioAutoPlay) {
        this.audioAutoPlay = audioAutoPlay;
    }
    
}
