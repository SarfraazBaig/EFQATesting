package com.EmiratesflightQA.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.EmiratesflightQA.utilities.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		  extentReport = ExtentReporter.generateReoprt();
	}
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName +"Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, testName +"got successfully Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.INFO, testName +"got successfully Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.INFO, testName +"got skipped");

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	
}
