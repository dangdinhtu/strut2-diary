/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.bo;

/**
 *
 * @author DinhTu
 */
public class FunctionBO extends BasicBO{
    private Integer functionId;
    private String name;
    private String descript;
    private Boolean status;

    public FunctionBO() {
    }

    public FunctionBO(Integer functionId, String name, String descript, Boolean status) {
        this.functionId = functionId;
        this.name = name;
        this.descript = descript;
        this.status = status;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
