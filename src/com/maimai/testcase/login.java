package com.maimai.testcase;

import com.appium.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class login {
	static AndroidDriver<AndroidElement> driver;

	public login(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public static void loginTest() {

	}

	public static void startAPP() throws Exception {
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("127.0.0.1:62026", "com.taou.maimai",
				"com.taou.maimai.SplashActivity");
	}

}
