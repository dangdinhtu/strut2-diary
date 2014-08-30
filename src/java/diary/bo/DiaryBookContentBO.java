/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

import java.util.Date;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookContentBO extends BasicBO{
    private Integer dbcId;
    private String title;
    private String content;
    private Date dateWritten;
    private Integer page;
    private Integer dbkId;

    public DiaryBookContentBO() {
    }

    public DiaryBookContentBO(Integer dbcId, String title, String content, Date dateWritten, Integer page, Integer dbkId) {
        this.dbcId = dbcId;
        this.title = title;
        this.content = content;
        this.dateWritten = dateWritten;
        this.page = page;
        this.dbkId = dbkId;
    }

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

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
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
