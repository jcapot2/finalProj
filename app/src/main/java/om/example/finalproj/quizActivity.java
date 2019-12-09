package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class quizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button quizBackBut = findViewById(R.id.quizBackBut);
        quizBackBut.setOnClickListener(unused -> quizBackButClicked());

        Button submitButOne = findViewById(R.id.submitButOne);
        submitButOne.setOnClickListener(unused -> submitButOneClicked());

        ImageView firstImage = (ImageView) findViewById(R.id.oneImage);
        int imageResource = getResources().getIdentifier("@drawable/kinematics1",
                null, this.getPackageName());
        firstImage.setImageResource(imageResource);
    }
    private void quizBackButClicked() {
//        TextView scoreNum = findViewById(R.id.scoreNum);
//        scoreNum.setText(String.valueOf(GlobalClass.getCountCorrect()) + " / 3");
        startActivity(new Intent(this, quizMenuActivity.class));
        finish();
    }
    private void submitButOneClicked() {
        TextView rightOrWrong = findViewById(R.id.rightOrWrong);
        EditText firstAnswer = findViewById(R.id.firstAnswer);
        String firAns = firstAnswer.getText().toString();
        String rightAnswer = "4.8";
        if (!isNumeric(firAns)) {
            rightOrWrong.setText("Sorry, your answer could not be understood");
            rightOrWrong.setTextColor(Color.YELLOW);
        }
        if (!firAns.equals(rightAnswer)) {
            rightOrWrong.setText("Wrong answer");
            rightOrWrong.setTextColor(Color.RED);
        } else {
            rightOrWrong.setText("Correct!");
            rightOrWrong.setTextColor(Color.GREEN);
            GlobalClass.setCountCorrect(GlobalClass.getCountCorrect() + 1);
            if (GlobalClass.getCountCorrect() > 3) {
                GlobalClass.setCountCorrect(3);
            }
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
