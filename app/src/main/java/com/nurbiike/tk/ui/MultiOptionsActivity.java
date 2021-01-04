package com.nurbiike.tk.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.nurbiike.tk.R;

import static com.nurbiike.tk.ui.UtilMethods.setWindowStatus;
import static com.nurbiike.tk.ui.UtilMethods.setWindowStatusHidden;

public class MultiOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the status bar, set status bar color to black opaque
        setWindowStatus(getWindow());
        setWindowStatusHidden(getWindow());

        setContentView(R.layout.activity_multi_options);
    }

    public void handleOption(View view) {
        Button btn = (Button) view;
        String type = btn.getTag().toString();

        if (type.equals(getString(R.string.intent_val_type_multi_int_rand))) {
            Intent gamePlayIntent = new Intent(this, GamePlayActivity.class);
            gamePlayIntent.putExtra(getString(R.string.intent_key_mode), getString(R.string.intent_val_mode_multi));
            gamePlayIntent.putExtra(getString(R.string.intent_key_type), type);
            startActivity(gamePlayIntent);
        } else if (type.equals(getString(R.string.intent_val_type_multi_int_spec))) {
            startActivity(new Intent(this, MultiIntSpecOptionsActivity.class));
        } else if (type.equals(getString(R.string.intent_val_type_multi_local))) {
            startActivity(new Intent(this, MultiLocalOptionsActivity.class));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();

        if (y < 20 && event.getAction() == MotionEvent.ACTION_DOWN) {
            setWindowStatus(getWindow());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            setWindowStatusHidden(getWindow());
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}