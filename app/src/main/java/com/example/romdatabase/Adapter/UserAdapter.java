package com.example.romdatabase.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.romdatabase.DatabaseClass;
import com.example.romdatabase.EntityClass.UserModel;
import com.example.romdatabase.R;
import com.example.romdatabase.UpdataData;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<UserModel> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public UserAdapter(Context context, List<UserModel> list,DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner=deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getNumber());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdataData.class);
                intent.putExtra("id",String.valueOf(list.get(position).getKey()));
                intent.putExtra("name",String.valueOf(list.get(position).getName()));
                intent.putExtra("number",String.valueOf(list.get(position).getNumber()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              deleteItemClicklistner.onItemDelete(position,list.get(position).getKey());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,number;
        Button update,delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name_text);
            number=itemView.findViewById(R.id.number_text);
            update=itemView.findViewById(R.id.btn_updateId);
            delete=itemView.findViewById(R.id.btn_deleteId);
        }
    }

    public interface DeleteItemClicklistner
    {
        void onItemDelete(int position, int id);
    }
}
