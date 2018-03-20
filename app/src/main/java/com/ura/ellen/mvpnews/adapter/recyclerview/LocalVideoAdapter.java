package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.BitMapUtil;
import com.ura.ellen.mvpnews.utils.FileUtil;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;
import com.ura.ellen.mvpnews.utils.TimeUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalVideoAdapter extends RecyclerView.Adapter<LocalVideoAdapter.ViewHolder>{

    private Context context;
    private List<LocalRes> localRess;

     public LocalVideoAdapter(Context context,List<LocalRes> localRes){

        this.context = context;
        this.localRess = localRes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_local_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


         LocalRes localRes = localRess.get(position);

         holder.textView.setText(localRes.getName());



        String time = TimeUtils.getUserCanKnowTimeString((int) (localRes.getTime()/1000));
        String  size = android.text.format.Formatter.formatFileSize(context,localRes.getSize());

        holder.sizeTime.setText(time+"("+size+")");

        BitMapAsyncTask bitMapAsyncTask = new BitMapAsyncTask(localRes.getPath(),localRes.getName());
        bitMapAsyncTask.execute("");

        //加载视频的第一针
        Glide.with(context).
                load(new File(new FileUtil().appDir,localRes.getName()+".jpg"))
                .placeholder(R.drawable.video_default_icon)
                .error(R.drawable.video_default_icon)
                .into(holder.imageView);

        if(SharedPreferencesUtil.getData
                (context,SharedPreferencesUtil.sharedPreference_appName,
                        SharedPreferencesUtil.sharedPreference_isYeHua,Boolean.class,false)){
            holder.textView.setTextColor(Color.WHITE);
            holder.sizeTime.setTextColor(Color.WHITE);
        }else{
            holder.textView.setTextColor(Color.BLACK);
            holder.sizeTime.setTextColor(Color.BLACK);
        }

    }

    @Override
    public int getItemCount() {
        return localRess.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


       private ImageView imageView;
       private TextView textView;
       private TextView sizeTime;

        public ViewHolder(View itemView) {
            super(itemView);
           initView(itemView);
        }

        private void initView(View view) {
            textView = view.findViewById(R.id.tv_listview_local_video_name);
            imageView = view.findViewById(R.id.iv_listview_local_video);
            sizeTime = view.findViewById(R.id.tv_listview_local_video_size_time);
        }
    }

    class BitMapAsyncTask extends AsyncTask<String, Integer, String> {


        String path;
        String name;
        Bitmap bitmap;

        public BitMapAsyncTask(String path,String name){

            this.path = path;
            this.name = name;



        }

        @Override
        protected String doInBackground(String... strings) {
            //存储图片
            bitmap = new BitMapUtil().getLocalVideoThumbnail(path);
            new FileUtil().saveImage(bitmap,name);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            ToastUtil.toast(context,"加载");
        }
    }

}
