package Constants;

/**
 * Created by Kreliou on 15/10/2015.
 */
public class test {
    private static test ourInstance = new test();

    public static test getInstance() {
        return ourInstance;
    }

    private test() {
    }
}
