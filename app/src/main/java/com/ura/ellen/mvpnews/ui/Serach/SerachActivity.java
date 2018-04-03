package com.ura.ellen.mvpnews.ui.Serach;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ura.ellen.mvpnews.Mode.CityTianQi;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.NetUtils.MyOkHttpUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SerachActivity extends FragmentActivity {

    @BindView(R.id.et_serachactivity)
    EditText etSerachactivity;
    @BindView(R.id.tv_serachactivity_showmessage)
    TextView tvSerachactivity;
    @BindView(R.id.tv_serachactivity_serach)
    TextView tvSerachactivitySerach;
    private String url = "https://www.sojson.com/open/api/weather/json.shtml?city=";

    private MyHandler myHandler;
    private MyThread myThread;
    private String city = "武汉";
    private String json = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach);
        ButterKnife.bind(this);
        myHandler = new MyHandler();

        myThread = new MyThread();
        myThread.start();

        tvSerachactivitySerach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSerachactivity.getText().toString().equals("")){
                     return;
                }else {
                    city = etSerachactivity.getText().toString();
                }
                if(myThread == null){
                    myThread = new MyThread();
                    myThread.start();
                }else{
                    return;
                }
            }
        });

    }

    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {

            myThread = null;

            if(json.contains("\"message\":\"Check the parameters.\"")){
                ToastUtil.toast(SerachActivity.this,"城市名不存在！");
                return;
            }

            Gson gson = new Gson();
            CityTianQi cityTianQi = gson.fromJson(json, CityTianQi.class);
            if(cityTianQi == null){return;}
            CityTianQi.DataBean.ForecastBean cityTianQi1Tomrrow = cityTianQi.getData().getForecast().get(0);

            tvSerachactivity.setText("城市名：" + cityTianQi.getCity() + "\n"
                    + "日期：" + cityTianQi.getDate() + "\n"
                    + "温度：" + cityTianQi.getData().getWendu() + "\n"
                    + "湿度：" + cityTianQi.getData().getShidu() + "\n"
                    + "空气质量：" + cityTianQi.getData().getQuality() + "\n"
                    + "PM10：" + cityTianQi.getData().getPm10() + "\n"
                    + "PM25：" + cityTianQi.getData().getPm25() + "\n"
                    + "注意：" + cityTianQi.getData().getGanmao() + "\n"
                    + "\n"
                    + "明日天气预报：\n"
                    + "日期：" + cityTianQi1Tomrrow.getDate() + "\n"
                    + "高温：" + cityTianQi1Tomrrow.getHigh() + "\n"
                    + "低温：" + cityTianQi1Tomrrow.getLow() + "\n"
                    + "风向：" + cityTianQi1Tomrrow.getFx() + "\n"
                    + "风级：" + cityTianQi1Tomrrow.getFl() + "\n"
                    + "天气：" + cityTianQi1Tomrrow.getType() + "\n"
                    + "注意：" + cityTianQi1Tomrrow.getNotice() + "\n"

            );


        }
    }

    class MyThread extends Thread {

        @Override
        public void run() {
            try {
                json = MyOkHttpUtils.getInstance().getJson((url + city));
                if(json!=null&&json.length()>0) {
                    myHandler.sendEmptyMessage(0);
                }else{
                    myThread = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
