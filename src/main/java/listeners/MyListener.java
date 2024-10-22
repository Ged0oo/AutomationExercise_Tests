package listeners;

import driverFactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShotManager;

public class MyListener implements ITestListener, IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("*******  Starting TestNG ***************");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("*******  Ending TestNG ***************");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*******  Starting Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*******  Success of Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed.");
        System.out.println("Taking Screenshot ...");
        ScreenShotManager.captureScreenshot(Driver.get(), "ContactUsTest");
        System.out.println("*******  Failure of Test: " + result.getName() + " ***************");
    }

}
