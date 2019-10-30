package com.wolaidi.testcase;

import java.util.ArrayList;
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

public class WldLogin {
	AndroidDriver<AndroidElement> driver;

	public WldLogin(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public WldLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * TAB切换
	 * 
	 * @param text
	 * @throws Exception
	 */
	public void Tab(String text) throws Exception {
		// 点击Tab项
		driver.findElement(By.xpath("//*[@content-desc='" + text + "']")).click();

	}

	/**
	 * APP登陆操作
	 * 
	 * @param phone
	 * @param codes
	 * @throws Exception
	 */
	public void logins(String phone, String codes) throws Exception {
		// TAB
		Tab("账户");
		// driver.findElement(By.xpath("//[@text='账户']"));
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
		Thread.sleep(3000);
		MobileElement finish = driver.findElement(By.xpath("//*[@text='完 成']"));
		finish.click();
	}

	
	public void jddApplication() {
		MobileElement jddProduct = driver.findElement(By.xpath("//*[@text='凭身份证申请']"));
		jddProduct.click();

	}


	public void clicksPage() throws Exception {
		try {
			driver.findElement(By.xpath("//*[@text='首页']")).click();
			MobileElement fuli = driver.findElement(By.xpath("//*[@text='福利中心']"));
			MobileElement gongsi = driver.findElement(By.xpath("//*[@text='公司介绍']"));
			MobileElement feixi = driver.findElement(By.xpath("//*[@text='息费计算']"));
			MobileElement jdd = driver.findElement(By.xpath("//*[@text='凭身份证申请']"));
			MobileElement xyk = driver.findElement(By.xpath("//*[@text='凭信用卡申请']"));
			MobileElement gjj = driver.findElement(By.xpath("//*[@text='凭公积金申请']"));
			List<MobileElement> element = new ArrayList<>();
			element.add(fuli);
			element.add(gongsi);
			element.add(feixi);
			element.add(jdd);
			element.add(xyk);
			element.add(gjj);
			for (MobileElement ae : element) {
				ae.click();
				Thread.sleep(2000);
				((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
			}

		} catch (Exception e) {
			AppiumUtil.swipToUp(driver);
		}
	}

	
	public void applied(String name, String cnid) throws Exception {

		Tab("首页");
		for (int i = 0; i < 2; i++) {
			if (driver.getPageSource().contains("凭身份证申请")) {
				MobileElement products = driver.findElement(By.xpath("//*[@text='凭身份证申请']"));
				products.click();
				break;
			} else {
				AppiumUtil.swipToUp(driver);
				
			}
		}

		MobileElement applied = driver.findElement(By.xpath("//*[@text='立即申请']/.."));
		applied.click();
		Thread.sleep(3000);
		MobileElement names = driver
				.findElement(By.xpath("//*[@text='为确保资金到账，请输入收款银行卡的身份信息']/../following-sibling::*[1]/*[1]"));
		names.sendKeys(name);
		MobileElement cnids = driver
				.findElement(By.xpath("//*[@text='为确保资金到账，请输入收款银行卡的身份信息']/../following-sibling::*[1]/*[3]"));
		cnids.sendKeys(cnid);

		MobileElement marriage = driver
				.findElement(By.xpath("//*[@text='为确保资金到账，请输入收款银行卡的身份信息']/../following-sibling::*[1]/*[5]"));
		marriage.click();
		driver.findElement(By.id("co.welab.wolaidai:id/confirm")).click();
		MobileElement education = driver
				.findElement(By.xpath("xpath>//*[@text='为确保资金到账，请输入收款银行卡的身份信息']/../following-sibling::*[1]/*[7]"));
		education.click();
		driver.findElement(By.id("co.welab.wolaidai:id/confirm")).click();
		MobileElement next = driver.findElement(By.xpath("//*[@text='下一步']/.."));
		next.click();
	}

	
	public void xinyong() {
		try {
			if (driver.findElement(By.xpath("//*[@text='֧����']/following-sibling::*[2]")) != null) {
				driver.findElement(By.xpath("//*[@text='��һ��']/..")).click();
			} else {
				((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
		} catch (Exception e) {
			System.out.println("δ��Ȩ");
		}
	}

	public void liaisons() {
		MobileElement jiahao = driver.findElement(By.xpath("//*[@text='����']/following-sibling::*"));
		jiahao.click();
		MobileElement phone = driver.findElement(By.xpath("(//*[@class='android.view.View'])[12]"));
		phone.click();
		MobileElement position = driver.findElement(By.xpath("//*[@text='�����־ӵ�']/following-sibling::*[1]"));
		position.click();
		driver.findElement(By.xpath("//*[@text='ȷ��']")).click();
		driver.findElement(By.xpath("//*[@text='��һ��']/..")).click();
	}

	/**
	 * ������Ϣ
	 */
	public void gzxx() {
		MobileElement industry = driver
				.findElement(By.xpath("//*[@text='Ϊ��߽�������д��ʵ������Ϣ']/../following-sibling::*[1]/*[1]"));
		MobileElement hangye = driver
				.findElement(By.xpath("//*[@text='��ҵѡ��']/../../following-sibling::*[1]/*[1]/*[1]"));
		MobileElement hangye2 = driver.findElement(By.xpath(
				"//*[@text='��ҵѡ��']/../../following-sibling::*[1]/*[1]/*[1]/*[1]/following-sibling::*[1]/*[1]/*[1]"));
		MobileElement company = driver
				.findElement(By.xpath("//*[@text='Ϊ��߽�������д��ʵ������Ϣ']/../following-sibling::*[1]/*[3]"));

	}

	/**
	 * �²�APP����
	 * 
	 * @throws Exception
	 */
	public void taoxinji() throws Exception {
		Tab("淘新机");
		Thread.sleep(5000);
		Set<String> context = driver.getContextHandles();
		for (String s : context) {
			System.out.println(s);
		}
		// Thread.sleep(3000);
		driver.context("WEBVIEW_co.welab.wolaidai");
		driver.findElement(By.xpath("//*[@id='jumpJdd']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='Input___1iYS0']")).sendKeys("6000");
		driver.findElement(By.xpath("//*[@class='btn-primary submit']")).click();
	}

	public static void main(String[] args) throws Exception {

//		AppiumStartServer.StartAppiumService();
		AndroidDriver<AndroidElement> driver = InitDriver.AlreadyInstalled("127.0.0.1:62001", "co.welab.wolaidai",
				"co.welab.wolaidai.MainActivity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// WebDriverWait wait=new WebDriverWait(driver, 10);
		// wait.until(arg0)	·

		for (int i = 0; i < 5; i++) {
			if (driver.getPageSource().contains("允许") || driver.getPageSource().equals("拒绝")) {
				MobileElement toast = driver.findElement(By.xpath("//*[@resource-id='android:id/button1']"));
				toast.click();
				Thread.sleep(2000);
			}
		}
		Thread.sleep(2000);
		WldLogin wld = new WldLogin(driver);
		Thread.sleep(5000);
		wld.logins("13114545654", "888888");
		wld.applied("我来贷", "511423199405180037");
		Thread.sleep(2000);
		wld.taoxinji();
		// wld.clicksPage();
		// wld.applied("自动化", "511423199312030013");

	}
}
