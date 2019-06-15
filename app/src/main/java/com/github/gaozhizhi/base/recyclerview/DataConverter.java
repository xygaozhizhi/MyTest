package com.github.gaozhizhi.base.recyclerview;

import java.util.ArrayList;

/**
 * @author 高智峰
 * @data 2019/06/14
 * @description
 */
public abstract class DataConverter {
    protected final ArrayList<BaseItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;
    private String[] strings=null;

    public abstract ArrayList<BaseItemEntity> convert();
    public DataConverter setData(String[] data) {
        this.strings = data;
        return this;
    }
    protected String[] getData() {
        if (strings == null || strings.length==0) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return strings;
    }

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }

    public void clearData(){
        ENTITIES.clear();
    }
}
