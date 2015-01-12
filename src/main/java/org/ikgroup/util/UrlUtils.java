package org.ikgroup.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.UriUtils;

public class UrlUtils {

	public static String encodeUrlPathSegment(String pathSegment, HttpServletRequest request){
		String enc = request.getCharacterEncoding();
		if(enc == null){
			enc = "UTF-8";
		}
		try{
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException e){
		}
		return pathSegment;
		
	}
	
}
