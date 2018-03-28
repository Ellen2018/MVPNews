package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class NewsZhiBoAdapter extends RecyclerView.Adapter<NewsZhiBoAdapter.ViewHolder> {


    private List<News.DataBean.ItemListBean> itemListBeans;
    private Context context;

    public NewsZhiBoAdapter(Context context, List<News.DataBean.ItemListBean> itemListBeans){
        this.context = context;
        this.itemListBeans = itemListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_news_zhibo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String imagePath = itemListBeans.get(position).getItemImage().getImgUrl1();

        if(imagePath!=null&&imagePath.length()>0) {
            //加载图片：Glide框架
            Picasso.with(context)
                    .load(imagePath)
                    .placeholder(R.drawable.news_moren)
                    .error(R.drawable.news_moren)
                    .into(holder.imageView);
        }


        holder.textView.setText(itemListBeans.get(position).getItemTitle());


    }

    @Override
    public int getItemCount() {
        return itemListBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_listview_news_zhibo)
        ImageView imageView;
        @BindView(R.id.tv_listview_news_zhibo)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
