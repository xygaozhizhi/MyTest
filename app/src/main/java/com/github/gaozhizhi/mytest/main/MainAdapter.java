package com.github.gaozhizhi.mytest.main;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.gaozhizhi.mytest.R;

import java.util.List;


/**
 * @author 高智峰
 * @data 2019/06/12
 * @description
 */
public class MainAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    MainAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_main,item);
    }
}
