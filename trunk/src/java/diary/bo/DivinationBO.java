/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationBO extends BasicBO{
    private Integer divinationId;
    private String name;
    private String descript;
    private Integer dcyId;

    public DivinationBO() {
    }

    public DivinationBO(Integer divinationId, String name, String descript, Integer dcyId) {
        this.divinationId = divinationId;
        this.name = name;
        this.descript = descript;
        this.dcyId = dcyId;
    }

    public Integer getDivinationId() {
        return divinationId;
    }

    public void setDivinationId(Integer divinationId) {
        this.divinationId = divinationId;
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

    public Integer getDcyId() {
        return dcyId;
    }

    public void setDcyId(Integer dcyId) {
        this.dcyId = dcyId;
    }
    
    
}
