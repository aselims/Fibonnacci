package co.rahala.fibonnacci.recycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import co.rahala.fibonnacci.R;

/**
 * Created by aselims on 21/10/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataViewHolder> {

    private ArrayList<Long> arrayList;

    public RecyclerAdapter(ArrayList<Long> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_number, parent, false);

        DataViewHolder dataViewHolder = new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        holder.numberTV.setText(arrayList.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{

        private TextView numberTV;

        public DataViewHolder(View itemView) {
            super(itemView);
            numberTV = (TextView) itemView.findViewById(R.id.numberTV);
        }
    }
}
