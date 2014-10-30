package pt.pedrorijo91.utils.date;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.YearMonthDay;

public class DateUtils {

    public static String getPrintableDate(YearMonthDay date) {
        if (date != null) {
            return date.getDayOfMonth() + "/" + new DateFormatSymbols().getMonths()[date.getMonthOfYear()] + "/" + date.getYear();
        } else {
            return "Unavailable date";
        }
    }

    public static YearMonthDay getYearMonthDayDate(String printableDate) {

        YearMonthDay date = null;

        try {
            String[] dateFields = printableDate.split("/");

            int day = Integer.parseInt(dateFields[0]);

            Date d = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(dateFields[1]);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            int month = cal.get(Calendar.MONTH);

            int year = Integer.parseInt(dateFields[2]);

            date = new YearMonthDay(year, month, day);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}
