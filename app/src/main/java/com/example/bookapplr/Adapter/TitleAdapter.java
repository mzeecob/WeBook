package com.example.bookapplr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookapplr.R;
import com.example.bookapplr.Interface.TitleClickListener;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {

    private Context mcontex;
    private ArrayList<String> titleList;
    private TitleClickListener clickListener;

    public TitleAdapter(Context mcontex, ArrayList<String> titleList, TitleClickListener clickListener) {
        this.mcontex = mcontex;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public TitleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontex).inflate(R.layout.title_layout, null, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, myViewHolder.getPosition());
            }
        });


        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.MyViewHolder holder, int position) {

        holder.title.setText(titleList.get(position).replace("_", ""));

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
