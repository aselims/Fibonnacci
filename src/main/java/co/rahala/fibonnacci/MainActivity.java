package co.rahala.fibonnacci;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.rahala.fibonnacci.events.FabResultEvent;
import co.rahala.fibonnacci.recycler.RecyclerAdapter;
import co.rahala.fibonnacci.tasks.CalculationIntentService;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.listRV)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Bind(R.id.numberET)
    EditText numberET;

    @Bind(R.id.CalcBtn)
    Button calcBtn;

    private ArrayList<Long> numbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        numbersList = new ArrayList<>();
        mAdapter = new RecyclerAdapter(numbersList);
        mRecyclerView.setAdapter(mAdapter);


        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(numberET.getText())){
                    numberET.setError("Sorry!");
                }else {
                    int number = Integer.valueOf(numberET.getText().toString());
                    calculateFib(number);
                    numberET.clearFocus();

                    Util.hideKeyboard(MainActivity.this);
                }

            }
        });


    }



    private void calculateFib(int number) {
        Intent calcIntent = new Intent(this, CalculationIntentService.class);
        calcIntent. putExtra(Util.FAB_NUMBER_EXTRA, number);
        startService(calcIntent);
        Log.d(TAG, "calling service");
    }

    public void onEventMainThread(FabResultEvent event){
        Log.d(TAG, event.getLongs().toString());
        numbersList.clear();
        numbersList.addAll(event.getLongs());
        mAdapter.notifyDataSetChanged();
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
