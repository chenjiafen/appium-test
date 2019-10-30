/**
 * App登陆操作
 */
package com.wolaidaiAndroid;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.AppiumUtil;
import com.appium.InitDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author tyler.chen
 *
 */
public class LoginTest {
	static AndroidDriver<AndroidElement> driver;

	public LoginTest(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void Tab(String text) throws Exception {
		// 点击Tab项
		driver.findElement(By.xpath("//*[@content-desc='" + text + "']")).click();

	}

	public void loginTest(String phone, String codes) throws Exception {
		// TAB
		// Tab("账户");
		driver.findElement(By.xpath("//[@text='账户']"));
		MobileElement login = driver.findElement(By.xpath("//*[@text='登录/注册']"));
		login.click();
		AppiumUtil tool = new AppiumUtil();
		List<AndroidElement> inputName = driver.findElements(By.className("android.widget.EditText"));
		inputName.get(0).click();
		tool.sendKeyss(driver, phone);
		MobileElement code = driver.findElement(By.xpath("//*[@text='获取验证码']"));
		code.click();
		inputName.get(1).click();
		tool.sendKeyss(driver, codes);
		Thread.sleep(2000);
		MobileElement finish = driver.findElement(By.xpath("//*[@text='完成']"));
		finish.click();

	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("GWY0217117000560", "co.welab.wolaidai",
				"co.welab.wolaidai.MainActivity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(8000);
		LoginTest logintest = new LoginTest(driver);
		logintest.loginTest("18566582390", "888888");
	}

}
