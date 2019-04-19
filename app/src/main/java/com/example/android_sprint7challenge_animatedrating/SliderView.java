package com.example.android_sprint7challenge_animatedrating;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 指を追うように円動かす。
 * @author marunomaruno
 * @see Graphics04Activity
 */
public class SliderView extends View implements Animatable {

    private Paint paint, paint1;
    private float fX;    // 図形を描画する X 座標    // (1)
    private float fY;    // 図形を描画する Y 座標    // (2)
    private int iWidthCanvas ;
    private int iHeightCanvas;
    private int iStartingRating=0;
    private int iRate=iStartingRating;
    private int iSizeText=100;
    private int iMaxRating=10;
    private int iStartingPointX;
    private int iStartingPointY;
    private int iEndPointX;
    private int iEndPointY;
    private int iGapText=10;
    private String strEmpty="☆";
    private String strFilled="★";
    private int iColorSymbol=Color.BLACK;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  SliderView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  SliderView (Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public  SliderView (Context context) {
        super(context);
        initialize();
    }

    private void initialize() {
        // 画面のサイズを取得する
        WindowManager manager = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        iWidthCanvas = display.getWidth();
        iHeightCanvas = display.getHeight();

        // ペイントオブジェクトを設定する
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);    // (4)
        paint.setStyle(Style.FILL);    // (5)

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceType")
    private void initialize(AttributeSet attrs) {
        Context context=getContext();
        // 画面のサイズを取得する
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        iWidthCanvas = display.getWidth();
        iHeightCanvas = display.getHeight();

        if(attrs!=null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.SliderlView);

            iStartingRating=typedArray.getInteger(R.styleable.SliderlView_iStartingRating,0);
            iSizeText=typedArray.getInteger(R.styleable.SliderlView_iSizeText,100);
            iMaxRating=typedArray.getInteger(R.styleable.SliderlView_iMaxRating,10);
            iGapText=typedArray.getInteger(R.styleable.SliderlView_iGapText,10);
//            strEmpty=typedArray.getString(R.styleable.SliderlView_strFilled,"☆");
         //   strFilled=typedArray.getString(R.styleable.SliderlView_strFilled,"★");
            // ペイントオブジェクトを設定する
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);    // (4)
            paint.setStyle(Style.FILL);    // (5)
            typedArray.recycle();

        }else{

            // ペイントオブジェクトを設定する
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);    // (4)
            paint.setStyle(Style.FILL);    // (5)

        }



    }


    public void setRating(int iRating){
        iRate=iRating;
        invalidate();
    }
    public int getRating(){
        return iRate;

    }
    public String getStringRating(){
        return Integer.toString(iRate);

    }

    public void setMaxRating(int iMaxRating){
        this.iMaxRating=iMaxRating;
    }

    public void setStartingRating(int iRate){
        this.iStartingRating=iRate;
    }

    public void setStrFilled(String strFilled){
        this.strFilled=strFilled;
    }

    public void setStrEmpty(String strEmpty){
        this.strEmpty=strEmpty;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        // 格子を描画する
        drawGrid(canvas, 50);

        paint.setTextSize(iSizeText);
        int iStart=10, iEnd=iWidthCanvas-10,iPitch=(iEnd-iStart)/iMaxRating,iY=400;

        iY=200;
        for(int i=0;i<=iMaxRating;i++){
            if(i<iRate){
                canvas.drawText(strFilled,iStart+i*iPitch,iY,paint);
            }else{
                canvas.drawText(strEmpty,iStart+i*iPitch,iY,paint);
            }
        }
        canvas.drawText("Rating="+Double.toString(getScore((int)fX,90,1000)),100,130+iSizeText*4,paint);
        iY=400;
        for(int i=0;i<iMaxRating;i++){
            if(i<=getScore((int)fX,iStart,iEnd)){
                canvas.drawText(strFilled,iStart+i*iPitch,iY,paint);
            }else{
                canvas.drawText(strEmpty,iStart+i*iPitch,iY,paint);
            }
        }

        iY=600;
        Drawable d;

        for(int i=0;i<=iMaxRating;i++){
            if(i<getScore((int)fX,iStart,iEnd)){
                d= ContextCompat.getDrawable(getContext(), R.drawable.vector_star);
                paint.setColor(Color.BLACK);

            }else{
                d= ContextCompat.getDrawable(getContext(), R.drawable.ic_launcher_foreground);

                paint.setColor(Color.GREEN);

            }
            d.setBounds(iStart+i*iPitch,iY,iStart+i*iPitch+100,iY+100);
            d.draw(canvas);
            invalidate();
        }
    }

    public int getPercent(int iLocation, int iLeftLimit, int iRightLimit) {
        int iResult = 100*iLocation/(iRightLimit-iLeftLimit);
        return iResult;
    }

    public int getScore(int iLocation, int iLeftLimit, int iRightLimit) {
        int iResult = 100*iLocation/(iRightLimit-iLeftLimit);
        return (int)(iResult/iMaxRating);
    }

    public String getValues(){
        return Float.toString(fX)+","+Float.toString(fY);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {    // (7)
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:    // 指をタッチした    // (8)
                assert true;    // 何もしない
                break;

            case MotionEvent.ACTION_MOVE:    // 指を動かしている    // (9)


                fX=event.getX();
                fY=event.getY();


                invalidate();
                break;

            case MotionEvent.ACTION_UP:        // 指を離した    // (12)
                assert true;    // 何もしない
                break;

            default:
                assert true;    // 何もしない
                break;
        }


        invalidate();    // (13)

        return true;    // (14)
    }
    /**
     * 画面に格子を描画する。
     * @param canvas
     * @param interval 格子を描く間隔
     */
    private void drawGrid(final Canvas canvas, int interval) {



        // 格子を描画する
        Paint paint = new Paint();        // (15)
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        for (int i = 0; i < Math.max(iWidthCanvas, iHeightCanvas); i += interval) {
            canvas.drawText(Integer.toString(i), i, paint.getTextSize(), paint);
            canvas.drawLine(i, 0, i, iHeightCanvas, paint);
            canvas.drawText(Integer.toString(i), 0, i, paint);
            canvas.drawLine(0, i, iWidthCanvas, i, paint);
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
