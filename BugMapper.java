public class BugMapper{

    private static BugMapper instance = null;

    private int totalTestsRun;
    private int totalTestsPassed;
    private double testPassPercentage;
    private StringLinkedList resultLog;

    private StringLinkedList timeLog;

    private BugMapper(){
        resultLog = new StringLinkedList();
        timeLog = new StringLinkedList();
    }

    public static BugMapper getInstance(){
        if(instance == null){
            instance = new BugMapper();
        }
        return instance;
    }

    public void RunTests(){

        String boldWhite = "\033[1;37m";
        String resetColour = "\033[0m";
        String red = "\033[1;31m";
        String green = "\033[1;32m";

        System.out.println(boldWhite+"\n\n ===== TEST REPORT =====\n");
        
        int count = 1;
        System.out.println(resetColour+" #### ASSERTION TESTS #### ");
        while(resultLog.hasNext()){
            String next = resultLog.next().value;
            String colour = (next.contains("passed")) ? green : red;  
            System.out.println("-> Test "+count+" : "+colour+next+resetColour);
            count++;
        }

        count = 1;
        System.out.println(resetColour+"\n #### RUNTIME TESTS #### ");
        while(timeLog.hasNext()){
            System.out.println("-> Runtime Test "+count+" : "+timeLog.next().value);
            count++;
        }


        testPassPercentage = 100 * totalTestsPassed/totalTestsRun;
        System.out.println("\n >> "+totalTestsPassed+" tests passed of "+totalTestsRun+" tests ("+testPassPercentage+"%)");
    }


    /**
     * to run, put 'testRunTime( YourClass::yourMethod );'
     * 
     * @param method the method you're testing the run time of
     * @return a string describing how long it took the method to run.
     */
    public void TestRunTime(test method){
        double time;
        try{            
            double start = System.currentTimeMillis();
    
            method.run();
    
            double end = System.currentTimeMillis();
    
            time = (end - start) / 1000;
            timeLog.add( "tested method took "+time+" seconds to run");
        }catch(Exception e){
            timeLog.add("there was an exception thrown in your method:\n"+e.getMessage());
        }
    }


    public void assertTrue(boolean expression){
        totalTestsRun++;
        if(! ((boolean)expression) ){
            resultLog.add("expression did not evaluate to true.");
            return;
        }
        resultLog.add("assertTrue passed.");
        totalTestsPassed++;
    }


    public void assertFalse(boolean expression){
        totalTestsRun++;
        if( ((boolean)expression) ){
            resultLog.add("expression did not evaluate to false.");
            return;
        }
        resultLog.add("assertFalse passed.");
        totalTestsPassed++;
    }


    public void assertNull(Object expression){
        totalTestsRun++;
        if( expression != null){
            resultLog.add("object is not null.");
            return;
        }
        resultLog.add("assertNull passed.");
        totalTestsPassed++;
    }


    public void assertNotNull(Object expression){
        totalTestsRun++;
        if( expression == null ){
            resultLog.add("object is null.");
            return;
        }
        resultLog.add("assertNotNull passed.");
        totalTestsPassed++;
    }
}