/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.List;

/**
 *
 * @author ThuTrang
 */
public class DivinationFastBO extends BasicBO{
    private Integer dfnId;
    private String name;
    private String descript;
    private String image;
    private Integer divinationId;
    private List<ResultsDivinationFastBO> listOfResult;

    public DivinationFastBO() {
    }

    public DivinationFastBO(String name, String descript, Integer divinationId) {
        this.name = name;
        this.descript = descript;
        this.divinationId = divinationId;
    }

    public DivinationFastBO(Integer dfnId, String name, String descript, Integer divinationId) {
        this.dfnId = dfnId;
        this.name = name;
        this.descript = descript;
        this.divinationId = divinationId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public List<ResultsDivinationFastBO> getListOfResult() {
        return listOfResult;
    }

    public void setListOfResult(List<ResultsDivinationFastBO> listOfResult) {
        this.listOfResult = listOfResult;
    }

}
