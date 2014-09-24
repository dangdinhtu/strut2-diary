/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.common;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DinhTu
 */
public class Common {
    private static String DATE_FORMAT = "dd/MM/yyyy";
    public static Date convertStringToDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return null;
        } else {
            String pattern = DATE_FORMAT;
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            dateFormat.setLenient(false);
            try {
                return dateFormat.parse(date);
            } catch (Exception ex) {
                return null;
            }
        }
    }

    public static String convertDateToString(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date);
        }
    }
    public static String convertDateToString(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            return dateFormat.format(date);
        }
    }

    public static String convertTimestampToString(Timestamp date) {
        String S = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return S;
    }

    public static String formatNumber(Double d) {
        if (d == null) {
            return "";
        }
        DecimalFormat format = new DecimalFormat("######.#####");
        return format.format(d);
    }

    public static String formatNumber(Long d) {
        if (d == null) {
            return "";
        }
        DecimalFormat format = new DecimalFormat("######");
        return format.format(d);
    }
}
