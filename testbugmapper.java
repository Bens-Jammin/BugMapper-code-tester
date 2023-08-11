public class testbugmapper {

    public static void testTimeRun() throws InterruptedException{Thread.sleep(1000, 0);}
public static void main(String[] args) {
    
    BugMapper map = BugMapper.getInstance();

    map.assertFalse(false);
    map.assertFalse(true);

    map.assertTrue(true);
    map.assertTrue(false);

    map.assertNull(null);    
    map.assertNull("new Object()"); 

    map.assertNotNull(12);
    map.assertNotNull(null);

    map.TestRunTime(() -> {
        try {
            testTimeRun();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });


    map.RunTests();
}   
}
