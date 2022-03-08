package com.example.bilmeetimagemap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.bilmeetimagemap.R.drawable;
import com.example.bilmeetimagemap.ui.home.HomeFragment;

import java.util.ArrayList;


public class PinView extends SubsamplingScaleImageView{

    private final Paint paint = new Paint();
    private final PointF vPin = new PointF();
    private PointF sPin;
    private Bitmap pin;
    private Bitmap pin2;

    ArrayList<Bitmap> bitList = new ArrayList<Bitmap>();
    ArrayList<PointF> pinList = new ArrayList<PointF>();


    public PinView(Context context) {
        this(context, null);
    }

    public Bitmap getPin(int i)
    {
        return bitList.get(i);
    }


    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();

    }

    public void setPin(PointF sPin) {
        this.sPin = sPin;
        initialise();
        invalidate();
    }

    public void addPin(PointF sPin) {
        pinList.add(sPin);

        for (int i = 0; i < pinList.size(); i++) {
            this.sPin = pinList.get(i);
            initialise();
            invalidate();
        }
    }

    private float w(int i){
        float density = getResources().getDisplayMetrics().densityDpi;
        pin2 = getPin(i);
        pin2 = BitmapFactory.decodeResource(this.getResources(), drawable.pushpin_blue);
        float w = (density / 2200f) * pin2.getWidth();
        return w;
    }
    private float h(int i){
        pin2 = getPin(i);
        float density = getResources().getDisplayMetrics().densityDpi;
        pin2 = BitmapFactory.decodeResource(this.getResources(), drawable.pushpin_blue);
        float h = (density / 2200f) * pin2.getHeight();
        return h;
    }
    private float x(int i){
        pin2 = getPin(i);
        float vX = vPin.x - (getPin(i).getWidth() / 2);
        return vX;
    }
    private float y(int i){
        pin2 = getPin(i);
        float vY = vPin.y - getPin(i).getHeight();
        return vY;
    }

    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), drawable.pushpin_blue);
        float w = (density / 2200f) * pin.getWidth();
        float h = (density / 2200f) * pin.getHeight();
        pin = Bitmap.createScaledBitmap(pin, (int) w, (int) h, true);
        bitList.add(pin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }

        paint.setAntiAlias(true);

        for (int i = 0; i < pinList.size(); i++) {
            if (pinList.get(i) != null && pin != null) {
                sourceToViewCoord(pinList.get(i), vPin);
                float vX = vPin.x - (pin.getWidth() / 2);
                float vY = vPin.y - pin.getHeight();
                canvas.drawBitmap(pin, vX, vY, paint);
            }

        }
    }
}