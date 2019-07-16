package com.wj5633.ch07.type;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created at 2019/7/10 15:07.
 *
 * @author wangjie
 * @version 1.0.0
 */

public enum Enabled {
    disabled(0),
    enabled(1);

    @Getter
    private final int value;

    Enabled(int value) {
        this.value = value;
    }


    private static final Map<Integer, Enabled> valueMap = new HashMap<>();

    static {
        for (Enabled enabled : Enabled.values()) {
            valueMap.put(enabled.getValue(), enabled);
        }
    }

    public static Enabled getEnabledByValue(Integer value) {
        return valueMap.get(value);
    }
}
