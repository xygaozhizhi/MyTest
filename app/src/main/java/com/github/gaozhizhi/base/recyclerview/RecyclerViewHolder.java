package com.github.gaozhizhi.base.recyclerview;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * @author 高智峰
 * @data 2019/06/14
 * @description
 */
public class RecyclerViewHolder extends BaseViewHolder {

    private RecyclerViewHolder(View view) {
        super(view);
    }

    public static RecyclerViewHolder create(View view) {
        return new RecyclerViewHolder(view);
    }
}

