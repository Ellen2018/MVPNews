package com.ura.ellen.mvpnews.ui.Splash.presenter;

import android.os.Handler;
import android.os.Message;

import com.ura.ellen.baselibrary.presenter.BasePresenter;
import com.ura.ellen.mvpnews.ui.Splash.SplashActivity;
import com.ura.ellen.mvpnews.ui.Splash.presenter.view.SplashView;
import com.ura.ellen.mvpnews.utils.ActivityUtils.ActivityManager;

import javax.inject.Inject;


public class SplashPresenter extends BasePresenter<SplashView,SplashMode> {



    @Inject
    public SplashPresenter(){}

    public void jumpToMainActivity(){
        mBaseView.jumpToMainActivity();

    }

    public void startDaoJiShi(final int time){

        final MyHandler myHandler = new MyHandler();

        new Thread(){

            private  int timeAll = time;

            @Override
            public void run() {



                while (ActivityManager.getInstance().getTopActivity() instanceof SplashActivity){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    timeAll--;
                    Message message = new Message();
                    message.arg1 = timeAll;
                    myHandler.sendMessage(message);

                    if(timeAll==0){break;}

                }
            }
        }.start();


    }


    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {

                mBaseView.upDate(msg.arg1);

        }
    }

}
