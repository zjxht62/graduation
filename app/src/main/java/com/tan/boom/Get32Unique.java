package com.tan.boom;

import java.util.UUID;

import android.R.string;

public class Get32Unique {
	public static String Get32() {
		UUID uuid = UUID.randomUUID();
		String unistring = uuid.toString().replace("-", "");
		return unistring;
	}

}
