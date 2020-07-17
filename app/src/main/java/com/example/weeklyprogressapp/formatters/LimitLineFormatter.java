package com.example.weeklyprogressapp.formatters;

import com.github.mikephil.charting.formatter.ValueFormatter;

public class LimitLineFormatter extends ValueFormatter {
    @Override
    public String getFormattedValue(float value) {
        if (value == 100)
            return "100 pts";
        return "";
    }

}