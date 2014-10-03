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
    private File images;
    private Integer dfnId;
    private Integer stt;

    public ResultsDivinationFastBO() {
    }

    public ResultsDivinationFastBO(Integer rdfId, String answer, String result, File images, Integer dfnId, Integer stt) {
        this.rdfId = rdfId;
        this.answer = answer;
        this.result = result;
        this.images = images;
        this.dfnId = dfnId;
        this.stt = stt;
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

    public File getImages() {
        return images;
    }

    public void setImages(File images) {
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
