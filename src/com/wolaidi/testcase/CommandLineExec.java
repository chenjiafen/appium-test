package com.wolaidi.testcase;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

/**
 * @author tyler.chen
 *
 */
public class CommandLineExec {
	public static String osName = System.getProperty("os.name");

	public static String executor(String command) throws Exception {
		try {
			String commandBasic = "cmd /c ";
			if (osName.toLowerCase().contains("mac")) {
				commandBasic = "";
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
			CommandLine commandline = CommandLine.parse(commandBasic + command);
			DefaultExecutor exec = new DefaultExecutor();
			exec.setExitValues(null);
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);
			exec.setStreamHandler(streamHandler);
			exec.execute(commandline);

			String out = outputStream.toString("gbk");
			String error = errorStream.toString("gbk");
			if (out.toLowerCase().contains("error") || out.toLowerCase().contains("fail")
					|| error.toLowerCase().contains("error") || error.toLowerCase().contains("fail")) {
				throw new Exception("executore " + command + "failure-->" + out + error);
			}
			return out + error;

		} catch (Exception e) {
			throw new Exception("executore " + command + " failure-->" + e.getMessage());
		}
	}
	// public void getDevices() throws Exception{
	// String s=executor("adb devices");
	// String s1=s.sp
	//
	// }

	public static void main(String[] args) throws Exception {
		System.out.println(executor("adb devices"));
		// System.out.println(executor(
		// "adb -s 127.0.0.1:62026 shell monkey --pct-touch 40 --pct-motion 30
		// --pct-trackball 15 --pct-nav 5 --pct-majornav 4 --pct-syskeys 1
		// --pct-appswitch 2 --pct-anyevent 3 -p com.zhihu.android --throttle
		// 1000 -v -v -v 100 "));
		// System.out.println(executor("adb -s S9B7N17504008582 install -r
		// C:/Users/LXG/Desktop/zhihu.apk"));
		// System.out.println(executor(
		// "adb -s 127.0.0.1:62026 shell am start -a android.intent.action.MAIN
		// -c android.intent.category.LAUNCHER
		// -ncom.zhihu.android/com.zhihu.android.app.ui.activity.LauncherActivity"));
		// Thread.sleep(3000);
		// System.out.println(executor("adb -s 127.0.0.1:62026 shell screencap
		// -p /data/local/tmp/2.png "));
		// System.out.println(
		// executor("adb -s 127.0.0.1:62026 pull /data/local/tmp/1.png
		// C:\\Users\\tyler.chen\\Desktop\\testAPK"));
		//
		// System.out.println(
		// executor("adb logcat |findstr co.welab.wolaidai >
		// C:\\Users\\tyler.chen\\Desktop\\monkey.txt"));
		// System.out.println(executor("adb devices"));
		// // System.out.println(executor(
		// "adb -s 127.0.0.1:52001 shell monkey --pct-touch 30 --pct-trackball
		// 30 -p co.welab.wolaidai --throttle 1000 -v-v-v 1000"));

		List<String> deviceList = new ArrayList<String>();
		String[] resultLines = executor("adb devices").split("/n");
//		String[] resultLines = results.split("/n");
		System.out.println(resultLines.length);
		for (int i = 1; i < resultLines.length - 1; i++) {
			String[] deviceinfo = resultLines[i].split("/t");
			if (deviceinfo[1].trim().toLowerCase().equals("device")) {
				 System.out.println(deviceinfo[1]);
//				deviceList.add(deviceinfo[0]);
			}
		}

	}
}
