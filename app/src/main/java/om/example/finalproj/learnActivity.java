package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class learnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Button backLearn = (Button) findViewById(R.id.backLearn);
        backLearn.setOnClickListener(unused -> backLearnClicked());
    }
    public void backLearnClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
