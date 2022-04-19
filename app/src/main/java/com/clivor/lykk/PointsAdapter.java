package com.clivor.lykk;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PointsAdapter extends  RecyclerView.Adapter<PointsAdapter.PointsHolder>{

    Context context;
    ArrayList<Points> arrayList;

    public PointsAdapter(Context context, ArrayList<Points> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public PointsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listpoints, parent, false);

        return new PointsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointsHolder holder, int position) {

        Log.d("weq","oooo");
        Points points = arrayList.get(position);
        String name = points.getName();
        String point = points.getPoints();
        Log.d("weq",name);
        holder.textViewNamee.setText(name);
        holder.textViewPointss.setText(point);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PointsHolder extends RecyclerView.ViewHolder{

        TextView textViewNamee,textViewPointss;
        public PointsHolder(@NonNull View itemView) {
            super(itemView);
            textViewNamee = itemView.findViewById(R.id.textViewNamee);
            textViewPointss = itemView.findViewById(R.id.textViewPointss);
            Log.d("weq","oooo");
        }
    }
}
