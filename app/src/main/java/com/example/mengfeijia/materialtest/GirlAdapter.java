package com.example.mengfeijia.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by mengfeijia on 2017/8/12.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {
    private Context mContext;
    private List<Girl> mGirlList;

    public GirlAdapter(List<Girl> girlList){
        mGirlList = girlList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.girl_item,parent,false);

        // 处理点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Girl girl = mGirlList.get(position);
                Intent intent = new Intent(mContext, GirlActivity.class);
                intent.putExtra(GirlActivity.GIRL_NAME,girl.getName());
                intent.putExtra(GirlActivity.GIRL_IMAGE_ID,girl.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Girl girl = mGirlList.get(position);
        holder.girlName.setText(girl.getName());
        Glide.with(mContext).load(girl.getImageId()).into(holder.girlImage);
    }

    @Override
    public int getItemCount() {
        return mGirlList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView girlImage;
        TextView girlName;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            girlImage = (ImageView) itemView.findViewById(R.id.girl_image);
            girlName = (TextView) itemView.findViewById(R.id.girl_name);
        }
    }
}
