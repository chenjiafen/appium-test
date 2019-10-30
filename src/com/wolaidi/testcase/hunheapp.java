/**
 * 
 */
package com.wolaidi.testcase;

import java.util.Set;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chenjiafeng
 *
 */
public class hunheapp {
	AndroidDriver<AndroidElement> driver;

	public hunheapp(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void test() throws Exception {
		Set<String> context = driver.getContextHandles();
		for (String s : context) {
			System.out.println("遍历测试框架：" + s);
			// 遍历测试框架：NATIVE_APP
			// 遍历测试框架：WEBVIEW_com.testfan.ask
		}
		// 切换web页面
		driver.context("WEBVIEW_com.testfan.ask");
		Thread.sleep(3000);
		// <a href="http://ask.testfan.cn/article/3"
		// target="_blank">如何用appium设置设备的网络状态</a>
		driver.findElement(By.xpath("//a[@href='http://ask.testfan.cn/article/3']")).click();
		// //
		// driver.findElement(By.xpath("//*[@href='http://ask.testfan.cn/register']")).click();
		// driver.findElement(By.name("立即注册")).click();
		// System.out.println("完成*****************************");

		// 1.当需要滑动的时候需要现把driver切换到原生上，因为webdriver下的driver不支持滑动
		// driver.context("NATIVE_APP");
		// linktext
	}

	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("DRGGAM2862311219", "com.testfan.ask",
				"com.testfan.ask.MainActivity");
		hunheapp a = new hunheapp(driver);
		Thread.sleep(5000);
		a.test();
	}

}
