package hack.sport.sporthealthandroidapp;

import com.github.mikephil.charting.formatter.YAxisValueFormatter;

/**
        * Created by Abhishek Kumar on 2/28/2016.
        */
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

import java.text.DecimalFormat;

public class MyYAxisValueFormatter implements YAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyYAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        return mFormat.format(value) + "";
    }
}
