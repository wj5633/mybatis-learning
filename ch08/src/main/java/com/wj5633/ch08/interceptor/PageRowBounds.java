package com.wj5633.ch08.interceptor;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.RowBounds;

/**
 * Created at 2019/7/10 17:27.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Getter
@Setter
public class PageRowBounds extends RowBounds {
    private long total;

    public PageRowBounds() {
        super();
    }

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }

}
