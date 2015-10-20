# selenide-test-2015

First test using Selenide (Selenium) & Maven & Saucelabs

SELENIDE:

Added one line to end of before() method... WebDriverRunner.setWebDriver(driver);

It makes Selenide use your provided instance of webdriver.

See https://github.com/selenide-examples/gmail/blob/master/test/org/selenide/examples for good examples
  including how to wiat for something to disappear..
    $(byText("Loading")).waitUntil(disappears), 20000);

Use chrome plugin 'Selenium Page Object Generator' to create object maps

Verifying options in a dropdown:
     $$("select option").shouldHave(texts("male", "female", "unknown"));

IntelliJ plug in 'Selenium' installed for Selenide

Build error: http://stackoverflow.com/questions/29888592/errorjava-javactask-source-release-8-requires-target-release-1-8

SELENIDE - Using actions:
Look for example in selenide tests:
https://github.com/codeborne/s...
@Test public void userCanUseSeleniumActions() { $(By.name("rememberMe")).shouldNotBe(selected);
actions().click($(By.name("rememberMe"))).build().perform();
$(By.name("rememberMe")).shouldBe(selected); }


To run in Chrome - open Run > Edit Configurations
In VM options, add -Dbrowser=chrome

For other browsers to execute on locally, download the driver and put it in the vendor folder of this project
Then update the if/else statement in Base.java in the tests package
then update VM options accordingly

SAUCELABS
VM option: -Dhost=saucelabs or -Dhost=saucelabs-mobile
(This is entered in the VM options currently for each test - need to set up a parameters file I think
Local execution: -Dhost=localhost

The saucerest library has been added to the pom.xml so we can set a pass or fail in the saucelabs dashboard instead of just showing as "Finished"

Example saucelabs and sauce labs mobile parameter set to use (tested)
-ea -Dhost=saucelabs  -Dplatform="Windows 8.1" -Dbrowser="chrome" -DbrowserVersion=41
-ea -Dhost=saucelabs-mobile -Dplatform="android" -DplatformVersion="5.0"
-ea -Dhost="saucelabs-mobile" -Dbuild="debug1" -Dplatform="Linux" -DplatformVersion="5.1" -Dbrowser="Android"

Note that click and tap check if the constant host is set to "saucelabs-mobile" or not and then either perform a click or a tap
 This means that click and tap can be used interchangeably

MAVEN SUREFIRE PLUGIN:
 Used to execute tests and execute in parallel - pom.xml updated as per Chapter 14
 Run as Maven configuration with Surefire:test as the option with any command line parameters
 This can be run in Jenkins also
 Report is output to target/surefire folder, look for reports and index.html

TFS INTEGRATION:
Requires ultimate version of intelliJ

DATA PROVISIONING:
 Basic example set up with a test in TestLogin
 Next step is to use apache poi to read all data and store it, then to access it via a loop in TestLogin. Check TOD0s

TEST REPORTS:
    http://maven.apache.org/surefire/maven-surefire-report-plugin/usage.html
    run configuration = site:site or just surefire-report:report

Categories set up using Maven surefire - Smoke & Deep categories can be applied to individual @Test or classes
 To run only a subset of tests, use -Dgroups=tests.groups.Smoke or -Dgroups=tests.groups.Deep otherwise all will be run as default (specified in the pom.xml)
 can also use -Dgroups=tests.groups.Shallow,test.groups.Deep

@Override annotation was added to the staring method in tests/Base.java (book does not have this but video walkthrough does and without it,
 saucelabs tests show as "unnamed job" and don't have a "pass" or "fail"

 See Chapter 13 to run tests in saucelabs for applications behind a firewall

