package om.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

import java.text.DecimalFormat;

/**
 * activity for the simple kinematics grapher :)
 */
public class grapherActivity extends AppCompatActivity {
    //New view from graphing library!
    GraphView graph;
    //for scaling Y-Axis
    double yMax = 0;
    //for scaling X-Axis
    double xMax = 0;
    //Setting up rounding standard for large doubles
    private static DecimalFormat df = new DecimalFormat("0.000");
    //text colors in scroll view
    private String throwColor = "#ff7700";
    private String errorColor = "#FD0204";
    private String clearColor = "#3eafdb";
    //text size
    private int tSize = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapher);
        //fixes soft keyboard shifting UI upwards
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        graph = findViewById(R.id.graph);
        //manually adjusting x and y scaling
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.setVisibility(View.VISIBLE);
        //get some buttons
        Button backButt = findViewById(R.id.back);
        Button run = findViewById(R.id.addButton);
        Button clear = findViewById(R.id.clear);
        //auto-fill input boxes for user to see some standard working numbers
        EditText x = findViewById(R.id.velX);
        EditText y = findViewById(R.id.velY);
        EditText g = findViewById(R.id.gravity);
        x.setText("1");
        y.setText("1");
        g.setText("10");
        //set listeners for buttons
        run.setOnClickListener(unused -> throwClicked());
        clear.setOnClickListener(unused -> clearClicked());
        backButt.setOnClickListener(unused -> backClicked());
    }

    /**
     * handles calculations for the throw if inputs are valid. Outputs throw results in
     * scrollable terminal window
     */
    private void throwClicked() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.termScroll);
        EditText vx_input = findViewById(R.id.velX);
        EditText vy_input = findViewById(R.id.velY);
        EditText g_input = findViewById(R.id.gravity);
        String vxString, vyString, gravString;
        vxString = vx_input.getText().toString();
        vyString = vy_input.getText().toString();
        gravString = g_input.getText().toString();
        String output;
        //Run calculations if all input data exists
        if (!(vxString.equals("")) && !(vyString.equals("")) && !(gravString.equals("")) && !(gravString.equals("0"))) {
            int vxInt, vyInt, g;
            double ymaxExact, xmaxExact, timeFlight;
            vxInt = Integer.valueOf(vxString);
            vyInt = Integer.valueOf(vyString);
            g = Integer.valueOf(gravString);
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
                //push y and x bounds for scaling
                if (y > yMax) {
                    yMax = y;
                }
                if (x > xMax) {
                    xMax = x;
                }
                DataPoint point = new DataPoint(x, y);
                series.appendData(point, true, 20100);
            }
            //scale the graph and add data
            graph.getViewport().setMaxX(xMax + 1);
            graph.getViewport().setMaxY(yMax + 1);
            graph.addSeries(series);
            //Populate terminalView
            ymaxExact = (Double.valueOf(vyInt*vyInt))/(2*g);
            xmaxExact = Double.valueOf(2*vyInt*vxInt)/g;
            timeFlight = Double.valueOf(2*vyInt)/g;
            TextView tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //lots of spacing to make the numbers line up and look neater
            output = "Maximum Height:      " + df.format(ymaxExact) + " (m)\n" +
                     "Maximum Distance:  " + df.format(xmaxExact) + " (m)\n" +
                     "Flight Time:                 " + df.format(timeFlight) + " (s)\n";
            tv.setText(output);
            tv.setTextColor(Color.parseColor(throwColor));
            tv.setTextSize(tSize);
            layout.addView(tv, 0);
        } else {
            //Populate terminalView
            TextView tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setText("Invalid Input\n");
            tv.setTextColor(Color.parseColor(errorColor));
            tv.setTextSize(tSize);
            layout.addView(tv, 0);
        }
    }

    /**
     * Clear terminal history and throw paths on graph
     */
    private void clearClicked() {
        //remove data
        graph.removeAllSeries();
        //reset graph scaling
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
        tv.setTextColor(Color.parseColor(clearColor));
        tv.setTextSize(tSize);
        layout.addView(tv, 0);
    }

    /**
     * Go back to menu and close grapher activity *o*
     */
    private void backClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}