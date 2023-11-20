package com.platform.common.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CopyListUtil {
    private CopyListUtil() {
    }
    /**
     * 列表对象拷贝
     * @param sources 源列表
     * @param clazz 目标列表对象Class
     * @param <T> 目标列表对象类型
     * @param <M> 源列表对象类型
     * @return 目标列表
     */
    public static <T, M> List<T> copyListProperties(List<M> sources, Class<T> clazz) {
        if (Objects.isNull(sources) || Objects.isNull(clazz) || sources.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<T> targets = new ArrayList<>(sources.size());
        for (M source : sources) {
            T t = ReflectUtil.newInstance(clazz);
            BeanUtil.copyProperties(source,t);
            targets.add(t);
        }
        return targets;
    }
}