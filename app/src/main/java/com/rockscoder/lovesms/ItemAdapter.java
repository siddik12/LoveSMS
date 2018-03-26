package com.rockscoder.lovesms;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Siddiqur on 3/8/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MessageViewHolder> {

    private List<Item> itemList;

    ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.massage, parent, false));
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.desc.setText(item.getMessageText());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        ImageView likeImageView;
        ImageView shareImg;

        MessageViewHolder(View itemView) {
            super(itemView);
            this.desc = itemView.findViewById(R.id.statusTextView);
            this.shareImg = itemView.findViewById(R.id.shareImageView);
            this.likeImageView = itemView.findViewById(R.id.likeImageView);
        }
    }
}
