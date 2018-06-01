package com.cxy890.boot2.util.impl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BD-PC27
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JackpotService {

    /**
     * 合计
     */
    private long tote;

    private long surplus;

    private int level;

    public static JackpotService of(long t, long s, int l) {
        JackpotService pool = new JackpotService();
        pool.setLevel(l);
        pool.setSurplus(s);
        pool.setTote(t);
        return pool;
    }

}
