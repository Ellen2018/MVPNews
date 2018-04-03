package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.ActivityUtils.IntentActivityUtils;
import com.ura.ellen.mvpnews.utils.ColorUtils;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;
import com.ura.ellen.mvpnews.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    private List<News.DataBean.ItemListBean> lists;
    private Context context;
    private Activity activity;
    private List<News.DataBean.BigImgBean> bigImgBeans;

    public NewsAdapter(Activity activity,Context context, List<News.DataBean.ItemListBean> lists, List<News.DataBean.BigImgBean> bigImgBeans){
        this.context = context;
        this.lists = lists;
        this.bigImgBeans = bigImgBeans;
        this.activity = activity;

        //设置头布局
        setMyHeaderView();

    }

    private View mHeaderView;
    private ViewHolderHead viewHolderHead;

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }


    public void setMyHeaderView() {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_viewpager,null);

        mHeaderView = view;
        viewHolderHead = new ViewHolderHead(mHeaderView);
        viewHolderHead.setBannerBigItems(bigImgBeans);

        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void notifyHeadViewData(List<News.DataBean.BigImgBean> bigImgBeans){
        this.bigImgBeans = bigImgBeans;
        viewHolderHead.setBannerBigItems(this.bigImgBeans);
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_news, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;

        final int pos = getRealPosition(viewHolder);

        if(viewHolder instanceof Holder) {
            Holder viewHolder1 = (Holder) viewHolder;
            int p = position - 1;
            if(!lists.get(p).getDetailUrl().contains("specialList")) {
                //加载图片：Glide框架

                viewHolder1.rlSpc.setVisibility(View.GONE);
                viewHolder1.llListviewNews.setVisibility(View.VISIBLE);
                String imageUrl = lists.get(p).getItemImage().getImgUrl1();

                String url = lists.get(p).getItemImage().getImgUrl1();
                if(url.endsWith("gif")){
                    Glide.with(context)
                            .load(url)
                            .asGif()
                            .placeholder(R.drawable.news_moren)
                            .error(R.drawable.news_moren)
                            .into(viewHolder1.ivListviewNewsImage);
                }else {
                    Glide.with(context)
                            .load(url)
                            .placeholder(R.drawable.news_moren)
                            .error(R.drawable.news_moren)
                            .into(viewHolder1.ivListviewNewsImage);
                }


                viewHolder1.fenGeXain.setVisibility(View.VISIBLE);
                viewHolder1.tvListviewNewsTitle.setText(lists.get(p).getItemTitle());
                viewHolder1.time.setText(lists.get(p).getOperate_time());
                viewHolder1.llListviewNews.setOnClickListener(new MyOnClick(lists.get(p),viewHolder1));

            }else{
                viewHolder1.llListviewNews.setVisibility(View.GONE);
                viewHolder1.rlSpc.setVisibility(View.VISIBLE);

                viewHolder1.fenGeXain.setVisibility(View.VISIBLE);
                //加载图片：Glide框架
                Picasso.with(context)
                        .load(lists.get(p).getItemImage().getImgUrl1())
                        .placeholder(R.drawable.news_moren)
                        .error(R.drawable.news_moren)
                        .into(viewHolder1.ivSpc);



                viewHolder1.tvSpc.setText("专题:"+lists.get(p).getItemTitle());
                viewHolder1.rlSpc.setOnClickListener(new MyOnClick(lists.get(p),viewHolder1));
            }


            if(SharedPreferencesUtil.getData
                    (context,SharedPreferencesUtil.sharedPreference_appName,
                            SharedPreferencesUtil.sharedPreference_isYeHua,Boolean.class,false)){
                int color = Color.parseColor(ColorUtils.yeHuaColor);
                viewHolder1.tvListviewNewsTitle.setTextColor(color);
                viewHolder1.tvSpc.setTextColor(color);
                viewHolder1.time.setTextColor(color);
                viewHolder1.rlSpc.setBackgroundResource(R.drawable.touch_bg_yehua);
                viewHolder1.llListviewNews.setBackgroundResource(R.drawable.touch_bg_yehua);

                if(NewsSQLiteUtils.isUserLookThisNewsData(context,lists.get(p).getDetailUrl())){

                    int color1 = Color.parseColor(ColorUtils.isLook);
                    viewHolder1.tvListviewNewsTitle.setTextColor(color1);
                    viewHolder1.tvSpc.setTextColor(color1);
                    viewHolder1.time.setTextColor(color1);

                }

            }else{
                int color = Color.parseColor(ColorUtils.cancelYeHuaColor);
                viewHolder1.tvListviewNewsTitle.setTextColor(color);
                viewHolder1.tvSpc.setTextColor(color);
                viewHolder1.time.setTextColor(color);
                viewHolder1.rlSpc.setBackgroundResource(R.drawable.touch_bg);
                viewHolder1.llListviewNews.setBackgroundResource(R.drawable.touch_bg);

                if(NewsSQLiteUtils.isUserLookThisNewsData(context,lists.get(p).getDetailUrl())){

                    int color1 = Color.parseColor(ColorUtils.isLook);
                    viewHolder1.tvListviewNewsTitle.setTextColor(color1);
                    viewHolder1.tvSpc.setTextColor(color1);
                    viewHolder1.time.setTextColor(color1);

                }
            }



        }



    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? lists.size() : lists.size() + 1;
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView ivListviewNewsImage;
        TextView tvListviewNewsTitle;
        LinearLayout llListviewNews;
        TextView time;

        LinearLayout rlSpc;
        ImageView ivSpc;
        TextView tvSpc;

        TextView fenGeXain;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
           initView(itemView);
        }

        private void initView(View view) {

            ivListviewNewsImage = view.findViewById(R.id.iv_listview_news_image);
            tvListviewNewsTitle = view.findViewById(R.id.tv_listview_news_title);
            llListviewNews = view.findViewById(R.id.ll_listview_news);
            time = view.findViewById(R.id.tv_listview_news_time);

            rlSpc = view.findViewById(R.id.rl_listview_news_spc);
            ivSpc = view.findViewById(R.id.iv_listview_news_spc);
            tvSpc = view.findViewById(R.id.tv_listview_news_spc);



            fenGeXain = view.findViewById(R.id.tv_listview_news_fengexian);

        }
    }

    class ViewHolderHead{

        Banner banner;


        public void setBannerBigItems(List<News.DataBean.BigImgBean> bigImgBeanList){

            ArrayList<String> images = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();

            for(News.DataBean.BigImgBean bigImgBean:bigImgBeanList){
                images.add(bigImgBean.getItemImage());
                titles.add(bigImgBean.getItemTitle());
            }

            setBannerData(images,titles);

        }

        public void setBannerData(ArrayList<String> images,ArrayList<String> titles){


        banner.setVisibility(View.VISIBLE);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                if(path!=null&&path instanceof String&&((String) path).startsWith("http")) {
                    Picasso.with(context)
                            .load((String) path)
                            .placeholder(R.drawable.news_moren)
                            .error(R.drawable.news_moren)
                            .into(imageView);
                }
            }
        });
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.RotateDown);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                News.DataBean.BigImgBean bigImgBean = bigImgBeans.get(position);
                IntentActivityUtils.jumpToLookNewsActivity(activity,context,bigImgBean.getItemTitle(),
                        bigImgBean.getOperate_time(),bigImgBean.getItemImage(),bigImgBean.getDetailUrl());
            }
        });

        }

        ViewHolderHead(View headView){

            banner = headView.findViewById(R.id.banner);

        }

    }

    class MyOnClick implements View.OnClickListener {


        private News.DataBean.ItemListBean itemImageBean;
        private Holder holder;

        public MyOnClick(News.DataBean.ItemListBean itemImageBean,Holder holder){
            this.itemImageBean = itemImageBean;
            this.holder = holder;
        }

        @Override
        public void onClick(View view) {
            String url = itemImageBean.getDetailUrl();
            String title = itemImageBean.getItemTitle();
            String date = itemImageBean.getOperate_time();
            String imagPath = itemImageBean.getItemImage().getImgUrl1();
            if(url.contains("specialList")){
                ToastUtil.toast(context,"特殊的链接");
            }else {
                IntentActivityUtils.jumpToLookNewsActivity(activity,context,title,date,imagPath,url);
                int color1 = Color.parseColor(ColorUtils.isLook);
                holder.tvListviewNewsTitle.setTextColor(color1);
                holder.tvSpc.setTextColor(color1);
                holder.time.setTextColor(color1);
            }
        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, String data);
    }
}