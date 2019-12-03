package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;
//nothing much, hbu
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {
    GraphView graph;
    double yMax = 0;
    double xMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.button);
        start.setOnClickListener(unused -> startClicked());
    }
    private void startClicked() {
        startActivity(new Intent(this, grapherActivity.class));
        finish();
    }
}