package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.recyclerview.UserAdapter;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import butterknife.BindView;

public class UserPager extends BasePager {


    private RecyclerView rlUser;
    private UserAdapter userAdapter;

    public UserPager(MainPresenter mainPresenter) {
        super(mainPresenter);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mainPresenter.mBaseMode.getContext()).inflate(R.layout.pager_user, null);

        rlUser = view.findViewById(R.id.rl_user);

        //设置RecyclerView 布局管理器
        LinearLayoutManager layoutmanager = new LinearLayoutManager(mainPresenter.getContenxt());
        rlUser.setLayoutManager(layoutmanager);

        rlUser.setAdapter(userAdapter = new UserAdapter(mainPresenter.getContenxt(),mainPresenter));

        return view;
    }

    @Override
    public void yeHua() {

        rlUser.setBackgroundColor(Color.BLACK);
        userAdapter.notifyDataSetChanged();
        userAdapter.yeHuaHeadView();

    }

    @Override
    public void cancelYeHua() {
        rlUser.setBackgroundColor(Color.WHITE);
        userAdapter.notifyDataSetChanged();
        userAdapter.cancelYeHuaHeadView();
    }

    @Override
    public void onUpDate() {
        //ToastUtil.toast(mainPresenter.mBaseMode.getContext(), "更新用户数据");
    }

    @Override
    public void changOnBackgroundAgo() {

    }
}
