package org.ikgroup.util;

public class NumberUtils {
	
	/**
	 * 
	 * 
	 * @return
	 */
	public static String longToFixedString(long number, int strLen){
		String rtn = Long.toString(number);
		int num = strLen - rtn.length();
		if(num < 0){
			throw new IllegalArgumentException("The number is larger than expected.");
		}
		String prefix = "";
		while(num > 0){
			prefix += "0";
			num--;
		}
		return prefix + rtn;
	}

}
