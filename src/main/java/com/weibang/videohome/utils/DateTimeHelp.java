package com.weibang.videohome.utils;

import com.weibang.videohome.config.ApiPath;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author vivo
 */
@Component
public class DateTimeHelp {

    private static String[] BASE_STRING = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    private static final int UUACITID_LENGHT = 8;


    public long getTodayBegin() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    public long getTodayEnd() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    public long getYesterTodayBegin() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis()/1000;
    }

    public long getYesterTodayEnd() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis()/1000;
    }


    /**
     * 生成订单号
     *
     * @param num 补充的随机数位数
     * @return str
     */
    public String createOrderSn(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = BASE_STRING.length;
        String randomString = "";
        for (int i = 0; i < length; i++) {
            stringBuilder.append(BASE_STRING[random.nextInt(length)]);
        }
        randomString = stringBuilder.toString();
        random = new Random(System.currentTimeMillis());
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(getTodayStr());
        for (int i = 0; i < num; i++) {
            stringBuilder.append(randomString.charAt(random.nextInt(randomString.length() - 1)));
        }
        return stringBuilder.toString();
    }

    public String getTodayStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    /**
     * @return 昨天的时间
     */
    public int getLastDayInt(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        int yesterdayDate=Integer.valueOf(dateFormat.format(calendar.getTime()));
        return yesterdayDate;
    }

    /**
     * @return 获取这周的时间
     */
    public int getThisWeekInt(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,2);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        int thisweekDate=Integer.valueOf(dateFormat.format(calendar.getTime()));
        return thisweekDate;
    }

    /**
     * @return 获取上周的开始时间时间
     */
    public int getLastWeekStartInt(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0,0);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.add(Calendar.DATE,-7);
        int lastweekstartDate=Integer.valueOf(dateFormat.format(calendar.getTime()));
        return lastweekstartDate;
    }

    /**
     * @return 获取上周的结束时间时间
     */
    public int getLastWeekEndInt(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0,0);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.add(Calendar.DATE,-1);
        int lastweekendDate=Integer.valueOf(dateFormat.format(calendar.getTime()));
        return lastweekendDate;
    }


    /**
     * 把时间转成时间戳
     * @param times 数字时间 20191104
     * @return 时间戳
     */
    public String turnDataToLongTime(int times){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = simpleDateFormat.parse(String.valueOf(times));
            long ts = date.getTime();
            return stampToDate(ts);
        } catch (ParseException e) {
           return null;
        }

    }
    private   String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM.dd");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }




    public List<List<Integer>> getLastWeekEndList(){
        ArrayList<List<Integer>> weektime = new ArrayList<>();
        for(int i=0;i < 5;i++) {
            List<Integer> thisWeekInt = getThisWeekInt(-i * 7);
            weektime.add(thisWeekInt);
        }
        return weektime;
    }

    private List<Integer> getThisWeekInt(int day){
        ArrayList<Integer> startAndEnd = new ArrayList<>();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,2);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.add(Calendar.DATE,day);

        int thisweekstart=Integer.valueOf(dateFormat.format(calendar.getTime()));
        long longend = calendar.getTimeInMillis()/1000 + 6 *3600*24;
        int thisweekend= Integer.valueOf(dateFormat.format(new Date(Long.parseLong(String.valueOf(longend * 1000)))));
        startAndEnd.add(thisweekstart);
        startAndEnd.add(thisweekend);
        return startAndEnd;
    }
//
//    public long getLastWeekStartLong(){
//        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
//        Calendar calendar=Calendar.getInstance();
//        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0,0);
//        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
//        calendar.add(Calendar.DATE,-7);
//
//        return calendar.getTimeInMillis()/1000;
//    }


    /**
     * @return 获取这周的开始时间戳
     */
    public long getThisWeekLong(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,2);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        return calendar.getTimeInMillis() /1000;
    }

    /**
     * 生成uucaid
     *
     * @return str
     */
    public String createUniontId() {

        StringBuilder stringBuilder = new StringBuilder();

        Date date = new Date();
        String strDateFormat = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        stringBuilder.append(sdf.format(date));
        stringBuilder.append("000014");

        Random random = new Random();

        for (int i = 0; i < DateTimeHelp.UUACITID_LENGHT; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public String convertTime(long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取多少个月后到今天的天数
     *
     * @param mouth mouth
     * @return 时间戳
     */
    public int getDayByMoth(int mouth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long begin = calendar.getTimeInMillis();
        int nowMouth = calendar.get(Calendar.MONTH);
        int nowYear = calendar.get(Calendar.YEAR);
        int appendYear = 0;
        int appendMouth;
        //如果期限选择了超过一年
        if (mouth >= ApiPath.TWELVE) {
            appendYear = mouth / ApiPath.TWELVE;
            appendMouth = mouth % ApiPath.TWELVE;
            //如果剩下的月份加上当前月份大于12
            if (appendMouth + nowMouth >= ApiPath.TWELVE) {
                appendYear += 1;
                appendMouth = -(nowMouth - (appendMouth + nowMouth) % 12);
            }
        }
        //如果选择没有超过一年
        else {
            appendMouth = mouth % ApiPath.TWELVE;
            //如果剩下的月份加上当前月份大于12
            if (appendMouth + nowMouth >= ApiPath.TWELVE) {
                appendYear += 1;
                appendMouth = -(nowMouth - (appendMouth + nowMouth) % 12);
            }
        }
        calendar.set(Calendar.YEAR, nowYear + appendYear);
        calendar.set(Calendar.MONTH, nowMouth + appendMouth);
        long end = calendar.getTimeInMillis();
        long day = (end - begin) / ApiPath.ONE_DAY / 1000;
        return (int) day;
    }

    public String getPayBegin() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public String getPayEnd(String begin, boolean isCoupon) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(LocalDateTime.parse(begin, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).atZone(ZoneId.of("UTC+8")).toInstant()));
        if (isCoupon) {
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1);
        } else {
            calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 2);
        }
        Instant instant = Instant.ofEpochMilli(calendar.getTimeInMillis());
        return LocalDateTime.ofInstant(instant, ZoneId.of("UTC+8")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    /**
     * 把yyyyMMdd格式的时间转化为时间戳(秒)
     *
     * @return 时间戳
     */
    public long getStartTime(int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = dateFormat.parse(String.valueOf(day), new ParsePosition(0));
        return time.getTime() / 1000;
    }

    /**
     * 获取当前天的结束时间
     */
    public long getEndTime(int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = dateFormat.parse(String.valueOf(day), new ParsePosition(0));
        return time.getTime() / 1000 + 86400;
    }

}
