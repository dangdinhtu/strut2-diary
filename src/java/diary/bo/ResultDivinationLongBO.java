/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.logging.Logger;

/**
 *
 * @author ThuTrang
 */
public class ResultDivinationLongBO extends BasicBO{
    private Integer rdlId;
    private Integer scoreMax;
    private Integer scoreMin;
    private String results;
    private Integer dlgId;

    public ResultDivinationLongBO() {
    }

    public ResultDivinationLongBO(Integer rdlId, Integer scoreMax, Integer scoreMin, String results, Integer dlgId) {
        this.rdlId = rdlId;
        this.scoreMax = scoreMax;
        this.scoreMin = scoreMin;
        this.results = results;
        this.dlgId = dlgId;
    }

    public Integer getRdlId() {
        return rdlId;
    }

    public void setRdlId(Integer rdlId) {
        this.rdlId = rdlId;
    }

    public Integer getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(Integer scoreMax) {
        this.scoreMax = scoreMax;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Integer getDlgId() {
        return dlgId;
    }

    public void setDlgId(Integer dlgId) {
        this.dlgId = dlgId;
    }
    
}
