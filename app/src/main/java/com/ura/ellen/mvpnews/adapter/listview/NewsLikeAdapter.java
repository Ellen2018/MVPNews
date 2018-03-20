package com.ura.ellen.mvpnews.adapter.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.ActivityUtils.IntentActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsLikeAdapter extends BaseAdapter {


    private Context context;
    private Activity activity;
    private List<String[]> strings;

    public NewsLikeAdapter(Activity activity,Context context, List<String[]> strings) {
        this.context = context;
        this.strings = strings;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_news_like, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final String[] string = strings.get(i);
        viewHolder.tvListviewNewsTitle.setText(string[0]);
        viewHolder.tvListviewNewsTime.setText(string[1]);

        Glide.with(context)
                .load(string[2])
                .placeholder(R.drawable.news_moren)
                .error(R.drawable.news_moren)
                .into(viewHolder.ivListviewNewsImage);

        viewHolder.llListviewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentActivityUtils.jumpToLookNewsActivity(activity,context,string[0],string[1],string[2],string[3]);
            }
        });

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_listview_news_title)
        TextView tvListviewNewsTitle;
        @BindView(R.id.tv_listview_news_time)
        TextView tvListviewNewsTime;
        @BindView(R.id.iv_listview_news_image)
        ImageView ivListviewNewsImage;
        @BindView(R.id.ll_listview_news)
        LinearLayout llListviewNews;
        @BindView(R.id.tv_listview_news_fengexian)
        TextView tvListviewNewsFengexian;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
