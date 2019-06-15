package com.github.gaozhizhi.base.recyclerview;

import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 高智峰
 * @data 2019/06/12
 * @description
 */
public class BaseRecyclerAdapter extends BaseMultiItemQuickAdapter<BaseItemEntity,BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup {

    protected BaseRecyclerAdapter(List<BaseItemEntity> data) {
        super(data);
        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    public static BaseRecyclerAdapter create(List<BaseItemEntity> data) {
        return new BaseRecyclerAdapter(data);
    }


    @Override
    protected void convert(BaseViewHolder helper, BaseItemEntity item) {

    }


    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return (int) getData().get(position).getField(BaseFields.SPAN_SIZE);
    }
}
