/**
 * This document is a part of the source code and related artifacts for
 * SMSystem.
 * www.apeironsol.com
 * Copyright © 2012 apeironsol
 *
 */
package com.brilapps.core.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.brilapps.core.constants.CoreConstants;

public final class ViewUtil {

	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext()
				.getAuthentication();
	}

	public static String getPrincipal() {
		final Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		if((null == username) || (username.trim().length()==0)){
			username = CoreConstants.ANONYMOUS_USER;
		}
		return username;
	}

}
