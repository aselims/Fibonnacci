package co.rahala.fibonnacci.tasks;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;

import co.rahala.fibonnacci.Util;
import de.greenrobot.event.EventBus;

/**
 * Created by aselims on 21/10/15.
 */
public class CalculationIntentService extends IntentService {
    public CalculationIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        ArrayList<Long> longs = new ArrayList<>();
        int n = intent.getIntExtra(Util.FAB_NUMBER_EXTRA, 0);
        longs = Util.fibLimit(n);

    }
}
