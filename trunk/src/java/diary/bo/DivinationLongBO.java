/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongBO extends BasicBO{
    private Integer dlgId;
    private String name;
    private String images;
    private String descript;
    private Integer divinationId;

    public DivinationLongBO() {
    }

    public DivinationLongBO(Integer dlgId, String name, String images, String descript, Integer divinationId) {
        this.dlgId = dlgId;
        this.name = name;
        this.images = images;
        this.descript = descript;
        this.divinationId = divinationId;
    }

    public Integer getDlgId() {
        return dlgId;
    }

    public void setDlgId(Integer dlgId) {
        this.dlgId = dlgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getDivinationId() {
        return divinationId;
    }

    public void setDivinationId(Integer divinationId) {
        this.divinationId = divinationId;
    }
    
    
}
