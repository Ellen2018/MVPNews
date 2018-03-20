package com.ura.ellen.mvpnews.ui.LookNews;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.ActivityUtils.IntentActivityUtils;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class LookNewsActivity extends SwipeBackActivity {

    @BindView(R.id.wv_looknewsactivity)
    WebView wvLooknewsactivity;
    @BindView(R.id.iv_looknewsactivity_back)
    ImageView ivLooknewsactivityBack;
    @BindView(R.id.iv_looknewsactivity_fenxiang)
    ImageView ivLooknewsactivityFenxiang;
    @BindView(R.id.iv_looknewsactivity_like)
    ImageView ivLooknewsactivityLike;

    @OnClick(R.id.iv_looknewsactivity_back)
    void back(){
        finish();
    }

    @OnClick(R.id.iv_looknewsactivity_fenxiang)
    void fenXiang(){
        ToastUtil.toast(context,"分享");
    }

    @OnClick(R.id.iv_looknewsactivity_like)
    void like(){
        if(isLike){
            //取消喜欢
            ivLooknewsactivityLike.setImageResource(R.drawable.nolike);
            NewsSQLiteUtils.deleteUserLikeNewsData(context,url);
            isLike = false;
        }else{
            //添加喜欢
            ivLooknewsactivityLike.setImageResource(R.drawable.like);
            NewsSQLiteUtils.saveUserLikeNewsData(context,title,date,imagePath,url);
            isLike = true;

        }
    }


    private String imagePath = null;
    private String title = null;
    private String date = null;
    private String url = null;

    private boolean isLike = false;
    private Context context;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looknews);
        ButterKnife.bind(this);

        context = this;


        mSwipeBackLayout = getSwipeBackLayout();
        //设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        Intent intent = getIntent();
        title = intent.getStringExtra(IntentActivityUtils.NEWS_TITLE);
        date = intent.getStringExtra(IntentActivityUtils.NEWS_DATE);
        imagePath = intent.getStringExtra(IntentActivityUtils.NEWS_IMAGEPATH);
        url = intent.getStringExtra(IntentActivityUtils.NEWS_URL);


        if(NewsSQLiteUtils.isUserLikeThisNewsData(context,url)){
            ivLooknewsactivityLike.setImageResource(R.drawable.like);
            isLike = true;
        }else{
            ivLooknewsactivityLike.setImageResource(R.drawable.nolike);
            isLike = false;
        }

        WebSettings webSettings = wvLooknewsactivity.getSettings();

// 支持javascript
        webSettings.setJavaScriptEnabled(true);

// 支持使用localStorage(H5页面的支持)
        webSettings.setDomStorageEnabled(true);

// 支持数据库
        webSettings.setDatabaseEnabled(true);

// 支持缓存
        webSettings.setAppCacheEnabled(true);
        String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        webSettings.setAppCachePath(appCaceDir);

// 设置可以支持缩放
        webSettings.setUseWideViewPort(true);

// 扩大比例的缩放
        webSettings.setSupportZoom(true);

        webSettings.setBuiltInZoomControls(true);

// 隐藏缩放按钮
        webSettings.setDisplayZoomControls(false);

// 自适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);

// 隐藏滚动条
        wvLooknewsactivity.setHorizontalScrollBarEnabled(false);
        wvLooknewsactivity.setVerticalScrollBarEnabled(false);


// 处理网页内的连接（自身打开）
        wvLooknewsactivity.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wvLoadTrueUrl(view, url);
                return true;
            }

            private void wvLoadTrueUrl(WebView webView, String url) {

                String[] strings = new String[]{
                        "StartPlayVideo",
                        "Share",
                        "StartDownloadImage",
                        "FindMoreComment",
                };

                String url1 = url;

                //视频：js2cmd://StartPlayVideo@一串不明所以的id
                //分享：js2cmd:doSinaShare,doWeixinShare,doWeixinCircleShare,doSystemShare
                //Gif:js2cmd:StartDownloadingImage@gif的地址(.gif)
                //查看更多评论：js2cmd.FindMoreComment@评论的id
                //图片：js2cmd:StartDownloadingImage@gif的地址(.jpg)

                if (url.contains(strings[0])) {
                    ToastUtil.toast(context, "播放视频");
                } else if (url.contains(strings[1])) {

                    if (url.contains("SinaShare")) {
                        ToastUtil.toast(context, "进行新浪分享");
                    } else if (url.contains("WeixinShare")) {
                        ToastUtil.toast(context, "进行微信分享");
                    } else if (url.contains("WeixinCircleShare")) {
                        ToastUtil.toast(context, "进行微信朋友圈分享");
                    } else if (url.contains("SystemShare")) {
                        ToastUtil.toast(context, "进行其他分享");
                    }

                    return;

                } else if (url.contains(strings[2])) {

                    if (url.endsWith(".jpg")) {
                        ToastUtil.toast(context, "显示jpg图片");
                        url1 = url.substring(url.indexOf("@") + 1);
                        ;
                    } else if (url.endsWith(".gif")) {
                        ToastUtil.toast(context, "显示gif动态图");
                        url1 = url.substring(url.indexOf("@") + 1);
                        ToastUtil.toast(context, url1);
                    } else {


                        url1 = url.substring(url.indexOf("@") + 1);


                    }


                } else if (url.contains(strings[3])) {

                    ToastUtil.toast(context, "显示评论");

                } else {


                }


                webView.loadUrl(url1);


            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url1 = request.getUrl().toString();

                wvLoadTrueUrl(view, url1);
                return true;
            }
        });


        wvLooknewsactivity.loadUrl(url);
        // 使用返回键的方式防止网页重定向
        wvLooknewsactivity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && wvLooknewsactivity.canGoBack()) {
                        wvLooknewsactivity.goBack();
                        return true;
                    }
                }
                return false;
            }
        });


    }
}
