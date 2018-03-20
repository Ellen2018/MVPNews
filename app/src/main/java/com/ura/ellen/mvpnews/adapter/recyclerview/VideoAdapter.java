package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {


    private List<TrailersBean> trailersBeans;
    private Context context;

    public VideoAdapter(Context context,List<TrailersBean> trailersBeans){
        this.context = context;
        this.trailersBeans = trailersBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_video2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.jzVideoPlayerStandard.setUp(trailersBeans.get(position).getHightUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, trailersBeans.get(position).getMovieName());



        holder.jzVideoPlayerStandard.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);


        //加载图片：Glide框架
        Picasso.with(context)
                .load(trailersBeans.get(position).getCoverImg())
                .placeholder(R.drawable.news_moren)
                .error(R.drawable.news_moren)
                .into(  holder.jzVideoPlayerStandard.thumbImageView);


    }

    @Override
    public int getItemCount() {
        return trailersBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.jzplayer_listview_video_item)
        JZVideoPlayerStandard jzVideoPlayerStandard;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void stop(){

        JZVideoPlayer.releaseAllVideos();

    }


}
