package co.rahala.fibonnacci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import co.rahala.fibonnacci.events.FabResultEvent;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        int number = 10;
        Intent calcIntent = new Intent(this, CalculationIntentService.class);
        calcIntent. putExtra(Util.FAB_NUMBER_EXTRA, number);
        startService(calcIntent);
        Log.d(TAG, "calling service");


    }

    public void onEventMainThread(FabResultEvent event){
        Log.d(TAG, event.getLongs().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        EventBus.getDefault().unregister(this);
    }


}
