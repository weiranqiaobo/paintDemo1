package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap= null;
    public Practice04BitmapShaderView(Context context) {
        this(context,null);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawCircle(200, 200, 200, paint);
    }
}
