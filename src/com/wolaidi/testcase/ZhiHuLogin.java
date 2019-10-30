package com.wolaidi.testcase;

import com.appium.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZhiHuLogin {
	/**
	 * @throws Exception
	 */
	public void login() throws Exception {
		AndroidDriver<AndroidElement> driver = InitDriver.InitDriverWithInaller("DRGGAM2862311219",
				"C:\\Users\\tyler.chen\\Desktop\\testAPK\\zhihu.apk");

	}

	public static void main(String[] args) throws Exception {
		ZhiHuLogin L = new ZhiHuLogin();

		L.login();
	}
}
