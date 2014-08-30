/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class ResultsDivinationCouplesBO extends BasicBO{
    private Integer rdcId;
    private Integer scoreMin;
    private Integer scoreMax;
    private String coupleZodiac;
    private String resultContent;
    private Integer divinationId;

    public ResultsDivinationCouplesBO() {
    }

    public ResultsDivinationCouplesBO(Integer rdcId, Integer scoreMin, Integer scoreMax, String coupleZodiac, String resultContent, Integer divinationId) {
        this.rdcId = rdcId;
        this.scoreMin = scoreMin;
        this.scoreMax = scoreMax;
        this.coupleZodiac = coupleZodiac;
        this.resultContent = resultContent;
        this.divinationId = divinationId;
    }

    public Integer getRdcId() {
        return rdcId;
    }

    public void setRdcId(Integer rdcId) {
        this.rdcId = rdcId;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    public Integer getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(Integer scoreMax) {
        this.scoreMax = scoreMax;
    }

    public String getCoupleZodiac() {
        return coupleZodiac;
    }

    public void setCoupleZodiac(String coupleZodiac) {
        this.coupleZodiac = coupleZodiac;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public Integer getDivinationId() {
        return divinationId;
    }

    public void setDivinationId(Integer divinationId) {
        this.divinationId = divinationId;
    }
    
    
}
