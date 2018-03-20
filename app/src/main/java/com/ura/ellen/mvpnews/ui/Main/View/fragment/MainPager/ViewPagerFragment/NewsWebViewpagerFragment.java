package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.utils.ActivityUtils.IntentActivityUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class NewsWebViewpagerFragment extends BaseFragment {

    @BindView(R.id.wv_fragment_pager1)
    WebView wvFragmentPager1;
    Unbinder unbinder;
    private String url;
    private int p;
    private MainPresenter mainPresenter;


    public NewsWebViewpagerFragment(String url, int p) {

        this.url = url;
        this.p = p;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager_pager1_webview, null);

        MainActivity mainActivity = (MainActivity) getActivity();
        mainPresenter = mainActivity.mPresenter;

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void yeHua() {

    }

    @Override
    public void cancelYeHua() {

    }

    @Override
    public void autoRefresh() {


        WebSettings webSettings = wvFragmentPager1.getSettings();

// 支持javascript
        webSettings.setJavaScriptEnabled(true);

// 支持使用localStorage(H5页面的支持)
        webSettings.setDomStorageEnabled(true);

// 支持数据库
        webSettings.setDatabaseEnabled(true);

// 支持缓存
        webSettings.setAppCacheEnabled(true);
        String appCaceDir = getActivity().getDir("cache", Context.MODE_PRIVATE).getPath();
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
        wvFragmentPager1.setHorizontalScrollBarEnabled(false);
        wvFragmentPager1.setVerticalScrollBarEnabled(false);



// 处理网页内的连接（自身打开）
        wvFragmentPager1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               wvFragmentPager1.loadUrl(url);
                return true;
            }



            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
              wvFragmentPager1.loadUrl(request.getUrl().toString());
                return  true;
            }
        });






        wvFragmentPager1.loadUrl(url);
// 使用返回键的方式防止网页重定向
        wvFragmentPager1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && wvFragmentPager1.canGoBack()) {
                        wvFragmentPager1.goBack();
                        return true;
                    }
                }
                return false;
            }
        });


    }

    @Override
    public void upDateFromNetRefresh() {

    }

    @Override
    public void upDateFromLocal() {

        autoRefresh();

    }

    @Override
    public void upDateFromNetLaodMore() {

    }

    @Override
    public void upDateData(String json, int what) {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("" + url, "可见");
        } else {
            Log.e("" + url, "不可见");
            if(wvFragmentPager1!=null&&url!=null) {
                wvFragmentPager1.loadUrl(url);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
