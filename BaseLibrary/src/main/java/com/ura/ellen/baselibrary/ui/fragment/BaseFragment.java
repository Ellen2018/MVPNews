package com.ura.ellen.baselibrary.ui.fragment;

import android.os.Handler;
import android.support.v4.app.Fragment;



public abstract class BaseFragment extends Fragment {


    //液化模式回调
    public abstract void yeHua();

    //液化模式回调
    public abstract void cancelYeHua();

    public abstract void autoRefresh();

    public abstract void upDateFromNetRefresh();

    public abstract void upDateFromLocal();

    public abstract void upDateFromNetLaodMore();

    public final int AUTO_REFRSH = 0,USER_REFRESH_DOWN = 1,USER_LOADMORE_UP = 2,USER_LOCAL = 3,USER_LOAD_FAIL = 4;

    public Handler myUpdateHandler;

    public final int fenYeNumber = 20;
    public int n2 = 20;

    public abstract void upDateData(String json,int what);

}
