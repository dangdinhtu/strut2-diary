/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationFastBO extends BasicBO{
    private Integer dfnId;
    private String name;
    private String descript;
    private Integer divinationId;

    public DivinationFastBO() {
    }

    public DivinationFastBO(Integer dfnId, String name, String descript, Integer divinationId) {
        this.dfnId = dfnId;
        this.name = name;
        this.descript = descript;
        this.divinationId = divinationId;
    }

    public Integer getDfnId() {
        return dfnId;
    }

    public void setDfnId(Integer dfnId) {
        this.dfnId = dfnId;
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

    public Integer getDivinationId() {
        return divinationId;
    }

    public void setDivinationId(Integer divinationId) {
        this.divinationId = divinationId;
    }
    
    
}
