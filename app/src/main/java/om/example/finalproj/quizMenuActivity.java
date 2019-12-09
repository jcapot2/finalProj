package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class quizMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        Button quizMenuBackBut = findViewById(R.id.quizMenuBackBut);
        quizMenuBackBut.setOnClickListener(unused -> quizMenuBackButClicked());

        Button qOneBut = findViewById(R.id.qOneBut);
        qOneBut.setOnClickListener(unused -> qOneButClicked());

        Button qTwoBut = findViewById(R.id.qTwoBut);
        qTwoBut.setOnClickListener(unused -> qTwoButClicked());

        Button qThreeBut = findViewById(R.id.qThreeBut);
        qThreeBut.setOnClickListener(unused -> qThreeButClicked());

        TextView scoreNum = findViewById(R.id.scoreNum);
        scoreNum.setText(String.valueOf(GlobalClass.getCountCorrect()) + " / 3");
    }
    private void quizMenuBackButClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private void qOneButClicked() {
        startActivity(new Intent(this, quizActivity.class));
        finish();
    }
    private void qTwoButClicked() {
        startActivity(new Intent(this, quizActivity2.class));
        finish();
    }
    private void qThreeButClicked() {
        startActivity(new Intent(this, QuizActivity3.class));
        finish();
    }
}
