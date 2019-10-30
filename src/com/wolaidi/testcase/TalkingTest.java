/**
 * 1、实现QQ登陆
 * 2、给我的好友发送消息
 * 3、设置解锁码
 */
package com.wolaidi.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.AppiumUtil;
import com.appium.InitDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author tyler.chen
 *
 */
public class TalkingTest {
	AndroidDriver<AndroidElement> driver;

	public TalkingTest(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	/**
	 * 登陆QQ
	 * 
	 * @param user
	 * @param pass
	 */
	public void login(String user, String pass) {

		MobileElement loginButton = driver.findElement(By.id("com.tencent.qqlite:id/btn_login"));
		loginButton.click();
		List<AndroidElement> input_text = driver.findElements(By.className("android.widget.EditText"));
		input_text.get(0).sendKeys(user);
		input_text.get(1).sendKeys(pass);
		MobileElement login = driver.findElement(By.id("com.tencent.qqlite:id/login"));
		login.click();

	}

	/**
	 * 给好友发消息
	 * 
	 * @param sends
	 * @throws Exception
	 */
	public void faSongXiaoXi(String sends) throws Exception {

		MobileElement liaisons = driver.findElement(By.xpath("//*[@text='联系人']"));
		liaisons.click();

		// 获取“我的好友元素”
		driver.findElement(By.xpath("// *[@class='android.view.ViewGroup']/android.widget.RelativeLayout[3]")).click();
		Thread.sleep(1000);
		List<AndroidElement> icon = driver.findElements(By.id("com.tencent.qqlite:id/icon"));

		for (MobileElement ele1 : icon) {

			ele1.click();

			driver.findElement(By.id("com.tencent.qqlite:id/input")).sendKeys(sends);
			driver.findElement(By.xpath("//*[@text='发送']")).click();
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			AppiumUtil.swipToUp(driver);
		}
	}

	/**
	 * 给每个群发送消息
	 * 
	 * @param sends
	 */
	public void qunxiaoxi(String sends) {
		MobileElement qun = driver.findElement(By.xpath("//*[@content-desc='群']"));
		qun.click();
		try {
			List<AndroidElement> qunEle = driver.findElements(
					By.xpath("//android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout"));
			for (MobileElement ele : qunEle) {
				ele.click();
				driver.findElement(By.id("com.tencent.qqlite:id/input")).sendKeys(sends);
				driver.findElement(By.xpath("//*[@text='发送']")).click();
				((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
		} catch (Exception e) {
			AppiumUtil.swipToUp(driver);
		}
	}

	/**
	 * 给每个群发送消息，并个群里每个人发送消息
	 * 
	 * @param sends
	 * @param onebyone
	 */
	public void qunxiaoxi(String sends, String onebyone) {
		MobileElement qun = driver.findElement(By.xpath("//*[@content-desc='群']"));
		qun.click();
		try {
			List<AndroidElement> qunEle = driver.findElements(
					By.xpath("//android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout"));
			for (MobileElement ele : qunEle) {
				ele.click();
				driver.findElement(By.id("com.tencent.qqlite:id/input")).sendKeys(sends);
				driver.findElement(By.xpath("//*[@text='发送']")).click();
				MobileElement quniocn = driver.findElement(By.id("com.tencent.qqlite:id/ivTitleBtnRightImage"));
				quniocn.click();

				((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
		} catch (Exception e) {
			AppiumUtil.swipToUp(driver);
		}
	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("127.0.0.1:62026", "com.tencent.qqlite",
				"com.tencent.mobileqq.activity.SplashActivity");
		Thread.sleep(5000);

		// 隐式等待
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TalkingTest qq = new TalkingTest(driver);

		// 登陆
		qq.login("980985672", "Chen122793F*");

		// 显示等待10s，在10s找到该元素
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		if (driver.getPageSource().equals("允许") || driver.getPageSource().contains("拒绝")) {
			for (int i = 0; i <= 2; i++) {
				// AndroidElement qidong
				// =Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("//*[@text='禁止']")));
				AndroidElement qidong1 = driver.findElement(By.xpath("//*[@text='允许']"));
				qidong1.click();
				Thread.sleep(2000);
			}
		}

		// 给qq好友发送消息
		qq.faSongXiaoXi("脚本调试");
		// qq.qunxiaoxi("脚本调试");

		AppiumStartServer.stopAppiumService();
	}
}
