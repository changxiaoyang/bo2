package com.cxy890.boot2.util.impl;

import com.cxy890.boot2.util.Jackpot;

/**
 * @author BD-PC27
 */
public class ScratchTicket<T> implements Jackpot {

    private int level;

    @Override
    public T next() throws Exception {
        for (int i = 0; i< level;i++) {

        }
        return null;
    }

    public static ScratchTicket of(int level) {
        ScratchTicket ticket = new ScratchTicket();
        ticket.level = level;
        return ticket;
    }

}
