import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class CalcTest {
    private static WindowsDriver calcSession;

    public static String getDate() {
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        return date.toString();
    }

    @BeforeClass
    public static void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Windows\\System32\\calc.exe");
            capabilities.setCapability("platformName","Windows");
            capabilities.setCapability("deviceName","DESKTOP-JDJ0ASK");
            calcSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            calcSession.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void cleanApp() {
        calcSession.quit();
        setUp();
    }

//    @AfterSuite
//    public void tearDown() {
//        calcSession.quit();
//    }

    @Test
    public void twiceTwo() {
        calcSession.findElement(By.xpath("\"/Pane[@ClassName=\\\"#32769\\\"][@Name=\\\"Рабочий стол 1\\\"]/Window[@ClassName=\\\"ApplicationFrameWindow\\\"][@Name=\\\"Калькулятор\\\"]/Window[@ClassName=\\\"Windows.UI.Core.CoreWindow\\\"][@Name=\\\"Калькулятор\\\"]/Custom[@AutomationId=\\\"NavView\\\"]/Group[@ClassName=\\\"LandmarkTarget\\\"]/Group[@Name=\\\"Числовая панель\\\"][@AutomationId=\\\"NumberPad\\\"]/Button[@Name=\\\"Два\\\"][@AutomationId=\\\"num2Button\\\"]\"")).click();
        calcSession.findElement(By.xpath("\"/Pane[@ClassName=\\\"#32769\\\"][@Name=\\\"Рабочий стол 1\\\"]/Window[@ClassName=\\\"ApplicationFrameWindow\\\"][@Name=\\\"Калькулятор\\\"]/Window[@ClassName=\\\"Windows.UI.Core.CoreWindow\\\"][@Name=\\\"Калькулятор\\\"]/Custom[@AutomationId=\\\"NavView\\\"]/Group[@ClassName=\\\"LandmarkTarget\\\"]/Group[@Name=\\\"Стандартные операторы\\\"][@AutomationId=\\\"StandardOperators\\\"]/Button[@Name=\\\"Умножить на\\\"][@AutomationId=\\\"multiplyButton\\\"]\"")).click();
        calcSession.findElement(By.xpath("\"/Pane[@ClassName=\\\"#32769\\\"][@Name=\\\"Рабочий стол 1\\\"]/Window[@ClassName=\\\"ApplicationFrameWindow\\\"][@Name=\\\"Калькулятор\\\"]/Window[@ClassName=\\\"Windows.UI.Core.CoreWindow\\\"][@Name=\\\"Калькулятор\\\"]/Custom[@AutomationId=\\\"NavView\\\"]/Group[@ClassName=\\\"LandmarkTarget\\\"]/Group[@Name=\\\"Числовая панель\\\"][@AutomationId=\\\"NumberPad\\\"]/Button[@Name=\\\"Два\\\"][@AutomationId=\\\"num2Button\\\"]\"")).click();
        calcSession.findElement(By.xpath("\"/Pane[@ClassName=\\\"#32769\\\"][@Name=\\\"Рабочий стол 1\\\"]/Window[@ClassName=\\\"ApplicationFrameWindow\\\"][@Name=\\\"Калькулятор\\\"]/Window[@ClassName=\\\"Windows.UI.Core.CoreWindow\\\"][@Name=\\\"Калькулятор\\\"]/Custom[@AutomationId=\\\"NavView\\\"]/Group[@ClassName=\\\"LandmarkTarget\\\"]/Group[@Name=\\\"Стандартные операторы\\\"][@AutomationId=\\\"StandardOperators\\\"]/Button[@Name=\\\"Равно\\\"][@AutomationId=\\\"equalButton\\\"]\"")).click();

        String actualString = calcSession.findElement(By.xpath("\"/Pane[@ClassName=\\\"#32769\\\"][@Name=\\\"Рабочий стол 1\\\"]/Window[@ClassName=\\\"ApplicationFrameWindow\\\"][@Name=\\\"Калькулятор\\\"]/Window[@ClassName=\\\"Windows.UI.Core.CoreWindow\\\"][@Name=\\\"Калькулятор\\\"]/Custom[@AutomationId=\\\"NavView\\\"]/Group[@ClassName=\\\"LandmarkTarget\\\"]/Text[@Name=\\\"Отображать как 4\\\"][@AutomationId=\\\"CalculatorResults\\\"]\"")).getText();

        Assert.assertEquals(actualString, "Отображать как 4");
    }
}