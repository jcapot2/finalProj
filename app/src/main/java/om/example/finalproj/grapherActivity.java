package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class grapherActivity extends AppCompatActivity {
    GraphView graph;
    double yMax = 0;
    double xMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapher);

        graph = findViewById(R.id.graph);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        Button run = findViewById(R.id.addButton);
        Button clear = findViewById(R.id.clear);
        graph.setVisibility(View.VISIBLE);
        run.setOnClickListener(unused -> throwClicked());
        clear.setOnClickListener(unused -> clearClicked());
    }

    private void throwClicked() {
        EditText vx_input = findViewById(R.id.velX);
        EditText vy_input = findViewById(R.id.velY);
        String vxString, vyString;
        vxString = vx_input.getText().toString();
        vyString = vy_input.getText().toString();
        if (vxString.equals("") == false && vyString.equals("") == false) {
            int vxInt, vyInt;
            vxInt = Integer.valueOf(vxString);
            vyInt = Integer.valueOf(vyString);
            double x, y, t, dt;
            x = 0.0;
            y = 0.0;
            t = 0.0;
            dt = .01;
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
            while (y >= 0) {
                y = vyInt * t - .5 * 9.8 * t * t;
                x = vxInt * t;
                t += dt;
                if (y > yMax) {
                    yMax = y;
                }
                if (x > xMax) {
                    xMax = x;
                }
                DataPoint point = new DataPoint(x, y);
                series.appendData(point, true, 20100);
            }
            graph.getViewport().setMaxX(xMax + 1);
            graph.getViewport().setMaxY(yMax + 1);
            graph.addSeries(series);
        }
    }
    private void clearClicked() {
        graph.removeAllSeries();
        yMax = 0;
        xMax = 0;
        graph.getViewport().setMaxX(xMax + 1);
        graph.getViewport().setMaxY(yMax + 1);
    }
}
