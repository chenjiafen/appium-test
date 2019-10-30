package com.wolaidi.testcase;

import java.util.List;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.InitDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WeiXinTest {
	AndroidDriver<AndroidElement> driver;

	public WeiXinTest(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void login() throws Exception {
		Thread.sleep(2000);
		MobileElement loginButton1 = driver.findElement(By.id("com.tencent.mm:id/drp"));
		loginButton1.click();
		MobileElement otherLogin = driver.findElement(By.id("com.tencent.mm:id/ch5"));
		otherLogin.clear();
		List<AndroidElement> inputName = driver.findElements(By.id("com.tencent.mm:id/ji"));
		inputName.get(0).sendKeys("chen980985672");
		inputName.get(1).sendKeys("chen980985672");
		MobileElement login = driver.findElement(By.id("com.tencent.mm:id/ch6"));
		login.click();

	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.InitDriverWithInaller("6DP7NRWSLZWO7S5H",
				"C:\\Users\\tyler.chen\\Desktop\\testAPK\\weixin.apk");
		WeiXinTest test = new WeiXinTest(driver);
		test.login();

	}

}
