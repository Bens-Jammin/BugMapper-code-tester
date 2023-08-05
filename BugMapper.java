import java.util.LinkedList;

public class BugMapper{

    private static BugMapper instance = null;

    private int totalTestsRun;
    private int totalTestsPassed;
    private double testPassPercentage;
    private LinkedList<String> resultLog;

    private BugMapper(){
        resultLog = new LinkedList<String>();
    }

    public BugMapper getInstance(){
        if(instance == null){
            instance = new BugMapper();
        }
        return instance;
    }

    public void RunTests(){
        System.out.println(" ===== TEST REPORT =====");
        
        for(int i=0; i<resultLog.size(); i++){
            System.out.println(resultLog.get(i));   // TODO: make your own implementation of linkedlist / iterator to make this faster
        }                                           // currently O(n^2) , want O(n), plus more control


        testPassPercentage = 100 * (totalTestsPassed/totalTestsRun);
        System.out.println(" >> "+totalTestsPassed+" tests passed of "+totalTestsRun+" tests ("+testPassPercentage+"%)");
    }



    public void assertTrue(boolean expression)throws Exception{
        totalTestsRun++;
        if(! ((boolean)expression) ){
            resultLog.add("expression did not evaluate to true.");
            return;
        }
        resultLog.add("passed.");
        totalTestsPassed++;
    }


    public void assertFalse(boolean expression)throws Exception{
        totalTestsRun++;
        if( ((boolean)expression) ){
            resultLog.add("expression did not evaluate to true.");
            return;
        }
        resultLog.add("passed.");
        totalTestsPassed++;
    }


    public void assertNull(Object expression)throws Exception{
        totalTestsRun++;
        if( expression != null){
            resultLog.add("expression did not evaluate to true.");
            return;
        }
        resultLog.add("passed.");
        totalTestsPassed++;
    }


    public void assertNotNUll(Object expression)throws Exception{
        totalTestsRun++;
        if( expression == null ){
            resultLog.add("expression did not evaluate to true.");
            return;
        }
        resultLog.add("passed.");
        totalTestsPassed++;
    }
}