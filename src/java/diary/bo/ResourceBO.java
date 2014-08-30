/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author ThuTrang
 */
public class ResourceBO extends BasicBO{
    private String resourceKey;
    private String resourceValue;
    private String descript;

    public ResourceBO() {
    }

    public ResourceBO(String resourceKey, String resourceValue, String descript) {
        this.resourceKey = resourceKey;
        this.resourceValue = resourceValue;
        this.descript = descript;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    
    
}
