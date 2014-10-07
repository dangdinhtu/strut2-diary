/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;
import java.io.File;

/**
 *
 * @author ThuTrang
 */
public class ResultsDivinationFastBO extends BasicBO{
    private Integer rdfId;
    private String answer;
    private String result;
    private String images;
    private Integer dfnId;
    private Integer stt;

    public ResultsDivinationFastBO() {
    }

    public Integer getRdfId() {
        return rdfId;
    }

    public void setRdfId(Integer rdfId) {
        this.rdfId = rdfId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

   

    public Integer getDfnId() {
        return dfnId;
    }

    public void setDfnId(Integer dfnId) {
        this.dfnId = dfnId;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }
    
    
}
