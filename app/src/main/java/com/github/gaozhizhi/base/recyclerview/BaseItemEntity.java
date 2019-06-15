package com.github.gaozhizhi.base.recyclerview;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * @author 高智峰
 * @data 2019/06/12
 * @description
 */
public class BaseItemEntity implements MultiItemEntity {
    private final ReferenceQueue<LinkedHashMap<Object, Object>> ITEM_QUEUE = new ReferenceQueue<>();
    private final LinkedHashMap<Object, Object> BASE_FIELDS = new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object, Object>> FIELDS_REFERENCE =
            new SoftReference<>(BASE_FIELDS, ITEM_QUEUE);

    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(BaseFields.ITEM_TYPE);
    }

    BaseItemEntity (LinkedHashMap<Object, Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }

    public static BaseEntityBuilder builder() {
        return new BaseEntityBuilder();
    }

    public final Object getField(Object key) {
        return  FIELDS_REFERENCE.get().get(key);
    }

    public final LinkedHashMap<?, ?> getFields() {
        return FIELDS_REFERENCE.get();
    }

    public final BaseItemEntity setField(Object key, Object value) {
        FIELDS_REFERENCE.get().put(key, value);
        return this;
    }

    public static class BaseEntityBuilder {
        private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();

        private BaseEntityBuilder() {
            //先清除之前的数据
            FIELDS.clear();
        }

        public final BaseEntityBuilder setItemType(int itemType) {
            FIELDS.put(BaseFields.ITEM_TYPE, itemType);
            return this;
        }

        public final BaseEntityBuilder setField(Object key, Object value) {
            FIELDS.put(key, value);
            return this;
        }

        public final BaseEntityBuilder setFields(LinkedHashMap<?, ?> map) {
            FIELDS.putAll(map);
            return this;
        }

        public final BaseItemEntity build() {
            return new BaseItemEntity(FIELDS);
        }
    }
}
