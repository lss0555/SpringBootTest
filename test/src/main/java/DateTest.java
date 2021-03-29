import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTest {


    public static void main(String[] args) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        int differDays = getDifferDays(df.format(new Date()), "2020-12-05");
//        System.out.println("相差日期："+differDays);

        String data="2020-12-15mqlog121212";
        String substring = data.substring(0, 10);
        System.out.println(substring);
    }



    public static int getDifferDays(String firstString, String secondString) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = df.parse(firstString);
            secondDate = df.parse(secondString);
        } catch (Exception e) {
            // 日期型字符串格式错误
            System.out.println("日期转换失败");
        }
        int nDay = (int) ((firstDate.getTime() - secondDate.getTime()) / (24 * 60 * 60 * 1000));
        return nDay;
    }
}
