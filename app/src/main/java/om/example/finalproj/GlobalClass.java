package om.example.finalproj;

import android.app.Application;

public class GlobalClass extends Application {
    private static int countCorrect = 0;
    private static boolean gotCorrectAns1 = false;
    private static boolean gotCorrectAns2 = false;
    private static boolean gotCorrectAns3 = false;
    public static void setCountCorrect(int count) {
        countCorrect = count;
    }
    public static int getCountCorrect() {
        return countCorrect;
    }
    public static void setGotCorrectAns1(boolean ans) { gotCorrectAns1 = ans; }
    public static boolean getgotCorrectAns1() { return gotCorrectAns1; }
    public static void setGotCorrectAns2(boolean ans) { gotCorrectAns2 = ans; }
    public static boolean getgotCorrectAns2() { return gotCorrectAns2; }
    public static void setGotCorrectAns3(boolean ans) { gotCorrectAns3 = ans; }
    public static boolean getgotCorrectAns3() { return gotCorrectAns3; }
}
