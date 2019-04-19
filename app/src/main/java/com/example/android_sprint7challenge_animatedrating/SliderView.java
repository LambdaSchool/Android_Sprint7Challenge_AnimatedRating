package com.example.android_sprint7challenge_animatedrating;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;


/**
 * 指を追うように円動かす。
 * @author marunomaruno
 * @see Graphics04Activity
 */
public class SliderView extends View {

    private Paint paint, paint1;
    private float fX;    // 図形を描画する X 座標    // (1)
    private float fY;    // 図形を描画する Y 座標    // (2)
    private double dTheta;
    private double dRotation=-60; //Degree of Dial starting point from horizontal line
    int iCenterX=500;
    int iCenterY=500;
    int iDialRadius;
    int iDotMovingRadius;// Radius of Dial
    int iDotRaidus=50;// Radius of a dot
    int iWidthCanvas ;
    int iHeightCanvas;
    int iStartingRating=0;
    int iRate=iStartingRating;
    Context context;
    int iMaxRating=10;

    String strEmpty="☆";
    String strFilled="★";

    public  SliderView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    public  SliderView (Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
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

        iCenterX=iWidthCanvas/2;
        iCenterY=iHeightCanvas/2;
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);    // (4)
        paint1.setStyle(Style.FILL);    // (5)


        // ペイントオブジェクトを設定する
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);    // (4)
        paint.setStyle(Style.FILL);    // (5)

        // 丸を描画する初期値を設定する
        fX = iCenterX;
        fY = iCenterY-iDotMovingRadius;


    }
    @SuppressLint("ResourceType")
    private void initialize(AttributeSet attrs) {
        Context context=getContext();
        // 画面のサイズを取得する
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        iWidthCanvas = display.getWidth();
        iHeightCanvas = display.getHeight();
        iCenterX=iWidthCanvas/2;
        iCenterY=iHeightCanvas/2;

        if(attrs!=null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.SliderlView);
            paint1 = new Paint();
            paint1.setAntiAlias(true);
       //     paint1.setColor(typedArray.getColor(R.styleable.SliderlView_dial_color,Color.DKGRAY));    // (4)
            paint1.setStyle(Style.FILL);
     //       iDotMovingRadius=typedArray.getInt(R.styleable.SliderlView_dial_color,400);

            // ペイントオブジェクトを設定する
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);    // (4)
            paint.setStyle(Style.FILL);    // (5)

            // 丸を描画する初期値を設定する
            fX = iCenterX;
            fY = iCenterY-iDotMovingRadius;

        }else{
            paint1 = new Paint();
            paint1.setAntiAlias(true);
            paint1.setColor(Color.BLACK);    // (4)
            paint1.setStyle(Style.FILL);    // (5)


            // ペイントオブジェクトを設定する
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);    // (4)
            paint.setStyle(Style.FILL);    // (5)

            // 丸を描画する初期値を設定する
            fX = iCenterX;
            fY = iCenterY-iDotMovingRadius;

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
    @Override
    protected void onDraw(Canvas canvas) {
        // 格子を描画する
        drawGrid(canvas, 50);
  //      canvas.drawCircle(iCenterX, iCenterY, iDialRadius, paint1);
        // 円を描画する
   //     canvas.drawCircle(fX, fY, iDotRaidus, paint);    // (6)
        int iSizeText=50;
        paint1.setTextSize(iSizeText);
  //      canvas.drawText("x="+Float.toString(fX),100,100,paint1);
   //     canvas.drawText("y="+Float.toString(fY),100,110+iSizeText,paint1);
       canvas.drawText("rate="+Double.toString(getScore((int)fX,90,1000)),100,130+iSizeText*3,paint1);
        paint1.setTextSize(100);
        int iStart=10, iEnd=iWidthCanvas-10,iPitch=(iEnd-iStart)/iMaxRating,iY=400;
        for(int i=0;i<=iMaxRating;i++){
            if(i<=getScore((int)fX,iStart,iEnd)){
                canvas.drawText(strFilled,iStart+i*iPitch,iY,paint1);
            }else{
                canvas.drawText(strEmpty,iStart+i*iPitch,iY,paint1);
            }

        }

        iY=200;
        for(int i=0;i<=iMaxRating;i++){
            if(i<=iRate){
                canvas.drawText(strFilled,iStart+i*iPitch,iY,paint1);
            }else{
                canvas.drawText(strEmpty,iStart+i*iPitch,iY,paint1);
            }

        }


    }

    public double getTheta(double dCos,double dSin,double dRotation){
        dRotation=-Math.PI*dRotation/180;

        double dCosRotation=Math.cos(dRotation)
                ,dSinRotation=Math.sin(dRotation),

                dCosNew=dCosRotation*dCos-dSin*dSinRotation,
                dSinNew=dSinRotation*dCos+dCosRotation*dSin;
        double dThetac=Math.acos(dCosNew);
        double dThetas=Math.asin(dSinNew);
        if(dCosNew>=0){
            if(dSinNew>=0){
                dTheta=dThetac;
            }else{
                dTheta=2*Math.PI-dThetac;

            }

        }else{
            if(dSinNew>=0){
                dTheta=dThetac;
            }else{
                dTheta=2*Math.PI-dThetac;
            }
        }
        return dTheta;
    }



    public double getDegree(){

        return Math.toDegrees(dTheta);
    }
    public int getPercent(int iLocation, int iLeftLimit, int iRightLimit) {
        int iResult = 100*iLocation/(iRightLimit-iLeftLimit);
        return iResult;
    }

    public int getScore(int iLocation, int iLeftLimit, int iRightLimit) {
        int iResult = 100*iLocation/(iRightLimit-iLeftLimit);
        return (int)(iResult/10);
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
}
