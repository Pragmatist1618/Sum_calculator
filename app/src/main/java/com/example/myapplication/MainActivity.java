package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView res;
    private TextView value1;
    private TextView value2;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.sample_text);
        value1 = findViewById(R.id.val1);
        value2 = findViewById(R.id.val2);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(int val1, int val2);

    public void onClick_caclulate(View view) {
        int val1 = Integer.parseInt(value1.getText().toString());
        int val2 = Integer.parseInt(value2.getText().toString());
        res.setText(stringFromJNI(val1, val2));
    }
}
