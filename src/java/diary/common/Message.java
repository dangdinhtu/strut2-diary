/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.common;

/**
 *
 * @author DinhTu
 */
public class Message {
    public static String getMessage(String text, String type, String action){
        return "$().toastmessage('showToast', { text : '"+ text +"', sticky: false, type: '"+ type + "', position : 'top-right' });"
                + "setInterval(function(){window.location.assign('"+ action +"');}, 5000)";
    }
    public static String getMessage(String text, String type){
        return "$().toastmessage('showToast', { text : '"+ text +"', sticky: false, type: '"+ type + "', position : 'top-right' })";
    }
}
