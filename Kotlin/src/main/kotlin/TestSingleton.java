public class TestSingleton {
    private static TestSingleton testSingleton = null;
    private TestSingleton(){

    }

    public static  TestSingleton getInstance(){
        if(testSingleton == null){
            if(testSingleton ){
                testSingleton = new TestSingleton();
            }
        }
        return testSingleton;
    }
}
