package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class quizMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        Button quizMenuBackBut = findViewById(R.id.quizMenuBackBut);
        quizMenuBackBut.setOnClickListener(unused -> quizMenuBackButClicked());

        Button qOneBut = findViewById(R.id.qOneBut);
        qOneBut.setOnClickListener(unused -> qOneButClicked());

//        Button qTwoBut = findViewById(R.id.qTwoBut);
//        qOneBut.setOnClickListener(unused -> qTwoButClicked());
//
//        Button qThreeBut = findViewById(R.id.qThreeBut);
//        qOneBut.setOnClickListener(unused -> qThreeButClicked());
    }
    private void quizMenuBackButClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private void qOneButClicked() {
        startActivity(new Intent(this, quizActivity.class));
        finish();
    }
//    private void qTwoButClicked() {
//        startActivity(new Intent(this, quizActivity2.class));
//        finish();
//    }
//    private void qThreeButClicked() {
//        startActivity(new Intent(this, quizActivity3.class));
//        finish();
//    }
}
