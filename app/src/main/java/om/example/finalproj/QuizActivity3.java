package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class QuizActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        Button back = (Button) findViewById(R.id.backButQ3);
        back.setOnClickListener(unused -> backButQ3Clicked());
    }
    public void backButQ3Clicked() {
        startActivity(new Intent(this, quizMenuActivity.class));
        finish();
    }
    public void submitIt(View v) {
        CheckBox a1 = (CheckBox) findViewById(R.id.a1);
        CheckBox a2 = (CheckBox) findViewById(R.id.a2);
        CheckBox a3 = (CheckBox) findViewById(R.id.a3);
        CheckBox a4 = (CheckBox) findViewById(R.id.a4);
        TextView theResult = (TextView) findViewById(R.id.theResult);
        if (!a1.isChecked() && !a2.isChecked() && !a3.isChecked() && a4.isChecked()) {
            theResult.setText("Correct!");
            theResult.setTextColor(Color.GREEN);
            GlobalClass.setCountCorrect(GlobalClass.getCountCorrect() + 1);
            if (GlobalClass.getCountCorrect() > 3) {
                GlobalClass.setCountCorrect(3);
            }
        } else {
            theResult.setText("Sorry, this is incorrect");
            theResult.setTextColor(Color.RED);
        }
    }
}
