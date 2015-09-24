package com.example.atul.swipefling;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {


    private GestureDetectorCompat gestureDetector;
    Button button1;
    Button button2;
    TextView textView1;
    Button button3;
    Button button4;
    Button rightTopButton;
    Button rightBotButton;
    Button leftTopButton;
    Button leftBotButton;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    ViewGroup mainLayout;

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("ATUL", "In Fling");
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeRight();
                    }
                }
                result = true;
            }
            result = true;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mainLayout=(ViewGroup)findViewById(R.id.mainlayout);

        button1 = (Button)findViewById(R.id.column_1);
        button2 = (Button)findViewById(R.id.column_2);
        button4 = (Button)findViewById(R.id.column_4);
        button3 = (Button)findViewById(R.id.column_3);
        textView1 = (TextView)findViewById(R.id.textView1);

        rightBotButton = button4;
        rightTopButton =button2;
        leftTopButton = button1;
        leftBotButton =button3;
                Log.i("ATUL", "activity start");
        this.gestureDetector =new GestureDetectorCompat(this,this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onSwipeRight() {


        this.textView1.setText("Swiped Right");

        RelativeLayout.LayoutParams buttonMoveRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonMoveRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        leftTopButton.setLayoutParams(buttonMoveRight);
        TransitionManager.beginDelayedTransition(mainLayout);


        RelativeLayout.LayoutParams buttonMoveUp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonMoveUp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        rightTopButton.setLayoutParams(buttonMoveUp);
        TransitionManager.beginDelayedTransition(mainLayout);


        RelativeLayout.LayoutParams botButtonMoveLeft = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        botButtonMoveLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        botButtonMoveLeft.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rightBotButton.setLayoutParams(botButtonMoveLeft);
        TransitionManager.beginDelayedTransition(mainLayout);


        RelativeLayout.LayoutParams botButtonMoveRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        botButtonMoveRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        botButtonMoveRight.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        leftBotButton.setLayoutParams(botButtonMoveRight);
        TransitionManager.beginDelayedTransition(mainLayout);

        Button tmp = rightBotButton;
        rightBotButton = leftBotButton;
        leftBotButton = tmp;

        Button tmp1 = rightTopButton;
        rightTopButton = leftTopButton;
        leftTopButton = tmp1;


    }

    public void onSwipeLeft() {
        this.textView1.setText("Swiped Left");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
