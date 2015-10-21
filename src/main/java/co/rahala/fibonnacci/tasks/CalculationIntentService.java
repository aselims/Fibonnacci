package co.rahala.fibonnacci.tasks;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import co.rahala.fibonnacci.Util;
import co.rahala.fibonnacci.events.FabResultEvent;
import de.greenrobot.event.EventBus;

/**
 * Created by aselims on 21/10/15.
 */
public class CalculationIntentService extends IntentService {

    private final String TAG = CalculationIntentService.class.getSimpleName();

    public CalculationIntentService() {
        super("myService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        ArrayList<Long> longs;
        int n = intent.getIntExtra(Util.FAB_NUMBER_EXTRA, 0);
        longs = Util.fibLimit(n);
        Log.d(TAG, longs.toString());

        EventBus.getDefault().post(new FabResultEvent(longs));

    }
}
