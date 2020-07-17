package com.example.weeklyprogressapp.formatters;

import com.github.mikephil.charting.formatter.ValueFormatter;

public class DayAxisValueFormatter extends ValueFormatter {

    private final String[] mDays = new String[]{
            "M", "Tu", "W", "Th", "F", "Sa", "Su"
    };


    public DayAxisValueFormatter() {
        super();
    }

    @Override
    public String getFormattedValue(float value) {
        if (value < 0 || value >= 7)
            return "";
//        return String.valueOf(value);
        return mDays[(int) (value)];
    }

}