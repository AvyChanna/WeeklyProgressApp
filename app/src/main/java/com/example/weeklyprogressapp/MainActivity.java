package com.example.weeklyprogressapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weeklyprogressapp.formatters.DayAxisValueFormatter;
import com.example.weeklyprogressapp.formatters.LimitLineFormatter;
import com.example.weeklyprogressapp.markers.MyMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = (BarChart) findViewById(R.id.chart);
    }

    @Override
    protected void onStart() {
        super.onStart();
        populateChart();
    }

    /**
     * This is where chart gets all of its data.<br>
     * The following method needs to be used to populate bar/histo/line/stem/...<br>
     * <ul>
     *      <li>Make a list of `*Entry`, with 2d coordinates</li>
     *      <li>Make a `*Dataset` from these entries</li>
     *      <li>Make `*Data` from dataset(Seems redundant, but do it)</li>
     *      <li>Add `*Data` to chart and invalidate</li>
     * </ul>
     */
    public void populateChart() {
        chart.setLogEnabled(true);
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry((float) 0.5, 120));
        entries.add(new BarEntry((float) 1.5, 110));
        entries.add(new BarEntry((float) 2.5, 130));
        entries.add(new BarEntry((float) 3.5, 90));
        entries.add(new BarEntry((float) 4.5, 125));
        entries.add(new BarEntry((float) 5.5, 140));
        entries.add(new BarEntry((float) 6.5, 135));


        // add entries to DataSet
        BarDataSet dataSet = new BarDataSet(entries, "");
        // Color of bar
        dataSet.setGradientColor(Color.parseColor("#3F0D12"), Color.parseColor("#A71D31"));
        // Color of value above/below bar
        dataSet.setValueTextColor(Color.BLUE);
        BarData barData = new BarData(dataSet);
        barData.setBarWidth((float) 0.5);
//        chart.set
        barData.setDrawValues(false);
        chart.setData(barData);

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new DayAxisValueFormatter());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
//        xAxis.setLabelCount(7);
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(1f);
        xAxis.setAxisMinimum((float) 0);

        xAxis.setGranularityEnabled(true);


        YAxis leftAxis = chart.getAxisLeft();
//        leftAxis.setLabelCount(0, true);
        leftAxis.setDrawGridLines(false);
//        leftAxis.setValueFormatter(axisFormatter);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMinimum(0f);

        leftAxis.setValueFormatter(new LimitLineFormatter());
        leftAxis.setGranularity(100f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setDrawLimitLinesBehindData(true);
        leftAxis.addLimitLine(new LimitLine(100, ""));

        chart.getAxisRight().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
        chart.setFitBars(true);
        chart.setScaleYEnabled(false);
//        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });
        IMarker mv = new MyMarkerView(this, R.layout.marker_view);
        chart.setMarker(mv);
//        chart.setHighlightPerTapEnabled(true);
//    chart.setHighlightFullBarEnabled(true);
// set the marker to the chart
//        chart.setMarker(marker);
//        l.setExtra(new int[]{Color.RED, Color.GREEN,  Color.BLUE}, new String[]{"RED", "GREEN", "BLUE"});


        // Misc
        chart.invalidate();
    }
}