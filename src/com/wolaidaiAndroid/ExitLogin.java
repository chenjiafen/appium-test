package com.wolaidaiAndroid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ExitLogin {
	static AndroidDriver<AndroidElement> driver;

	public ExitLogin(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void exitLogin() {
		AndroidElement zhanghu = driver.findElement(By.xpath("//[@text='账户']"));
		zhanghu.click();
		AndroidElement shezhi = driver.findElement(By.xpath("//[@text='设置']"));
		shezhi.click();
		AndroidElement exit = driver.findElement(By.xpath("//[@text='退出登录']"));
		exit.click();

	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("GWY0217117000560", "co.welab.wolaidai",
				"co.welab.wolaidai.MainActivity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(8000);
		LoginTest logintest = new LoginTest(driver);
		ExitLogin exit = new ExitLogin(driver);
		logintest.loginTest("18566582390", "888888");
		Thread.sleep(3000);
		exit.exitLogin();

	}

}
