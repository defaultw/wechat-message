package com.dw.wechatmessage.v2.bus.utils;

import net.cz88.czdb.DbSearcher;
import net.cz88.czdb.QueryType;

/**
 * IP地理位置工具类
 *
 * @author Default.W
 * @date 2024/12/22
 */
public class Ip2LocalUtil {

    private static final String DEV_FILE_PATH_V4 = "D:\\document\\dev_file\\cz88\\cz88_public_v4.czdb";
    private static final String DEV_FILE_PATH_V6 = "D:\\document\\dev_file\\cz88\\cz88_public_v6.czdb";

    private static final String PRO_FILE_PATH_V4 = "/opt/wechatMessage/ip2local/wechatcz88_public_v4.czdb";
    private static final String PRO_FILE_PATH_V6 = "/opt/wechatMessage/ip2local/cz88_public_v6.czdb";

    private static final String KEY = "yx1QdhtX14tGil/cJNGYDA==";

    public static String getLocalByIpv4(String ip) throws Exception {
        DbSearcher dbSearcher;
        String systemType = System.getProperty("os.name").toLowerCase();
        if (systemType.contains("win")) {
            dbSearcher = new DbSearcher(DEV_FILE_PATH_V4, QueryType.MEMORY, KEY);
        } else {
            dbSearcher = new DbSearcher(PRO_FILE_PATH_V4, QueryType.MEMORY, KEY);
        }
        return dbSearcher.search(ip);
    }


}
