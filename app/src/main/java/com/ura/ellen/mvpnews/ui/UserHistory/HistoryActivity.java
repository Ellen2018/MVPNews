package com.ura.ellen.mvpnews.ui.UserHistory;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.listview.NewsLikeAdapter;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends Activity {

    @BindView(R.id.iv_userlikeactivity_back)
    ImageView ivUserlikeactivityBack;
    @BindView(R.id.lv_userlikeactivity)
    ListView lvUserlikeactivity;

    @OnClick(R.id.iv_userlikeactivity_back)
    void back(){
        finish();
    }

    private NewsLikeAdapter newsLikeAdapter;
    private List<String[]> arrayList;

    private Activity activity;
    private Context context;


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        activity = this;
        context = this;
        arrayList = NewsSQLiteUtils.getUserHistoryNewsData(this,NewsSQLiteUtils.SQL_HISTORY);

        newsLikeAdapter = new NewsLikeAdapter(activity,context,arrayList);
        lvUserlikeactivity.setAdapter(newsLikeAdapter);

    }
}
