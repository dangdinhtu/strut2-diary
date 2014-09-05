/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class CategoryBO extends BasicBO{
    private Integer categoryId;
    private String name;
    private String descript;
    private Boolean active;
    private Integer[] listId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    
    public Integer[] getListId() {
        return listId;
    }

    public void setListId(Integer[] listId) {
        this.listId = listId;
    }
    
    
}
