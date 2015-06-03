/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CustomDateFormat {

    private static final String TIME_ZONE = "UTC";

    public static String completeFormat(Date paramDate) {
        String str = "";
        if (paramDate != null)
            str = format(paramDate, "EEEE, d/MMMMMM/yyyy, h:mm aa").replaceAll("/", " de ");
        return str;
    }

    public static String format(Date paramDate, String paramString) {
        String str = "";
        if (paramDate != null) {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString, new Locale("ES"));
            localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            str = localSimpleDateFormat.format(paramDate);
        }
        return str;
    }

    public static String formatDateOnly(Date paramDate) {
        String str = "";
        if (paramDate != null)
            str = format(paramDate, "EEEE, d/MMMMMM/yyyy").replaceAll("/", " de ");
        return str;
    }

    public static String getCurrentTime(Date paramDate) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdfDate.format(paramDate);
        return strDate;
    }

    public static Date getAnnouncementDateTime(String paramDate) throws ParseException {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return sdfDate.parse(paramDate
                .toString().trim());
    }

    public static Date getAnnouncementDateTimeBad(String paramDate) throws ParseException {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdfDate.parse(paramDate
                .toString().trim());
    }

    public static String formatDateOnlyRelativeToCurrentDate(Date paramDate) {
        String str = "";
        if (paramDate != null) {
            try {
                SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                switch ((int) (1L + (localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime() - paramDate.getTime()) / 86400000L)) {
                    default:
                        str = format(paramDate, "EEEE, d/MMMMMM/yyyy");
                        return str.replaceAll("/", " de ");
                    case 1:
                        return "Ayer";
                    case 0:
                }
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return str;
        } else
            return "Hoy";
    }

    public static String formatDefaultTimeZone(Date paramDate, String paramString) {
        String str = "";
        if (paramDate != null) {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString, Locale.getDefault());
            localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
            str = localSimpleDateFormat.format(paramDate);
        }
        return str;
    }

    public static String formatWithDefaultTimeZone(Date paramDate, String paramString) {
        String str = "";
        if (paramDate != null) {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString, new Locale("ES"));
            localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
            str = localSimpleDateFormat.format(paramDate);
        }
        return str;
    }
}
