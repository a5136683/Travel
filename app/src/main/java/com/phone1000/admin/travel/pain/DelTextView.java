package com.phone1000.admin.travel.pain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by james on 16/11/10.
 */

public class DelTextView extends TextView {

    private Paint paint;

    public DelTextView(Context context) {
        this(context, null);
    }

    public DelTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DelTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setDither(true);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.FILL);
        setTextColor(Color.rgb(225,192,00));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();

        canvas.drawLine(0, h / 2, w, h / 2, paint);
    }
}
