import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class AppTest {
    
    private IOSDriver driver;
    
    @BeforeTest
    public void setup() {
        try {
            XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15")
                .setPlatformName("iOS")
                .setAutomationName("XCUITest")
                .setWdaLaunchTimeout(Duration.ofMinutes(5));
            
            System.out.println("جاري محاولة فتح محاكي iOS باستخدام Java...");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("مبروك! تم الاتصال بنجاح وفتح المحاكي.");
        } catch (Exception e) {
            System.out.println("حدث خطأ أثناء الاتصال: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Test
    public void testIOSConnection() {
        System.out.println("اختبار الاتصال بالمحاكي...");
        if (driver != null) {
            System.out.println("الاتصال ناجح!");
        }
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("تم إغلاق الجلسة بنجاح.");
        }
    }
}
