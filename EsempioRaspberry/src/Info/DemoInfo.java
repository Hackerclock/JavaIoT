package Info;

import java.io.IOException;
import java.text.ParseException;

import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;

public class DemoInfo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Serial Number : " + SystemInfo.getSerial() + "\n\n\n");
			System.out.println("CPU Revision : " + SystemInfo.getCpuRevision());
			System.out.println("CPU Architecture : " + SystemInfo.getCpuArchitecture());
			System.out.println("CPU Part: " + SystemInfo.getCpuPart());
			System.out.println("CPU Temperature : " + SystemInfo.getCpuTemperature());
			System.out.println("CPU Core Voltage : " + SystemInfo.getCpuVoltage());
			System.out.println("CPU Model Name : " + SystemInfo.getModelName());
			System.out.println("Processor: " + SystemInfo.getProcessor());
			System.out.println("Hardware Revision : " + SystemInfo.getRevision());
			System.out.println("Board Type: " + SystemInfo.getBoardType().name());
			System.out.println("Total Memory : " + SystemInfo.getMemoryTotal());
			System.out.println("Used Memory	: " + SystemInfo.getMemoryUsed());
			System.out.println("Free Memory	: " + SystemInfo.getMemoryFree());
			
			System.out.println("OS Name : " + SystemInfo.getOsName());
			System.out.println("OS Version : " + SystemInfo.getOsVersion());
			System.out.println("OS Architecture : " + SystemInfo.getOsArch());
			System.out.println("OS Firmware Build : " + SystemInfo.getOsFirmwareBuild());
			System.out.println("OS Firmware Date : " + SystemInfo.getOsFirmwareDate());
			System.out.println("Java Vendor	: " + SystemInfo.getJavaVendor());
			System.out.println("Java Vendor URL : " + SystemInfo.getJavaVendorUrl());
			System.out.println("Java Version : " + SystemInfo.getJavaVersion());
			System.out.println("Java VM	: " + SystemInfo.getJavaVirtualMachine());
			System.out.println("Java Runtime : " + SystemInfo.getJavaRuntime());
			System.out.println("Hostname : " + NetworkInfo.getHostname());
			for (String ipAddress : NetworkInfo.getIPAddresses())
			System.out.println("IP Addresses : " + ipAddress);
		} catch (IOException | InterruptedException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
