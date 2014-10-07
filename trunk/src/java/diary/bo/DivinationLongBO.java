/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongBO extends BasicBO {

    private Integer dlgId;
    private String name;
    private String images;
    private String descript;
    private Integer divinationId;
    private String[] arrQuestion;
    private String[] arrA;
    private String[] arrB;
    private String[] arrC;
    private String[] arrD;
    private Integer[] arrMarkA;
    private Integer[] arrMarkB;
    private Integer[] arrMarkC;
    private Integer[] arrMarkD;
    
    private Integer[] arrScoreMax;
    private Integer[] arrScoreMin;
    private String[] arrResult;

    public DivinationLongBO() {
    }

    public String[] getArrQuestion() {
        return arrQuestion;
    }

    public void setArrQuestion(String[] arrQuestion) {
        this.arrQuestion = arrQuestion;
    }

    public DivinationLongBO(Integer dlgId, String name, String images, String descript, Integer divinationId) {
        this.dlgId = dlgId;
        this.name = name;
        this.images = images;
        this.descript = descript;
        this.divinationId = divinationId;
    }

    public Integer getDlgId() {
        return dlgId;
    }

    public void setDlgId(Integer dlgId) {
        this.dlgId = dlgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public String[] getArrA() {
        return arrA;
    }

    public void setArrA(String[] arrA) {
        this.arrA = arrA;
    }

    public String[] getArrB() {
        return arrB;
    }

    public void setArrB(String[] arrB) {
        this.arrB = arrB;
    }

    public String[] getArrC() {
        return arrC;
    }

    public void setArrC(String[] arrC) {
        this.arrC = arrC;
    }

    public String[] getArrD() {
        return arrD;
    }

    public void setArrD(String[] arrD) {
        this.arrD = arrD;
    }

    public Integer[] getArrMarkA() {
        return arrMarkA;
    }

    public void setArrMarkA(Integer[] arrMarkA) {
        this.arrMarkA = arrMarkA;
    }

    public Integer[] getArrMarkB() {
        return arrMarkB;
    }

    public void setArrMarkB(Integer[] arrMarkB) {
        this.arrMarkB = arrMarkB;
    }

    public Integer[] getArrMarkC() {
        return arrMarkC;
    }

    public void setArrMarkC(Integer[] arrMarkC) {
        this.arrMarkC = arrMarkC;
    }

    public Integer[] getArrMarkD() {
        return arrMarkD;
    }

    public void setArrMarkD(Integer[] arrMarkD) {
        this.arrMarkD = arrMarkD;
    }

    public Integer[] getArrScoreMax() {
        return arrScoreMax;
    }

    public void setArrScoreMax(Integer[] arrScoreMax) {
        this.arrScoreMax = arrScoreMax;
    }

    public Integer[] getArrScoreMin() {
        return arrScoreMin;
    }

    public void setArrScoreMin(Integer[] arrScoreMin) {
        this.arrScoreMin = arrScoreMin;
    }

    public String[] getArrResult() {
        return arrResult;
    }

    public void setArrResult(String[] arrResult) {
        this.arrResult = arrResult;
    }
    
    
}
