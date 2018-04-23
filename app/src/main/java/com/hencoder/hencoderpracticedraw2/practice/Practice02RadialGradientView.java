package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02RadialGradientView extends View implements View.OnClickListener {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Shader shader;
    private int  type= 0;
    public Practice02RadialGradientView(Context context) {
        this(context,null);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (type){
            case 0:
                shader=new RadialGradient(300,300,100,
                        Color.parseColor("#E91E63"),Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
                break;
            case 1:
                shader=new RadialGradient(300,300,100,
                        Color.parseColor("#E91E63"),Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
                break;
            default:
                shader=new RadialGradient(300,300,100,
                        Color.parseColor("#E91E63"),Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
                break;
        }

        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    @Override
    public void onClick(View v) {
        type++;
        if(type>2){
            type=0;
        }
        invalidate();
    }
}
