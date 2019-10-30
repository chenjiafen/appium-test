package com.wolaidi.testcase;

import java.util.List;
import java.util.Set;
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

public class ZhiHuTestCase {
	AndroidDriver<AndroidElement> driver;

	public ZhiHuTestCase(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	/**
	 * 主菜单
	 * 
	 * @param index
	 */
	public void clickMu(int index) {

		driver.findElements(By.id("com.zhihu.android:id/tab_icon")).get(index).click();

	}

	/**
	 * 登陆操作
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		if (driver.getPageSource().contains("登录知乎，体验更多功能")) {
			MobileElement back = driver.findElement(By.id("com.zhihu.android:id/btn_back"));
			back.click();
		}
		Thread.sleep(3000);
		if (driver.getPageSource().contains("我同意")) {
			driver.findElement(By.id("com.zhihu.android:id/privacy_agree")).click();
		}
		for (int i = 0; i < 3; i++) {
			if (driver.getPageSource().equals("下一步")) {
				driver.findElement(By.id("com.zhihu.android:id/txt_next_guide")).click();
				break;
			}
		}

		clickMu(4);
		Thread.sleep(5000);
		AndroidElement otherLogin = driver.findElement(By.id("com.zhihu.android:id/login_other"));
		otherLogin.click();
		List<AndroidElement> inputName = driver.findElements(By.className("android.widget.EditText"));
		inputName.get(0).sendKeys("18566582390");
		inputName.get(1).sendKeys("chen980985672");
		MobileElement loginButton = driver.findElement(By.id("com.zhihu.android:id/btn_progress"));
		loginButton.click();
	}

	/**
	 * 退出操作
	 * 
	 * @throws Exception
	 */
	public void quitLogin() throws Exception {
		// AppiumUtil util = new AppiumUtil();
		clickMu(4);
		Thread.sleep(2000);
		MobileElement seting = driver.findElement(By.id("com.zhihu.android:id/layout_settings"));
		seting.click();

		for (int i = 0; i < 3; i++) {
			try {
				driver.findElement(By.id("com.zhihu.android:id/func_text")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				AppiumUtil.swipToUp(driver);
			}
		}
		MobileElement toast = driver.findElement(By.id("android:id/button1"));
		toast.click();
	}

	/**
	 * 关注
	 * 
	 * @throws Exception
	 */
	public void follow() throws Exception {
		clickMu(0);
		List<AndroidElement> title = driver.findElements(By.id("com.zhihu.android:id/title"));
		for (MobileElement ae : title) {
			ae.click();
			if (driver.getPageSource().contains("上下滑动切换回答")) {
				driver.findElement(By.className("android.widget.TextView")).click();
			}
			if (driver.findElement(By.className("android.widget.Button")).getAttribute("name").contains("关注")) {
				MobileElement gz = driver.findElement(By.className("android.widget.Button"));
				gz.click();
				String name = gz.getText();
				if (name == "已关注") {
					System.out.println("关注成功");
				} else {
					((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
				}

			} else if (driver.findElement(By.className("android.widget.Button")).getAttribute("name").contains("已关注")) {
				MobileElement gz = driver.findElement(By.className("android.widget.Button"));
				gz.click();
				String name = gz.getText();
				if (name == "已关注") {
					System.out.println("关注成功");
				} else {
					((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
				}
			}

		}

	}

	public void checkClick() throws Exception {
		clickMu(4);
		driver.findElement(By.id("com.zhihu.android:id/layout_settings")).click();
		Thread.sleep(1000);
		AppiumUtil tools = new AppiumUtil();
		int i = 3;
		while (i > 0) {
			try {
				driver.findElement(By.xpath("//*[@text='全局推送通知设置']")).click();
				break;
			} catch (Exception e) {
				tools.swipToUp(driver);
				i--;
			}
		}

		List<AndroidElement> texts = driver
				.findElements(By.xpath("//*[@resource-id='android:id/checkbox']/../preceding-sibling::*[1]/*[1]"));

		for (MobileElement ae : texts) {

			ae.click();
			String text = ae.getText();
			MobileElement seting = driver
					.findElement(By.xpath("//*[@text='" + text + "']/../following-sibling::*[1]/*[1]"));
			String oldeStatus = seting.getAttribute("checked");
			seting.click();
			String newStatus = seting.getAttribute("checked");
			if (oldeStatus.equals("false")) {
				if (newStatus.equals("true")) {
					System.out.println("关注成功");
				} else {
					System.out.println("关注失败");
				}
			} else {
				if (newStatus.equals("false")) {
					System.out.println("取消关注");
				} else {
					System.out.println("取消关关注失败");
				}
			}
		}
		Thread.sleep(3000);
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void hunhe() throws Exception {
		driver.findElement(By.xpath("//*[@text='活动广场']")).click();
		Thread.sleep(3000);
		Set<String> context = driver.getContextHandles();
		for (String s : context) {
			System.out.println(s);
		}
		// // 切换web页面
		// driver.context("WEBVIEW_com.testfan.ask");
		// Thread.sleep(3000);
		// //
		// driver.findElement(By.xpath("//a[@href='http://ask.testfan.cn/register']")).click();
		// driver.findElement(By.xpath("//*[@text='用户登录']")).click();
		// System.out.println("完成");

		// 1.当需要滑动的时候需要现把driver切换到原生上，因为webdriver下的driver不支持滑动
		// driver.context("NATIVE_APP");
		// linktext
	}

	public static void main(String[] args) throws Exception {
		// DRGGAM2862311219 udid:127.0.0.1:52026 fc99e03a
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.InitDriverWithInaller("DRGGAM2862311219",
				"C:\\Users\\tyler.chen\\Desktop\\testAPK\\zhihu.apk",
				"com.zhihu.android.app.ui.activity.SocialOauthActivity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		 for (int i = 0; i < 5; i++) {
//		 if (driver.getPageSource().contains("拒绝") ||
//		 driver.getPageSource().equals("允许")) {
//		 MobileElement toast =
//		 driver.findElement(By.xpath("//*[@resource-id='android:id/button1']"));
//		 toast.click();
//		 Thread.sleep(2000);
//		 }
//		 }
		for (int i = 0; i < 4; i++) {
			try {
				if (driver.getPageSource().contains("拒绝") || driver.getPageSource().equals("允许")) {
					MobileElement toast = driver.findElement(By.xpath("//*[@resource-id='android:id/button1']"));
					toast.click();
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println("元素没有找到");
			}
		}

		ZhiHuTestCase test = new ZhiHuTestCase(driver);
		test.login();
		Thread.sleep(5000);

		test.hunhe();
		 test.checkClick();

		 test.follow();

		 test.quitLogin();
	}

}
