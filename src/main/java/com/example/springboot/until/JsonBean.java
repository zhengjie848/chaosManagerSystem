package com.example.springboot.until;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonBean {
	final private static Gson gson=new GsonBuilder().serializeNulls().create();

	public static Gson getGson() {
		return gson;
	}
}
