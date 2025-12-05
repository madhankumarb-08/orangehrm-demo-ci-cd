package Testcomponents;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Rtry implements IRetryAnalyzer
{
    private int count = 0;
    @Override
    public boolean retry(ITestResult result)
    {
        int max = 1;
        if(max>count)
        {
            count++;
            return true;
        }
        return false;
    }
}
