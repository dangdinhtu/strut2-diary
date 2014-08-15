/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diary.bo;

import java.io.Serializable;

/**
 *
 * @author dungpd1@viettel.com.vn
 */
public class BasicBO implements Serializable, Cloneable {
    public BasicBO() {
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
