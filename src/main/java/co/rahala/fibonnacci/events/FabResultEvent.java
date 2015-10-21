package co.rahala.fibonnacci.events;

import java.util.ArrayList;

/**
 * Created by aselims on 21/10/15.
 */
public class FabResultEvent {
    private ArrayList<Long> longs;

    public FabResultEvent(ArrayList<Long> longs) {
        this.longs = longs;
    }

    public ArrayList<Long> getLongs() {
        return longs;
    }
}
