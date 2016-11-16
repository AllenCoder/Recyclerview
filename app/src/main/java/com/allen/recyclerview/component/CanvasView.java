package com.allen.recyclerview.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.allen.recyclerview.R;

/**
 * TODO: document your custom view class.
 */
public class CanvasView extends View {

    public CanvasView(Context context) {
        super(context);
        init(null, 0);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CanvasView, defStyle, 0);

        a.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);

    }

    private Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(getWidth()/2-80,getHeight()/2-60,100,mPaint);
//
//        canvas.drawRect(getWidth()/2-220,getHeight()/2+50,getWidth()/2+20,getHeight()/2+250,mPaint);
        Matrix matrix = new Matrix();
        matrix = new Matrix();
        matrix.postScale(2, 2);
//        canvas.save();
        canvas.setMatrix(matrix);
        mPaint.setColor(Color.RED);
//        canvas.concat(matrix);
        canvas.drawRect(100, 100, 300, 300, mPaint);
//        canvas.restore();
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(300, 300, 500, 500, mPaint);
        canvas.drawText("canvas.setMatrix(matrix)", 50, 600, mPaint);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        switch (event.getAction()) {

        }
        return super.onTouchEvent(event);
    }
}
