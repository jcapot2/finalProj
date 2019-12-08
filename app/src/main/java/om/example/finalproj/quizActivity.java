package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

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
        int imageResource = getResources().getIdentifier("@drawable/kinematicsP1",
                null, this.getPackageName());
        firstImage.setImageResource(imageResource);
    }
    private void quizBackButClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private void submitButOneClicked() {
        
    }
}
