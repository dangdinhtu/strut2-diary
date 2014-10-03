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
    private Integer divinationId;
    private String[] listAnswer;
    private String[] listResult;
    private String[] listImage;
    private Integer[] stt;

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

    public String[] getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(String[] listAnswer) {
        this.listAnswer = listAnswer;
    }

    public String[] getListResult() {
        return listResult;
    }

    public void setListResult(String[] listResult) {
        this.listResult = listResult;
    }

    public String[] getListImage() {
        return listImage;
    }

    public void setListImage(String[] listImage) {
        this.listImage = listImage;
    }

    public Integer[] getStt() {
        return stt;
    }

    public void setStt(Integer[] stt) {
        this.stt = stt;
    }
    
    
}
