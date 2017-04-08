package com.allen.recyclerview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;

import com.allen.recyclerview.R;
import com.chad.library.adapter.base.util.TouchEventUtil;
import com.orhanobut.logger.Logger;

public class ScrollByView extends FrameLayout {


    private int mLastX;
    private int mLastY;
    private boolean mDragging;
    private float mDownX;
    private float mDownY;
    private int mScaledMinimumFlingVelocity;
    private int mScaledMaximumFlingVelocity;
    private int mScaledTouchSlop;
    private OverScroller mScroller;
    public ScrollByView(Context context) {
        super(context);
        init(null, 0);
    }

    public ScrollByView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ScrollByView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ScrollByView, defStyle, 0);

        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mScaledTouchSlop = configuration.getScaledTouchSlop();
        mScaledMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
        mScaledMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        mScroller = new OverScroller(getContext());
        a.recycle();

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean isIntercepted = super.onInterceptTouchEvent(ev);
//        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN: {
//                mDownX = mLastX = (int) ev.getX();
//                mDownY = (int) ev.getY();
//                return false;
//            }
//            case MotionEvent.ACTION_MOVE: {
//                int disX = (int) (ev.getX() - mDownX);
//                int disY = (int) (ev.getY() - mDownY);
//                return Math.abs(disX) > mScaledTouchSlop && Math.abs(disX) > Math.abs(disY);
//            }
//            case MotionEvent.ACTION_UP: {
//
//                return false;
//            }
//            case MotionEvent.ACTION_CANCEL: {
//                if (!mScroller.isFinished())
//                    mScroller.abortAnimation();
//                return false;
//            }
//        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private VelocityTracker mVelocityTracker;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Logger.d( TouchEventUtil.getTouchAction(ev.getAction()));
        if (mVelocityTracker == null) mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(ev);
        int dx;
        int dy;
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mLastX = (int) ev.getX();
                mLastY = (int) ev.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int disX = (int) (mLastX - ev.getX());
                int disY = (int) (mLastY - ev.getY());
                if (!mDragging && Math.abs(disX) > mScaledTouchSlop && Math.abs(disX) > Math.abs(disY)) {
                    mDragging = true;
                }
//               scrollBy(disX, 0);
//                getChildAt(1).layout(-disX,disY,-disX+200,disY+200);
                getChildAt(0).layout(disX,disY,disX+200,disY+200);
//                getChildAt(0).layout(disX,disY,disX+200,disY+200);
//                scrollBy(disX, 0);
//                if (mDragging) {
//                    scrollBy(disX, 0);
//                    mLastX = (int) ev.getX();
//                    mLastY = (int) ev.getY();
//                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                dx = (int) (mDownX - ev.getX());
                dy = (int) (mDownY - ev.getY());
                mDragging = false;
                mVelocityTracker.computeCurrentVelocity(1000, mScaledMaximumFlingVelocity);
                int velocityX = (int) mVelocityTracker.getXVelocity();
                int velocity = Math.abs(velocityX);
                if (velocity > mScaledMinimumFlingVelocity) {
                        ViewCompat.postInvalidateOnAnimation(this);
                } else {
//                    judgeOpenClose(dx, dy);
                }
                getChildAt(0).layout(dx+velocityX,dy+velocity,dx+velocityX+200,dy+velocity+200);
                mVelocityTracker.clear();
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                if (Math.abs(mDownX - ev.getX()) > mScaledTouchSlop
                        || Math.abs(mDownY - ev.getY()) > mScaledTouchSlop
                        ) {
                    ev.setAction(MotionEvent.ACTION_CANCEL);
                    super.onTouchEvent(ev);
                    return true;
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                mDragging = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                } else {
                    dx = (int) (mDownX - ev.getX());
                    dy = (int) (mDownY - ev.getY());
                }
                break;
            }
        }

        return super.onTouchEvent(ev);
    }

}
