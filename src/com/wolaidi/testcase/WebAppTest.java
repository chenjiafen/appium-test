/**
 * 
 */
package com.wolaidi.testcase;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.AppiumStartServer;
import com.appium.AppiumUtil;
import com.appium.InitDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author tyler.chen
 *
 */
public class WebAppTest {

	public void Tab(AppiumDriver<MobileElement> driver, String text) throws Exception {
		// 点击Tab项
		driver.findElement(By.xpath("//*[@content-desc='" + text + "']")).click();

	}

	public void login(AndroidDriver<AndroidElement> driver) throws Exception {
		// // driver.findElement(By.xpath("//*[@text='账户']"));
		// driver.findElement(By.xpath("//*[@content-desc='账户']"));
		driver.findElement(By.xpath("//*[@text='凭身份证申请']")).click();
		MobileElement login = driver.findElement(By.xpath("直播"));
		login.click();
		List<AndroidElement> inputName = driver.findElements(By.className("android.widget.EditText"));
		inputName.get(0).click();
		AppiumUtil.sendKeyss(driver, "13114545654");
		AndroidElement code = driver.findElement(By.xpath("//*[@text='获取验证码']"));
		code.click();
		inputName.get(1).click();
		AppiumUtil.sendKeyss(driver, "888888");
		Thread.sleep(2000);
		AndroidElement finish = driver.findElement(By.xpath("//*[@text='完 成']"));
		finish.click();

	}

	/**
	 * 权限弹窗处理
	 * 
	 * @param driver
	 */
	public void toast(AndroidDriver<AndroidElement> driver) {
		if (AppiumUtil.IsElementExit(driver, By.className("android.widget.ScrollView"))) {

			for (int i = 0; i < 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, 3);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='始终允许']"))).click();

			}

		}

	}

	public void jinrong(AppiumDriver<AndroidElement> driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@text='淘新机']")).click();
		Thread.sleep(3000);
		Set<String> context = driver.getContextHandles();
		for (String s : context) {
			if (s.equals("WEBVIEW_co.welab.wolaidai")) {
				driver.context("WEBVIEW_co.welab.wolaidai");
				driver.findElement(By.xpath("//*[立即申请]")).click();

			}
		}

	}

	public void taoxinji(AppiumDriver<AndroidElement> driver) {
		AndroidElement xx = driver
				.findElement(By.xpath("//android.view.View[25]/android.view.View/android.view.View[2]"));
		xx.click();

	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("GWY0217117000560",
				"co.welab.wolaidai.MainActivity", "co.welab.wolaidai");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		if (AppiumUtil.IsElementExit(driver, By.className("android.widget.ScrollView"))) {
			for (int i = 0; i < 2; i++) {
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='始终允许']"))).click();

			}

		}
		Thread.sleep(5000);
		WebAppTest webapp = new WebAppTest();
		// webapp.login(driver);
		// Thread.sleep(5000);
		webapp.jinrong(driver);
		webapp.taoxinji(driver);
	}

}
