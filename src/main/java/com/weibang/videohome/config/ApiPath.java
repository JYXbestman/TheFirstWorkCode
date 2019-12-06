package com.weibang.videohome.config;

import com.weibang.videohome.exception.EntityErrorException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/**
 * @author vivo
 */
public class ApiPath {

    /**********行政区划级别***************/

    public static final int CITYS__LEVEL_PROVIDE = 1;
    public static final int CITYS__LEVEL_CITY = 2;
    public static final int CITYS__LEVEL_COUNTRY = 3;
    public static final int CITYS__LEVEL_ROWN = 4;

    public static final int ADDRESS_LEVEL = 3;



    /* ***************************** 父路径定义开始 ******************************************************/


    /**
     * 所有的父路径的定义都写在这里
     */
    public static final String USER_API_PATH = "api/user";

    /* ***************************** 父路径定义结束 ******************************************************/

    /**
     * http请求相关的
     */

    static final String REQUEST_BASE_URL = "http://localhost:8080/";
    static final String HTTP_LOG_TAG = "OK_HTTP -> {}";
    public static final String REQUEST_OPEN_ID = "request_open_id";
    public static final String FROM_PLATFORM = "from_platform";

    /**
     * 默认的每一页的大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认的开始的页数
     */
    public static final int DEFAULT_PAGE = 0;

    /**
     * 最小的拼音缩写ASCII
     */
    public static final int CAPITAL_LETTERS_MIN = 65;

    /**
     * 最大的拼音缩写ASCII
     */
    public static final int CAPITAL_LETTERS_MAX = 90;

    /* ******************************************域名的定义开始******************************************************* */


    public static final String DOMAIN_NAME = "https://www.weibanglove.com";


    public static String createNotifyUrl(String url, int code) {
        String sharePath = encodeUrl(url);
        return String.format(Locale.CHINESE, "%s/%s?sharePath=%s&shareCode=%s", DOMAIN_NAME, "mobile/#/", sharePath, code);
    }

    public static String encodeUrl(String url) {
        String result;
        try {
            result = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            result = "";
        }
        return result;
    }

    public static final String DOMAIN_NAME_WITH_SLASH = DOMAIN_NAME + "/";
    public static final String DOMAIN_NAME_SUB = DOMAIN_NAME_WITH_SLASH + "zhendi/";



    /* ******************************************域名的定义结束******************************************************* */

    /**
     * 置顶的时间,默认一个月
     */
    public static final long ONE_MOUTH = 24 * 30 * 3600;
    public static final long ONE_DAY = 24 * 3600;
    public static final long ONE_MIN = 60;
    public static final int TWELVE = 12;
    public static final int THIRTY = 30;
    public static final int THIRTY_ONE = 31;


}
