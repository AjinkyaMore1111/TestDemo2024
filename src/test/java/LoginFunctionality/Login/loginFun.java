package LoginFunctionality.Login;

import java.io.FileInputStream;

import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class loginFun {
	DesiredCapabilities ds=new DesiredCapabilities();
	
@Test
	public void login() throws IOException, InterruptedException
	{
    DesiredCapabilities ds=new DesiredCapabilities();
	ds.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
	ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	ds.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5");
    ds.setCapability(MobileCapabilityType.APP,"D:\\Test_APK\\IndiGo - Book Flight Ticket_5.2.2_Apkpure.apk");
    URL appiumServerURL=new URL("http://127.0.0.1:4723/wd/hub");
	AppiumDriver<MobileElement> driver = new AndroidDriver<>(appiumServerURL, ds);
	Thread.sleep(5000);
    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    MobileElement Allow=driver.findElement(By.xpath("//*[@text='Allow']"));
	Allow.click();
	Thread.sleep(5000);
	MobileElement MobileNo=driver.findElement(By.xpath("//*[@text='Continue with Mobile Number']"));
	MobileNo.click();
	Thread.sleep(5000);
	MobileElement WhileusingApp=driver.findElement(By.xpath("//*[@text='While using the app']"));
	WhileusingApp.click();
	Thread.sleep(5000);
	//Click on Password Tab
	MobileElement Pwd=driver.findElement(By.xpath("//*[@text='Password']"));
	Pwd.click();

	Thread.sleep(10000);

	FileInputStream file=new FileInputStream("D:\\Test_APK\\Test_Cases_(Indigo_Flight_Login).xlsx)");
	XSSFWorkbook wb=new XSSFWorkbook(file);
	XSSFSheet sheet=wb.getSheetAt(0);
	wb.close();
	
	
	//Enter a Mobile No
	XSSFRow Currentrow14=sheet.getRow(14);
	Long MobileNO=(long) Currentrow14.getCell(5).getNumericCellValue();
    driver.findElement(By.xpath("//*[@text='Enter Mobile Number']")).sendKeys(String.valueOf(MobileNO));
    System.out.println(MobileNO);
    	Thread.sleep(5000);
    //Enter a Password
	XSSFRow Currentrow15=sheet.getRow(15);
	String Password=Currentrow15.getCell(5).getStringCellValue();
	driver.findElement(By.xpath("//*[@text='Enter Password']")).sendKeys(Password);
	System.out.println(Password);
	Thread.sleep(5000);
	
	
	//Click on Login Button
	driver.findElement(By.xpath("//*[@text='Login']")).click();


}


}
