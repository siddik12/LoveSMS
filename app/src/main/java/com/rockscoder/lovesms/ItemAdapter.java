package com.rockscoder.lovesms;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by Siddiqur on 3/8/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MessageViewHolder> {

    private List<ListItem> listItemList;


    ItemAdapter(List<ListItem> listItemList) {
        this.listItemList = listItemList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.massage, parent, false));
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        ListItem listItem = listItemList.get(position);
        holder.desc.setText(listItem.getMessageText());
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        ImageView copyImageView,shareImg;

        MessageViewHolder(View itemView) {
            super(itemView);
            this.desc = itemView.findViewById(R.id.statusTextView);
            this.shareImg = itemView.findViewById(R.id.shareImageView);
            this.copyImageView = itemView.findViewById(R.id.copyImageView);

            this.shareImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String position = (String) MessageViewHolder.this.desc.getText();
                    Intent share = new Intent("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", position);
                    view.getContext().startActivity(Intent.createChooser(share, view.getContext().getString(R.string.share_this)));
                }
            });

            this.copyImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) view.getContext().getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText(view.getContext().getString(R.string.copy_this),MessageViewHolder.this.desc.getText());
                    if (clipboard != null) {
                        clipboard.setPrimaryClip(clipData);
                        Toast.makeText(view.getContext(), view.getContext().getString(R.string.copy_done), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}
