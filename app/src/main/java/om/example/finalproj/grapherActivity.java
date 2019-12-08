package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        graph = findViewById(R.id.graph);
        Button backButt = findViewById(R.id.back);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        Button run = findViewById(R.id.addButton);
        Button clear = findViewById(R.id.clear);
        graph.setVisibility(View.VISIBLE);
        EditText x = findViewById(R.id.velX);
        EditText y = findViewById(R.id.velY);
        EditText g = findViewById(R.id.gravity);
        x.setText("1");
        y.setText("1");
        g.setText("10");
        run.setOnClickListener(unused -> throwClicked());
        clear.setOnClickListener(unused -> clearClicked());
        backButt.setOnClickListener(unused -> backClicked());
    }

    private void throwClicked() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.termScroll);
        EditText vx_input = findViewById(R.id.velX);
        EditText vy_input = findViewById(R.id.velY);
        EditText g_input = findViewById(R.id.gravity);
        String vxString, vyString, gString;
        vxString = vx_input.getText().toString();
        vyString = vy_input.getText().toString();
        gString = g_input.getText().toString();
        if (!(vxString.equals("")) && !(vyString.equals("")) && !(gString.equals(""))) {
            int vxInt, vyInt, g;
            double ymaxExact, xmax;
            vxInt = Integer.valueOf(vxString);
            vyInt = Integer.valueOf(vyString);
            g = Integer.valueOf(gString);
            double x, y, t, dt;
            x = 0.0;
            y = 0.0;
            t = 0.0;
            dt = .01;
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
            while (y >= 0) {
                y = vyInt * t - .5 * g * t * t;
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
            //Populate terminalView
            ymaxExact = (Double.valueOf(vyInt*vyInt))/(2*g);
            System.out.println(ymaxExact);
            TextView tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setText("Maximum Height: " + ymaxExact);
            layout.addView(tv, 0);
        } else {
            //Populate terminalView
            TextView tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setText("Input Invalid");
            layout.addView(tv, 0);
        }
    }
    private void clearClicked() {
        graph.removeAllSeries();
        yMax = 0;
        xMax = 0;
        graph.getViewport().setMaxX(xMax + 1);
        graph.getViewport().setMaxY(yMax + 1);
        //Populate terminalView
        LinearLayout layout = (LinearLayout) findViewById(R.id.termScroll);
        layout.removeAllViews();
        TextView tv = new TextView(this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setText("Cleared Data");
        layout.addView(tv, 0);
    }
    private void backClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}