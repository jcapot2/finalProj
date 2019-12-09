package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quizActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        Button back = findViewById(R.id.backButQ2);
        back.setOnClickListener(unused -> backButQ2Clicked());

    }
    public void backButQ2Clicked() {
        startActivity(new Intent(this, quizMenuActivity.class));
        finish();
    }
    public void go(View v) {
        RadioGroup choices = (RadioGroup) findViewById(R.id.choices);
        int option = choices.getCheckedRadioButtonId();
        TextView result = (TextView) findViewById(R.id.result);
        if (GlobalClass.getgotCorrectAns2() == false) {
            switch (option) {
                case R.id.answer1:
                    result.setText("Sorry, that is incorrect");
                    result.setTextColor(Color.RED);
                    break;
                case R.id.answer2:
                    result.setText("Sorry, that is incorrect");
                    result.setTextColor(Color.RED);
                    break;
                case R.id.answer3:
                    result.setText("Correct!");
                    result.setTextColor(Color.GREEN);
                    GlobalClass.setCountCorrect(GlobalClass.getCountCorrect() + 1);
                    if (GlobalClass.getCountCorrect() > 3) {
                        GlobalClass.setCountCorrect(3);
                    }
                    GlobalClass.setGotCorrectAns2(true);
                    break;
                default:
                    result.setText("");
            }
        } else {
            result.setText("You already got the right answer. Stop flexing");
            result.setTextColor(Color.GREEN);
        }
    }
}
