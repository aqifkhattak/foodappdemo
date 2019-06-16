package com.example.aqifkhattak.googlemap;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class customAdpter extends RecyclerView.Adapter<customAdpter.MyViewHolder> {
    List<model> my_list;
    Context context;
    public customAdpter(List<model> my_list, Context context)
    {
        this.my_list = my_list;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycleviewlayout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final model model = my_list.get(i);
        myViewHolder.name.setText(model.getPlayer_name());
        myViewHolder.role.setText(model.getPlayer_role());
        myViewHolder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));
       myViewHolder . order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new
                        Intent(view.getContext(),conformOrder.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView name,role;
        RelativeLayout relative;
        Button order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            role = itemView.findViewById(R.id.role);
            relative = itemView.findViewById(R.id.relative);
            order = itemView.findViewById(R.id.order);




        }
    }
}
