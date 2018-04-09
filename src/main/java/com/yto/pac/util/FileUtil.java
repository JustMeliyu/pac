package com.yto.pac.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {
	public static String readFile(InputStream stream) throws Exception
	{
		
		StringBuffer sb = new StringBuffer();
		if(stream == null)
			return "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(stream));
			
			String line = "";
			while(StringUtils.isNotBlank(line = reader.readLine()))
			{
				sb.append(line);
				sb.append("\r\n");
			}
		} finally {
			if(reader!= null)
				reader.close();
		}
		
		return sb.toString();
	}
}
