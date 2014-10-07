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
public class ZodiacBO extends BasicBO{
    private Integer zodiacId;
    private String name;
    private String date;
    private String image;

    public ZodiacBO() {
    }

    public ZodiacBO(Integer zodiacId, String name, String date, String image) {
        this.zodiacId = zodiacId;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public Integer getZodiacId() {
        return zodiacId;
    }

    public void setZodiacId(Integer zodiacId) {
        this.zodiacId = zodiacId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
