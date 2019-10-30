package com.appium;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import org.apache.commons.exec.CommandLine;

import org.apache.commons.exec.DefaultExecutor;

import org.apache.commons.exec.PumpStreamHandler;

public class commandLineExe {

	public static String osName = System.getProperty("os.name");

	public static String executor(String command) throws Exception {

		try {

			String commandBasic = "cmd /c";

			if (osName.toLowerCase().contains("mac")) {

				commandBasic = "";

			}

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

			CommandLine commandLine = CommandLine.parse(commandBasic + command);

			DefaultExecutor exec = new DefaultExecutor();

			exec.setExitValues(null);

			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

			exec.setStreamHandler(streamHandler);

			exec.execute(commandLine);

			String out = outputStream.toString("gbk");

			String error = errorStream.toString("gbk");

			if (out.toLowerCase().contains("error") || out.toLowerCase().contains("fail")

					|| error.toLowerCase().contains("error") || error.toLowerCase().contains("fail")) {

				throw new Exception("executore" + command + "failure--->" + out + error);

			}

			return out + error;

		} catch (Exception e) {

			throw new Exception("executore" + command + "failure--->" + e.getMessage());

		}

	}

	public static  Serializable getUUid() throws Exception {
		String device = null;
		List<String> devicesList = new ArrayList<String>();
		String results = executor("adb devices");
		String[] resultLines = results.split("\n");
		for (int i = 1; i < resultLines.length - 1; i++) {
			// 中间的是个制表符,不是空格
			String[] devicInfo = resultLines[i].split("\t");
			if (devicInfo[1].trim().toLowerCase().contains("device")) {

				devicesList.add(devicInfo[0]);

			}

		}
		for(int i=0;i<devicesList.size();i++){
			System.out.println(devicesList.get(i));
			device = devicesList.get(i);
		}
		return device;


	}


	public static void main(String[] args) throws Exception {
		
		List<String> deviceList=new ArrayList<>();
		String resullt=executor("adb devices");
		
		String[] reseultLines= resullt.split("\n");
		
		for(int i=1;i<reseultLines.length-1;i++){
			
			String [] devicInfo=reseultLines[i].split("\t");
			if(devicInfo[1].trim().toLowerCase().contains("device")){
				deviceList.add(devicInfo[0]);
			}
			
		}
		
		for(int i=0;i<deviceList.size();i++){
			File app = new File("C:\\Users\\tyler.chen\\Desktop\\testAPK\\APP5.3.0.apk");
//			String path="C:\\Users\\tyler.chen\\Desktop\\testAPK\\APP5.3.0.apk";
			System.out.println("获取deviceID========="+deviceList.get(i)+"===========");
			executor(" adb install -s "+deviceList.get(i)+" "+app.getAbsolutePath());
			
		}

	}
		
	

}