package com.appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class InitDriver {
	/**
	 * 
	 * 
	 * @param uuid
	 * @return
	 */
	public static DesiredCapabilities getCommand(String uuid) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "测试名"); // 设备名
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");// 测试平台类型
//		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true); // 是否支持appium自动化的输入法
//		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true); // 是否支持重置
		cap.setCapability(AndroidMobileCapabilityType.NO_SIGN, true); // 是否不重签名
		
//		 cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2"); // 测试索引框架
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		
		//安卓多设备时并且使用uiautomator2引擎时，需要指定不同systemport

//		cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.valueOf(sysPort));
		// chromedriver 的路径
		File chromedriver = new File(
				"C:\\Users\\tyler.chen\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver2.44.exe");
		// 制定chromedriver 的路径
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriver.getAbsolutePath());
		 cap.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true); // 每次是否重新创建chromedriver
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);// session 超时时间
		cap.setCapability(MobileCapabilityType.UDID, uuid); // 设备的udid
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);// 默认授权app所需要的权限
		// cap.setCapability(AndroidMobileCapabilityTyp, value);
		

		return cap;
	}

	/**
	 * 未安装app
	 * 
	 * @param uuid
	 * @param appth
	 * @return
	 * @throws Exception
	 */
	public static AndroidDriver<AndroidElement> InitDriverWithInaller(String uuid, String appth) throws Exception {
		File app = new File(appth);
		DesiredCapabilities cap = getCommand(uuid);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
				"C://Users//tyler.chen//AppData//Roaming//npm//node_modules//appium//node_modules//appium-chromedriver//chromedriver//win//chromedriver72.exe");
		cap.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

	/**
	 * 
	 * 
	 * @param uuid
	 * @param appth
	 * @param waitActivity
	 * @return
	 * @throws Exception
	 */
	public static AndroidDriver<AndroidElement> InitDriverWithInaller(String uuid, String appth, String waitActivity)
			throws Exception {
		File app = new File(appth);
		DesiredCapabilities cap = getCommand(uuid);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, waitActivity);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

	/**
	 * 已安装
	 * 
	 * @param uuid
	 * @param activity
	 * @param appPackage
	 * @return
	 * @throws IOException
	 */
	public static AndroidDriver<AndroidElement> AlreadyInstalled(String uuid, String appPackage, String activity)
			throws IOException {
		DesiredCapabilities cap = getCommand(uuid);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;

	}

	/**
	 * 
	 * 
	 * @param uuid
	 * @param activity
	 * @param appPackage
	 * @param waitActivity	
	 * @return
	 * @throws IOException
	 * 
	 */
	public static AppiumDriver<MobileElement> AlreadyInstalled(String uuid, String activity, String appPackage,
			String waitActivity) throws IOException {
		DesiredCapabilities cap = getCommand(uuid);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, waitActivity);
		AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL("http://127.0.0.1:4724/wd/hub"), cap);
		return driver;

	}
}