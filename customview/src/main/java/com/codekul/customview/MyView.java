package com.codekul.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by aniruddha on 2/1/18.
 */

public class MyView extends EditText {

    private Paint paint;
    private float cx, cy;

    public MyView(Context context) {
        super(context);

        // when u are creating view from code
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // when u are creating view from xml
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx, cy, 30, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        cx = event.getX();
        cy = event.getY();
        invalidate();

        return true;
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
    }
}
