package com.github.gaozhizhi.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.gaozhizhi.base.activity.BaseActivity;
import com.github.gaozhizhi.base.fragment.BaseFragment;
import com.github.gaozhizhi.mytest.main.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    public BaseFragment setRootDelegate() {
        return new MainFragment(); 
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
