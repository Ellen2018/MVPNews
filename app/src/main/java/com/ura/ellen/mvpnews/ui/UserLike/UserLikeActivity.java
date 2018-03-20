package com.ura.ellen.mvpnews.ui.UserLike;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.listview.NewsLikeAdapter;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLikeActivity extends Activity {


    @BindView(R.id.iv_userlikeactivity_back)
    ImageView ivUserlikeactivityBack;
    @BindView(R.id.lv_userlikeactivity)
    ListView lvUserlikeactivity;

    @OnClick(R.id.iv_userlikeactivity_back)
    void back(){
        finish();
    }

    private Context context;
    private Activity activity;

    private NewsLikeAdapter newsLikeAdapter;
    List<String[]> arrayList;


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        ButterKnife.bind(this);
        context = this;
        activity = this;
        arrayList = NewsSQLiteUtils.getUserLikeNewsData(this);

        newsLikeAdapter = new NewsLikeAdapter(activity,context,arrayList);
        lvUserlikeactivity.setAdapter(newsLikeAdapter);


    }
}
