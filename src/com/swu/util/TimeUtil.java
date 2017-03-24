package com.swu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @Title: TimeUtil
 * @package com.linewell.util
 * @Description: 时间转换工具
 * @author lpan@linewell
 * @date 2016-1-26 下午4:18:32
 * @version V1.0
 */
public class TimeUtil {
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = simpleDateFormat.format(date);
		return now;
	}
}
