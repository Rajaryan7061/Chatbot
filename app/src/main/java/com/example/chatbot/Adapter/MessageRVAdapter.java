package com.example.chatbot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatbot.Modal.MessageModel;
import com.example.chatbot.R;

import java.util.ArrayList;

public class MessageRVAdapter extends RecyclerView.Adapter {
    private ArrayList<MessageModel> messageModalArrayList;
    private Context context;
    public MessageRVAdapter(ArrayList<MessageModel> messageModalArrayList, Context context) {
        this.messageModalArrayList = messageModalArrayList;
        this.context = context;
    }
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View view;
    switch (viewType){
        case 0:
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg, parent, false);
            return new UserViewHolder(view);
        case 1:
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg,parent,false);
            return new BotViewHolder(view);
    }
    return  null;
}
public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
        MessageModel model = messageModalArrayList.get(position);
        switch (model.getSender()){
            case "user":
                ((UserViewHolder) holder).userTv.setText(model.getMessage());
                break;
            case "bot":
                (  ( BotViewHolder) holder).botTV.setText(model.getMessage());
                  break;
        }

}
public int getItemCount(){
        return messageModalArrayList.size();
}
public int getItemViewType(int position) {
    switch (messageModalArrayList.get(position).getSender()) {
        case "user":
            return 0;
        case "bot":
            return 1;
        default:
            return -1;
    }
}
public static  class UserViewHolder extends RecyclerView.ViewHolder{
        TextView userTv;
        public UserViewHolder(View itemView){
            super(itemView);
            userTv=itemView.findViewById(R.id.idTVUser);
        }
}
public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView botTV;

        public  BotViewHolder(View itemView){
            super(itemView);
            botTV=itemView.findViewById(R.id.idTVBot);
        }
}
}
