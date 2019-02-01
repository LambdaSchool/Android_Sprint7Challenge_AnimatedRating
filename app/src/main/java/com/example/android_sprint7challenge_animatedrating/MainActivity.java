package com.example.android_sprint7challenge_animatedrating;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  //  RatingBar ratingBar;
  //  Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     /**   ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button = (Button) findViewById(R.id.button);

    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Toast.makeText(MainActivity.this, "Stars: " + (int)rating, Toast.LENGTH_SHORT).show();
        }
    });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Start:" +(int)ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
                

    }**/

        /**
         * Rect rectangle1 = new Rect ();
         * rectangle1.top = 50;
         * rectangle1.bottom = 250;
         * rectangle1.left= 25;
         * rectangle1.right = 325;
         *
         * Paint paint1 = new Paint (Paint.ANTI_ALIAS_FLAG);
         * paint1.setColor(Color.BLUE);
         *
         * canvas.drawRect(rectangle1,paint1);
         *
         *
         *
         *   float width = getWidth() / 2f;
         *         float height = getHeight() / 2f;
         *
         *         canvas.rotate(circleRotation, width, height);
         *
         *         int radius = 100;
         *         if(width < height){
         *             radius = (int)(width) - EDGE_OFFSET;
         *         }else if (height < width){
         *             radius = (int)(height) - EDGE_OFFSET;
         *         }
         *
         *       int innerCircleRadius = (int) (radius * .92f);
         *         int smallInnerCircleRadius = (int) (radius * .08f);
         *
         *         canvas.drawCircle(width, height, radius, paintOuterCircle);
         *         canvas.drawCircle(width, height, innerCircleRadius, paintInnerCircle);
         *         canvas.drawCircle(
         *                 width - (innerCircleRadius - (smallInnerCircleRadius * 2) - 80),
         *                 height + (innerCircleRadius * .5f ),
         *                 smallInnerCircleRadius,
         *                 paintKnob);
         *
         *
         *
         *     }
         *     @Override
         *     public boolean onTouchEvent(MotionEvent event) {
         *         switch (event.getAction()) {
         *             case MotionEvent.ACTION_DOWN:
         *                 circleStartPoint = (int) event.getX();
         *                 Log.d(TAG, "Action was DOWN");
         *
         *                 break;
         *             case MotionEvent.ACTION_MOVE:
         *                 circleEndPoint = (int) event.getX();
         *
         *
         *                 distanceTraveled = (circleEndPoint - circleStartPoint) / SLOW_ROTATION_FACTOR;
         *                 circleRotation = circleRotation + (distanceTraveled);
         *                 if(circleRotation < minRotation){
         *                     circleRotation = minRotation;
         *                 }
         *                 if(circleRotation > maxRotation){
         *                     circleRotation = maxRotation;
         *                 }
         *                 setCurrentVolume((int) (circleRotation / CONVERT_DEGREE_TO_INT_FACTOR));
         *                 invalidate();
         *
         *                 break;
         *             case MotionEvent.ACTION_UP:
         *                 Toast.makeText(getContext(), "Volume " + currentVolume + "%", Toast.LENGTH_SHORT).show();
         *                 Log.d(TAG, "Action was UP");
         *                 break;
         *         }
         *         return true;
         *     }
         *
         *
         *     protected void init(AttributeSet attrs){
         *         paintOuterCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
         *         paintOuterCircle.setStyle(Paint.Style.FILL);
         *
         *         paintInnerCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
         *         paintInnerCircle.setStyle(Paint.Style.STROKE);
         *         paintInnerCircle.setStrokeWidth(15);
         *
         *         paintKnob = new Paint(Paint.ANTI_ALIAS_FLAG);
         *         paintKnob.setStyle(Paint.Style.FILL);
         *         paintInnerCircle.setColor(Color.BLUE);
         *         paintKnob.setColor(Color.GREEN);
         *         paintOuterCircle.setColor(Color.YELLOW);
         *
         *
         *     }
         *
         ***/



                CustomView customView = findViewById(R.id.custom_view);
                customView.setMaxRating(8);
                customView.setStartingRating(1);
            }
        }


