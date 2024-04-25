package com.EmiratesflightQA.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateReoprt() {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\tes-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Emirates Flight QA Testing Results Report");
		sparkReporter.config().setDocumentTitle("Emirates Flight Automation Report");
		sparkReporter.config().setTimeStampFormat("DD/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		return extentReport;
	}
}
