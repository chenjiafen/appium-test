package com.taobao.testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.appium.AppiumStartServer;
import com.appium.AppiumUtil;
import com.appium.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZhiBo {
	
	static AndroidDriver<AndroidElement> driver;

	public ZhiBo(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	public static void zhibao(){

	
	}
	
	public static void main(String[] args) throws  Exception {
		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("GWY0217117000560", "com.taobao.taobao","com.taobao.tao.TBMainActivity");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		for(int i=0;i<4;i++){
			AppiumUtil.swipToUp(driver);

			}
		//点击直播tab
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='直播']")).click();
//		if(AppiumUtil.IsElementExit(driver, By.xpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.ImageView"))){
//		//关闭红包悬浮窗
//		driver.findElement(By.xpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.ImageView")).click();
//	}
		Thread.sleep(2000);
		AppiumUtil.swipToUp(driver);
		//我关注的直播
		driver.findElement(By.xpath("//*[@content-desc='已关注直播']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@content-desc='薇娅viya']/../preceding-sibling::*")).click();
		
//		//选择直播李佳琪
//		AndroidElement lijia=driver.findElement(By.xpath("//*[@content-desc='李佳琦Austin']/../preceding-sibling::*"));
//		lijia.click();
		
//		Set<String> context = driver.getContextHandles();
//		for (String s : context) {
//			System.out.print(s);
//
//			}
		//选择直播
//		AndroidElement zhibo2=driver.findElement(By.xpath("(//android.widget.FrameLayout[@content-desc='直播'])[3]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View"));
//		zhibo2.click();
		Thread.sleep(2000);
		for(int i=0;i<100;i++){
			driver.findElement(By.xpath("//*[@text='跟主播聊什么?']/..")).click();
			AndroidElement input=driver.findElement(By.id("com.taobao.taobao:id/taolive_edit_text"));
			input.sendKeys("发一叶子面膜");
			AndroidElement send=driver.findElement(By.id("com.taobao.taobao:id/taolive_edit_send"));
			send.click();
		}
			
	}

}
