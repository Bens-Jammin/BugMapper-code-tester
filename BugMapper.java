public class BugMapper{

    private static BugMapper instance = null;

    private int totalTestsRun;
    private int totalTestsPassed;
    private double testPassPercentage;
    private StringLinkedList resultLog;

    private BugMapper(){
        resultLog = new StringLinkedList();
    }

    public BugMapper getInstance(){
        if(instance == null){
            instance = new BugMapper();
        }
        return instance;
    }

    public void RunTests(){
        System.out.println(" ===== TEST REPORT =====");
        
        int count = 0;
        while(resultLog.hasNext()){
            System.out.println("-> Test "+count+" : "+resultLog.next());
            count++;
        }


        testPassPercentage = 100 * (totalTestsPassed/totalTestsRun);
        System.out.println(" >> "+totalTestsPassed+" tests passed of "+totalTestsRun+" tests ("+testPassPercentage+"%)");
    }


    /**
     * to run, put 'testRunTime(YourClass::yourmethod);'
     * 
     * @param method the method you're testing the run time of
     */
    public double TestRunTime(test method){
        double start = System.currentTimeMillis();

        method.run();

        double end = System.currentTimeMillis();

        return end - start;
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