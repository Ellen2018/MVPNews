package com.ura.ellen.mvpnews.adapter.recyclerview;

import android.content.Context;
import android.graphics.Color;
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
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;
import com.ura.ellen.mvpnews.utils.TimeUtils;

import java.util.List;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.ViewHolder>{

    private Context context;
    private List<LocalRes> localRess;

     public LocalMusicAdapter(Context context, List<LocalRes> localRes){

        this.context = context;
        this.localRess = localRes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_local_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


         LocalRes localRes = localRess.get(position);

         holder.musicName.setText(localRes.getMusicName()+"/"+localRes.getSingerName());
         String time = TimeUtils.getUserCanKnowTimeString((int) (localRes.getTime()/1000));
         String  size = android.text.format.Formatter.formatFileSize(context,localRes.getSize());
         holder.musicSize.setText(time+"("+size+")");

         if(SharedPreferencesUtil.getData
                 (context,SharedPreferencesUtil.sharedPreference_appName,
                         SharedPreferencesUtil.sharedPreference_isYeHua,Boolean.class,false)){
             holder.musicSize.setTextColor(Color.WHITE);
             holder.musicName.setTextColor(Color.WHITE);
         }else{
             holder.musicSize.setTextColor(Color.BLACK);
             holder.musicName.setTextColor(Color.BLACK);
         }

    }

    @Override
    public int getItemCount() {
        return localRess.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


       private ImageView imageView;
       private TextView musicName;
       private TextView musicSize;

        public ViewHolder(View itemView) {
            super(itemView);
           initView(itemView);
        }

        private void initView(View view) {

            imageView = view.findViewById(R.id.iv_listview_local_music);
            musicName = view.findViewById(R.id.tv_listview_local_music_name);
            musicSize = view.findViewById(R.id.tv_listview_local_music_size_time);

        }
    }

}
