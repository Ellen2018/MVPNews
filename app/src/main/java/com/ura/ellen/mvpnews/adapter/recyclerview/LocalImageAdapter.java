package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.BitMapUtil;
import com.ura.ellen.mvpnews.utils.FileUtil;
import com.ura.ellen.mvpnews.utils.TimeUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.io.File;
import java.util.List;

public class LocalImageAdapter extends RecyclerView.Adapter<LocalImageAdapter.ViewHolder>{

    private Context context;
    private List<LocalRes> localRess;

     public LocalImageAdapter(Context context, List<LocalRes> localRes){

        this.context = context;
        this.localRess = localRes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_local_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


         LocalRes localRes = localRess.get(position);



        //加载视频的第一针
        Glide.with(context).
                load(localRes.getPath())
                .placeholder(R.drawable.video_default_icon)
                .error(R.drawable.video_default_icon)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return localRess.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


       private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
           initView(itemView);
        }

        private void initView(View view) {

            imageView = view.findViewById(R.id.iv_listview_local_image);

        }
    }

}
