package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;
//nothing much, hbu
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;

public class MainActivity extends AppCompatActivity {
    GraphView graph;
    double yMax = 0;
    double xMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.graphButton);
        start.setOnClickListener(unused -> startClicked());

        Button learn = findViewById(R.id.glossaryButton);
        learn.setOnClickListener(unused -> learnClicked());

        Button quizBut = findViewById(R.id.quizBut);
        quizBut.setOnClickListener(unused -> quizButClicked());
    }
    private void startClicked() {
        startActivity(new Intent(this, grapherActivity.class));
        finish();
    }
    private void learnClicked() {
        startActivity(new Intent(this, glossaryActivity.class));
        finish();
    }
    private void quizButClicked() {
        startActivity(new Intent(this, quizMenuActivity.class));
        finish();
    }
}