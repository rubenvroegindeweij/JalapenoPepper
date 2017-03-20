package com.pepper.jalapeno.jalapenopepper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/

import android.app.Activity;
import android.util.Log;

import com.aldebaran.qi.QiCallback;
import com.aldebaran.qi.sdk.Qi;
import com.aldebaran.qi.sdk.object.interaction.Say;

public class MainActivity extends Activity {

    private static final String TAG = "SayActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Say say = new Say(this);
        say.run("Hello, world!").then(Qi.onUiThread(new QiCallback<Void>() {
            @Override
            public void onResult(Void ignore) {
                Log.d(TAG, "result on thread " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "error", error);
            }

            @Override
            public void onCancel() {
                Log.w(TAG, "cancel");
            }
        }));
    }
}