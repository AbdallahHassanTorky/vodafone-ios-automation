from appium import webdriver
from appium.options.common import AppiumOptions
import time

def run_ios_test():
    # 1. إعدادات المحاكي (Capabilities)
    # بنحدد نوع الجهاز وإصدار النظام اللي جيت هاب هيوفره لنا مجاناً
    options = AppiumOptions()
    options.set_capability('platformName', 'iOS')
    options.set_capability('automationName', 'XCUITest')
    options.set_capability('deviceName', 'iPhone 15') 
    
    # ملاحظة للـ QA: في GitHub Actions، البرنامج يكون جاهزاً بهذا الاسم افتراضياً
    print("جاري محاولة الاتصال بسيرفر Appium وفتح محاكي iOS...")

    try:
        # 2. بدء الجلسة (Connect to Server)
        # العنوان 127.0.0.1 هو العنوان المحلي للسيرفر الذي سيعمل في السحابة
        driver = webdriver.Remote('http://127.0.0.1:4723', options=options)
        
        print("مبروك! المحاكي فتح بنجاح وجهازك الـ Dell لم يستهلك أي رامات.")
        
        # ننتظر 5 ثواني للتأكد من استقرار الشاشة
        time.sleep(5)
        
        # 3. إغلاق الجلسة
        driver.quit()
        print("تم إغلاق المحاكي بنجاح بعد التأكد من عمله.")
        
    except Exception as e:
        print(f"حدث خطأ أثناء محاولة فتح المحاكي: {e}")

if __name__ == "__main__":
    run_ios_test()