package PageObjects;

// https://docs.saucelabs.com/reference/platforms-configurator/#/
public interface Config {

String baseUrl        = System.getProperty("baseUrl", "http://the-internet.herokuapp.com"); //2nd param is the default to use
String browser        = System.getProperty("browser", "firefox");

        //to support executing using SauceLabs
String host           = System.getProperty("host", "localhost"); //or "saucelabs" or "saucelabs-mobile"
String browserVersion = System.getProperty("browserVersion", "33");
String platform       = System.getProperty("platform", "Windows 8.1"); // iOS or Android for mobile or Linux for emulator

        //to turn off screen and video capture if required. true = enabled, false = disabled
String recordVideo    = System.getProperty("recordVideo", "true");        //defaults to record
String recordScreenshots = System.getProperty("recordScreenshots", "true");

        //build and tags in saucelabs
// final Arrays tags            = System.getProperty("tags","");
String build          = System.getProperty("build","debug");

        //For Mobile saucelabs testing using appium. See https://docs.saucelabs.com/tutorials/appium/ for the full list of possible capabilities
String device         = System.getProperty("deviceName", "Android Emulator");
String platformVersion = System.getProperty("platformVersion", "");  // eg 8.0, 7.1 for iOS or 5.0, 5.1 for Android
String appiumVersion = System.getProperty("appiumVersion", "");
String app            = System.getProperty("app", "");                // only for mobile native application or mobile hybrid application tests): The path to a .ipa, .apk or .zip file containing the app to test
String deviceOrientation = System.getProperty("device-orientation","portrait");

        //These details can be stored as environment variables then replace with System.getenv("SAUCE_USERNAME") and "SAUCE_ACCESS_KEY"
String sauceUser = "markwinspear";
String sauceKey = "3e478c65-7a2a-4119-b4a1-cb96b23e6ed5";
}