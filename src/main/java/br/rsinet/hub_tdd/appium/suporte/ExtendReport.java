package br.rsinet.hub_tdd.appium.suporte;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {
	public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;


	    public static ExtentReports setExtent(String nomeReport) {
	        htmlReporter = new ExtentHtmlReporter("C:\\Users\\caique.oliveira\\Documents\\reports\\" + nomeReport + ".html");


	        htmlReporter.config().setDocumentTitle("Report de Testes");
	        htmlReporter.config().setReportName("Report TDD");
	        htmlReporter.config().setTheme(Theme.DARK);


	        extent = new ExtentReports();


	        extent.attachReporter(htmlReporter);


	        extent.setSystemInfo("HostName", "LocalHost");
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Teste", "Caique Santana");
	        extent.setSystemInfo("Browser", "Chrome");
	        return extent;
	    }


	    public static ExtentTest createTest(String testName) {
	        test = extent.createTest(testName);
	        return test;
	    }


	    public static void statusReported


	    (ExtentTest test, WebDriver driver, String screenshotName) throws IOException {


	        String caminhoScreen = Screenshot.getScreenshot(driver, screenshotName);


	        test.addScreenCaptureFromPath(caminhoScreen);
	    }


	    public static void quitExtent(ExtentReports extent) {
	        extent.flush();
	    }
	}
	 













