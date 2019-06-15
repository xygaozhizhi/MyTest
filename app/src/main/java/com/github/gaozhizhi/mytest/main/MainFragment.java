package com.github.gaozhizhi.mytest.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.gaozhizhi.base.fragment.BaseFragment;
import com.github.gaozhizhi.mytest.R;
import com.github.gaozhizhi.mytest.webview.WebTestFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author 高智峰
 * @data 2019/06/12
 * @description
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    public MainAdapter mMainAdapter;
    public String[] mProjectItems={"WebView","SQLite"};
    private List<String> mainData=new ArrayList<>();

    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mainData.addAll(Arrays.asList(mProjectItems));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvMain.setLayoutManager(manager);
        mMainAdapter=new MainAdapter(R.layout.item_main,mainData);
        rvMain.setAdapter(mMainAdapter);
        mMainAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        start(new WebTestFragment());
                        break;
                    case 1:
                        start(new WebTestFragment());
                        break;
                }
            }
        });
    }

}
