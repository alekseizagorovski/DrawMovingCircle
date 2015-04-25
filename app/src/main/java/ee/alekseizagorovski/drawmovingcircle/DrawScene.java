package ee.alekseizagorovski.drawmovingcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class DrawScene extends View {


    private Paint canvasPaint;
    private Paint circlePaint;

    private static int x;
    private static int y;

    private int dx = 5;
    private int dy = 5;

    private Handler h;
    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public DrawScene(Context context, int startX, int startY) {
        super(context);
        x=startX;
        y=startY;

        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.GREEN);

        circlePaint = new Paint();
        circlePaint.setColor(Color.YELLOW);

        h = new Handler();
    }

    public int getCurrentX() {
        return x;
    }
    public int getCurrentY(){

        return y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        canvas.drawPaint(canvasPaint);
        int scene_width = this.getWidth();
        int scene_height = this.getHeight();

        int circleRadius = 50;
        canvas.drawCircle(x, y, circleRadius, circlePaint);

        x += dx;
        y += dy;

        if ((x > scene_width - circleRadius) || (x < circleRadius)) {
            dx = dx * -1;
        }

        if ((y > scene_height - circleRadius) || (y < circleRadius)) {
            dy = dy * -1;
        }

        int FRAME_RATE = 50;
        h.postDelayed(r, FRAME_RATE);


    }



}

