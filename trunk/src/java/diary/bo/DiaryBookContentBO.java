/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookContentBO extends BasicBO{
    private Integer dbcId;
    private String title;
    private String content;
    private String dateWrite;
    private Integer page;
    private Integer dbkId;

    public Integer getDbcId() {
        return dbcId;
    }

    public void setDbcId(Integer dbcId) {
        this.dbcId = dbcId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(String dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getDbkId() {
        return dbkId;
    }

    public void setDbkId(Integer dbkId) {
        this.dbkId = dbkId;
    }

    
}
