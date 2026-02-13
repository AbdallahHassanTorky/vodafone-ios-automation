import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URL;
import java.time.Duration;

public class AppTest {
    public static void main(String[] args) {
        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName("iPhone 15")
            .setPlatformName("iOS")
            .setAutomationName("XCUITest")
            // ننتظر 5 دقائق حتى يفتح المحاكي تماماً في السحابة
            .setWdaLaunchTimeout(Duration.ofMinutes(5));

        System.out.println("جاري محاولة فتح محاكي iOS باستخدام Java...");

        try {
            IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("مبروك! تم الاتصال بنجاح وفتح المحاكي.");
            
            Thread.sleep(5000); // انتظر 5 ثواني للمعاينة
            driver.quit();
            System.out.println("تم إغلاق الجلسة بنجاح.");
        } catch (Exception e) {
            System.out.println("حدث خطأ أثناء الاتصال: " + e.getMessage());
            e.printStackTrace();
        }
    }
}