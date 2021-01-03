package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

public class  ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    public  interface ListItemClickListener
    {
        void onListItemClick(String s);
    }
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView weatherTextView;
        public ForecastAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherTextView= itemView.findViewById(R.id.tv_weather_data);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int p=getAdapterPosition();
            String w=weatherdata[p];
            clickListener.onListItemClick(w);
        }
    }
    final private ListItemClickListener clickListener;
    private String[] weatherdata;
    public ForecastAdapter(ListItemClickListener l)
    {
        clickListener=l;
    }

    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        int layout_id=R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(layout_id,viewGroup,false);
        ForecastAdapterViewHolder viewHolder= new ForecastAdapterViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder viewHolder, int i) {
        String data=weatherdata[i];
        viewHolder.weatherTextView.setText(data);
    }

    @Override
    public int getItemCount() {
        if(weatherdata==null) return 0;
        else return weatherdata.length;
    }

    public void setWeatherdata(String[] s)
    {
        weatherdata=s;
        notifyDataSetChanged();
    }

}
