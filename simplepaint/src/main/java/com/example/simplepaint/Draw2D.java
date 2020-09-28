package com.example.simplepaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {
    private Paint paint = new Paint();
    private Rect rect = new Rect();

    public Draw2D(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // blue rectangle
        paint.setColor(Color.BLUE);
        canvas.drawRect(20, 20, 1000, 500, paint);

        // yellow circle
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(950, 30, 50, paint);

        // green rectangle
        paint.setColor(Color.GREEN);
        canvas.drawRect(20, 500, 1000, 700, paint);

        int x = 810;
        int y = 190;

        paint.setColor(Color.GRAY);
        paint.setTextSize(27);
        String str2rotate = "Лучик солнца!";

        canvas.rotate(-45, x + rect.exactCenterX(), y + rect.exactCenterY());

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, paint);
    }
}
