/**
 *appium 服务启动 和停止
 */
package com.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * @author tyler.chen
 *
 */
public class AppiumStartServer {
	static AppiumDriverLocalService service;
	public static void StartAppiumService(){
	AppiumServiceBuilder ab=new AppiumServiceBuilder();
	service=ab.build();
	service.start();
	}
	public static void stopAppiumService(){
		service.stop();
	}
	public static void main(String[] args) throws Exception {
		AppiumStartServer.StartAppiumService();
		Thread.sleep(3000);
		AppiumStartServer.stopAppiumService();
	}

}
