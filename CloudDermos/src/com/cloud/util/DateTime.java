package com.cloud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	public String getTime(){
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//�������ڸ�ʽ
         String DateTime = df.format(new Date());
         return DateTime;
	}
}
