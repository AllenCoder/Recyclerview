package com.allen.recyclerview.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.allen.recyclerview.R;

public class RotateActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        initView();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView:
                final ImageView moveImg = new ImageView(this);
                moveImg.setImageResource(R.mipmap.ic_launcher);
                ImageView imageView = (ImageView) v;
                WindowManager wm = getWindowManager();
                final WindowManager.LayoutParams lp = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
                lp.width = imageView.getWidth();
                lp.height = imageView.getHeight();
                lp.format = PixelFormat.TRANSLUCENT;
                lp.gravity = Gravity.LEFT | Gravity.TOP;
                int fromX = (int) moveImg.getX();
                int fromY = (int) moveImg.getY();
                lp.x = fromX;
                lp.y = fromY - imageView.getHeight();

                imageView.setPivotX(lp.width / 2);
                imageView.setPivotY(lp.height / 2);

                try {
                    wm.addView(moveImg, lp);
                } catch (Exception e) {
                    return;
                }

                Path path = getAnimMovePath(v.getX(),v.getY(),100,100);
                final PathMeasure pm = new PathMeasure(path, false);

                final float totalLen = pm.getLength();
                ValueAnimator animator = ValueAnimator.ofFloat(0, totalLen)
                        .setDuration(2000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float curLen = (float) animation.getAnimatedValue();

                        moveImg.setRotation(3000 * (1 - curLen / totalLen));

                        float[] curPos = new float[2];
                        pm.getPosTan(curLen, curPos, null);
                        lp.x = (int) curPos[0];
                        lp.y = (int) curPos[1];

                        getWindowManager().updateViewLayout(moveImg, lp);
                    }
                });
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        try {
                            getWindowManager().removeView(moveImg);
                        } catch (Exception e) {
                            // null
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        onAnimationEnd(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }

                });
                animator.start();
                break;
        }
    }
    /**
     * 根据开始和结束点获取移动路径
     * <p>
     * 让起点和终点落在一个圆上，取起点和终点所在一段圆弧作为路径！
     *
     * @return 移动路径
     */
    private Path getAnimMovePath(float x1, float y1, int x2, int y2) {
        Path path = new Path();

        // 起点和结束点中点
        float x0 = (x1 + x2) / 2f;
        float y0 = (y1 + y2) / 2f;
        // 圆半径，暂定为两点距离
        int r = (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        // 起点和结束点连线的垂线斜率
        float k = -(float) (x1 - x2) / (y1 - y2);

//       根据下边公式求圆心
//       cy = y0 + k * (cx - x0);
//       (cy - y0)^2 + (cx - x0)^2 + (r / 2)^2= r^2
        float cx0 = (float) (x0 + Math.sqrt(3) / 2 * r / Math.sqrt(k * k + 1)); // 第一个圆心X坐标
        float cx1 = (float) (x0 - Math.sqrt(3) / 2 * r / Math.sqrt(k * k + 1)); // 第二个圆心X坐标

        float cx = k < 0 ? cx1 : cx0;
        float cy = y0 + k * (cx - x0);

        float startAngle = (float) Math.toDegrees(Math.atan((y1 - cy) / (x1 - cx)));
        float toAngle = (float) Math.toDegrees(Math.atan((y2 - cy) / (x2 - cx)));

        if (k < 0) {
            startAngle += 360;
            toAngle += 360;

            if (toAngle > startAngle) {
                toAngle -= 180;
            }
        } else {
            startAngle += 180;
            toAngle += 180;
        }

        RectF rectF = new RectF(cx - r, cy - r, cx + r, cy + r);
        path.addArc(rectF, startAngle, toAngle - startAngle);
        return path;
    }
}
