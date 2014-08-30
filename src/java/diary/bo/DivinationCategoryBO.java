/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationCategoryBO extends BasicBO{
    private Integer dcyId;
    private String name;
    private String descript;

    public DivinationCategoryBO() {
    }

    public DivinationCategoryBO(Integer dcyId, String name, String descript) {
        this.dcyId = dcyId;
        this.name = name;
        this.descript = descript;
    }

    public Integer getDcyId() {
        return dcyId;
    }

    public void setDcyId(Integer dcyId) {
        this.dcyId = dcyId;
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
    
    
}
