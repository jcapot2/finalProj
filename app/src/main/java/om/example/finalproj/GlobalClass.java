package om.example.finalproj;

import android.app.Application;

public class GlobalClass extends Application {
    private static int countCorrect = 0;
    public static void setCountCorrect(int count) {
        countCorrect = count;
    }
    public static int getCountCorrect() {
        return countCorrect;
    }
}
