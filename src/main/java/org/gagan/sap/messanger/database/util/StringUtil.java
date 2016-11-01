package org.gagan.sap.messanger.database.util;

public class StringUtil {
	
	public static boolean isNullOrEmptyorBlankString(String str){
		
		return (str==null) || (str.trim().length()==0); 
	}

}
