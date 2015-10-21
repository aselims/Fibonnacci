package co.rahala.fibonnacci;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;

/**
 * Created by aselims on 21/10/15.
 */
public class Util {

    public static ArrayList<Long> fibArray = new ArrayList<Long>();

    public static String FAB_NUMBER_EXTRA = "fab_number";


    public static ArrayList<Long> fibLimit(int n) {

        fibArray.clear();

        if (n == 0) {
            fibArray.add(0l);
        } else if (n == 1) {
            fibArray.add(0l);
            fibArray.add(1l);
        } else if (n > 1) {
            fibArray.add(0l);
            fibArray.add(1l);
            fib(n);
        }

        ArrayList<Long> finalArray = new ArrayList<>();
        for (Long m : fibArray) {
            if (m < Long.MAX_VALUE) {
                finalArray.add(m);
            } else {
                return finalArray;
            }
        }
        return finalArray;
    }

    public static Long fib(int n) {

        if (n >= fibArray.size()) {
            fibArray.add(n, fib(n - 1) + (fib(n - 2)));
        }

       // Log.d("array", fibArray.toString() + "  " + fibArray.size());

        return fibArray.get(n);
    }

    //not used: other method not recursive
    double fibbonaci(int n) {
        double prev = 0d, next = 1d, result = 0d;
        for (int i = 1; i < n; i++) {
            result = prev + next;
            prev = next;
            next = result;
        }
        return result;
    }

    public static void hideKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }
        View focus = activity.getCurrentFocus();
        if (focus != null) {
            InputMethodManager inputMethodManager = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    focus.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN
            );
        }
    }


}
