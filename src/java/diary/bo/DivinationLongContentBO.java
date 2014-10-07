/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongContentBO extends BasicBO{
    private Integer dlcId;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private Integer markA;
    private Integer markB;
    private Integer markC;
    private Integer markD;
    private Integer dlgId;

    public DivinationLongContentBO() {
    }

    public DivinationLongContentBO(Integer dlcId, String question, String a, String b, String c, String d, Integer markA, Integer markB, Integer markC, Integer markD, Integer dlgId) {
        this.dlcId = dlcId;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.markA = markA;
        this.markB = markB;
        this.markC = markC;
        this.markD = markD;
        this.dlgId = dlgId;
    }
    
    public Integer getDlcId() {
        return dlcId;
    }

    public void setDlcId(Integer dlcId) {
        this.dlcId = dlcId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Integer getMarkA() {
        return markA;
    }

    public void setMarkA(Integer markA) {
        this.markA = markA;
    }

    public Integer getMarkB() {
        return markB;
    }

    public void setMarkB(Integer markB) {
        this.markB = markB;
    }

    public Integer getMarkC() {
        return markC;
    }

    public void setMarkC(Integer markC) {
        this.markC = markC;
    }

    public Integer getMarkD() {
        return markD;
    }

    public void setMarkD(Integer markD) {
        this.markD = markD;
    }

    public Integer getDlgId() {
        return dlgId;
    }

    public void setDlgId(Integer dlgId) {
        this.dlgId = dlgId;
    }
    
    
}
