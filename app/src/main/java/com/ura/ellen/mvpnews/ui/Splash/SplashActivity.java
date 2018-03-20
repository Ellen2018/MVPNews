package com.ura.ellen.mvpnews.ui.Splash;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Button;

import com.ura.ellen.baselibrary.ui.activity.BaseMvpActivity;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.ui.Splash.presenter.SplashMode;
import com.ura.ellen.mvpnews.ui.Splash.presenter.SplashPresenter;
import com.ura.ellen.mvpnews.ui.Splash.presenter.view.SplashView;
import com.ura.ellen.mvpnews.utils.ActivityUtils.ActivityIntentUtils;
import com.ura.ellen.mvpnews.utils.ActivityUtils.ActivityManager;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashView {


    @BindView(R.id.bt_splashactivity_splashbutton)
    Button btnSplash;
   @OnClick(R.id.bt_splashactivity_splashbutton)
   void btnSplashOnClick(){
       jumpToMainActivity();
   }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置去除ActionBar
        //设置去除ActionBar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getSupportActionBar().hide();
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //绑定布局
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //实例化P层
        mPresenter = new SplashPresenter();
        //实例化View
        mPresenter.mBaseView = this;
        //实例化Mode层
        mPresenter.mBaseMode = new SplashMode();


        ActivityManager activityManager = ActivityManager.getInstance();
        ActivityManager.mActivityManager.addActivity(this);

        //在这里创建数据库？
        NewsSQLiteUtils sqLiteUtil = new NewsSQLiteUtils(this,NewsSQLiteUtils.SQL_NAME,null,1);
        SQLiteDatabase db  = sqLiteUtil.getWritableDatabase();//执行这里数据库才会被创建,db可用于数据库的数据添加，删除，修改，查询操作。

    }

    @Override
    protected void onResume() {
        super.onResume();
        //开启线程进行倒计时任务
        mPresenter.startDaoJiShi(mPresenter.mBaseMode.TIME);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.mActivityManager.removeActivity(this);
        super.onDestroy();
    }


    @Override
    public void upDate(int time) {

        if (time > 0) {
            btnSplash.setText("跳过" + time);
        } else {
            mPresenter.jumpToMainActivity();
        }

    }

    @Override
    public void jumpToMainActivity() {
        ActivityIntentUtils.jumpToNextActivityNoAnim(SplashActivity.this, MainActivity.class);
        finish();
    }
}
