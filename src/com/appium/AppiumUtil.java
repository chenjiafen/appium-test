package com.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumUtil {
	public static void sendKeyss(AndroidDriver<AndroidElement> driver, String number) {
		char[] numChars = number.toCharArray();
		for (char c : numChars) {

			int cNum = Integer.valueOf(String.valueOf(c));
			switch (cNum) {
			case 0:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
				break;
			case 1:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
				break;
			case 2:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
				break;
			case 3:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
				break;
			case 4:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
				break;
			case 5:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_5);
				break;
			case 6:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_6);
				break;
			case 7:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_7);
				break;
			case 8:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_8);
				break;
			case 9:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_9);
				break;
			default:
				break;

			}
		}
	}

	/**
	 * 向上滑动
	 * 
	 * @param driver
	 */
	public static void swipToUp(AndroidDriver<AndroidElement> driver) {
		TouchAction ta = new TouchAction(driver);
		int x = driver.manage().window().getSize().getWidth();
		int y = driver.manage().window().getSize().getHeight();
		ta.press(x / 2, y * 7 / 8).waitAction(Duration.ofMillis(2000)).moveTo(x / 2, y * 6 / 8).release().perform();
	}

	/**
	 * 向下滑动
	 * 
	 * @param driver
	 */
	public static void swipToDown(AndroidDriver<AndroidElement> driver) {
		TouchAction ta = new TouchAction(driver);
		int x = driver.manage().window().getSize().getWidth();
		int y = driver.manage().window().getSize().getHeight();
		ta.press(x / 2, y / 8).waitAction(Duration.ofMillis(2000)).moveTo(x / 2, y * 7 / 8).release().perform();

	}

	/**
	 * 向左滑动
	 * 
	 * @param driver
	 */
	public static void swipToLeft(AndroidDriver<AndroidElement> driver) {
		TouchAction ta = new TouchAction(driver);
		int x = driver.manage().window().getSize().getWidth();
		int y = driver.manage().window().getSize().getWidth();
		ta.press(x * 3 / 4, y / 2).waitAction(Duration.ofMillis(2000)).moveTo(x / 4, y / 2).release().perform();

	}

	/**
	 * 向右滑动
	 * 
	 * @param driver
	 */
	public static void swipToRight(AndroidDriver<AndroidElement> driver) {
		TouchAction ta = new TouchAction(driver);
		int x = driver.manage().window().getSize().getWidth();
		int y = driver.manage().window().getSize().getHeight();
		ta.press(x * 3 / 4, y / 2).waitAction(Duration.ofMillis(2000)).moveTo(x / 4, y / 2).release().perform();
	}

	/**
	 * 获取元素的结束坐标点的值
	 * 
	 * @param ele
	 * @return
	 */
	public static Point getEndElement(MobileElement ele) {
		int ele_x = ele.getLocation().getX();
		int ele_y = ele.getLocation().getY();
		int w = ele.getSize().getWidth();
		int h = ele.getSize().getHeight();
		int end_x = ele_x + w;
		int end_y = ele_y + h;
		return new Point(end_x, end_y);
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static Boolean IsElementExit(AndroidDriver<AndroidElement> driver, By by) {
		try {
			driver.findElement(by);
			System.out.println("元素存在");
			return true;
		} catch (Exception e) {
			AppiumUtil.swipToUp(driver);
			return false;
		}

	}

	public static void isElement(AndroidDriver<AndroidElement> driver, MobileElement ele, By by) {
		try {
			MobileElement elemnet = driver.findElement(by);
		} catch (Exception e) {
			System.out.println("元素未找到");
		}
	}

}
