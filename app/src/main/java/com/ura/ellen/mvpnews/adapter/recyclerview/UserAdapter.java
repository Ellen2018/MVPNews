package com.ura.ellen.mvpnews.adapter.recyclerview;

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
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.UserLike.UserLikeActivity;
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

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;


    private Context context;
    private MainPresenter mainPresenter;

    private int yeHuaColor = Color.WHITE;

    private  boolean isYeHua = false;

    public UserAdapter(Context context,MainPresenter mainPresenter){
        this.context = context;
        this.mainPresenter = mainPresenter;

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
        View view = LayoutInflater.from(context).inflate(R.layout.headview_user,null);

        mHeaderView = view;
        viewHolderHead = new ViewHolderHead(mHeaderView);

        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
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
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_user, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;

        final int pos = getRealPosition(viewHolder);

        if(viewHolder instanceof Holder) {


            if(SharedPreferencesUtil.getData
                    (context,SharedPreferencesUtil.sharedPreference_appName,
                            SharedPreferencesUtil.sharedPreference_isYeHua,Boolean.class,false)){
                int color = Color.parseColor(ColorUtils.yeHuaColor);
                ((Holder) viewHolder).miaoShu.setTextColor(color);
                ((Holder) viewHolder).title.setTextColor(color);
            }else{
                int color = Color.parseColor(ColorUtils.cancelYeHuaColor);
                ((Holder) viewHolder).miaoShu.setTextColor(color);
                ((Holder) viewHolder).title.setTextColor(color);
            }

        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView title;
        TextView miaoShu;


        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
           initView(itemView);
        }

        private void initView(View view) {

            title = view.findViewById(R.id.tv_listview_user_titlename);
            miaoShu = view.findViewById(R.id.tv_listview_user_miaoshu);

        }
    }

    class ViewHolderHead{


        private ImageView yeHua;
        private TextView userName,dengJi,like,lishi;

        ViewHolderHead(View headView){


            initView(headView);

        }

        private void initView(View headView) {
            yeHua = headView.findViewById(R.id.iv_user_yehua);
            yeHua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(SharedPreferencesUtil.getData
                            (context,SharedPreferencesUtil.sharedPreference_appName,
                                    SharedPreferencesUtil.sharedPreference_isYeHua,Boolean.class,false)) {
                        mainPresenter.cancelYeHua();
                    }else{


                        mainPresenter.yeHua();

                    }
                }
            });
            userName = headView.findViewById(R.id.tv_user_name);
            dengJi = headView.findViewById(R.id.tv_user_chenghao);
            like = headView.findViewById(R.id.tv_user_like);

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IntentActivityUtils.jumpToNextActivity(context, UserLikeActivity.class);
                }
            });

            lishi = headView.findViewById(R.id.tv_user_lishi);


        }

        void yeHua(){

            int color = Color.parseColor(ColorUtils.yeHuaColor);
            userName.setTextColor(color);
            dengJi.setTextColor(color);
            like.setTextColor(color);
            lishi.setTextColor(color);



        }

        void cancelYeHua(){

            int color = Color.parseColor(ColorUtils.cancelYeHuaColor);
            userName.setTextColor(color);
            dengJi.setTextColor(color);
            like.setTextColor(color);
            lishi.setTextColor(color);
        }

    }

    public void yeHuaHeadView(){

        viewHolderHead.yeHua();

    }

    public void cancelYeHuaHeadView(){

        viewHolderHead.cancelYeHua();

    }

    interface OnItemClickListener {
        void onItemClick(int position, String data);
    }
}