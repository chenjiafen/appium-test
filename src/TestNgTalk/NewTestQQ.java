package TestNgTalk;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.AppiumStartServer;
import com.appium.InitDriver;
import com.wolaidi.testcase.TalkingTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.HasNetworkConnection;

public class NewTestQQ {
	AndroidDriver<AndroidElement> driver;
	TalkingTest talk;

	@BeforeClass
	public void init() throws Exception {
		AppiumStartServer.StartAppiumService();

		driver = InitDriver.AlreadyInstalled("DRGGAM2862311219", "com.tencent.mobileqq.activity.SplashActivity",
				"com.tencent.qqlite");
		talk = new TalkingTest(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider
	public static Object[][] dataLogin() {
		return new Object[][] { { "1610172022", "chen980985672" }, { "980985672", "Chen122793F*" } };
	}

	@Test(dataProvider = "dataLogin")
	public void test001_login(String user, String pass) {
		talk.login(user, pass);
		String a = ((HasNetworkConnection) driver).getConnection().name();
		System.out.println("当前网络：" + a);
	}

	@AfterMethod
	public void startAPP() {
		driver.resetApp();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

