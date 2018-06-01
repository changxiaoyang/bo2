package com.cxy890.boot2.util.impl;

import com.cxy890.boot2.object.Objects;
import com.cxy890.boot2.object.impl.Apple;
import com.cxy890.boot2.util.Jackpot;
import com.cxy890.boot2.util.ObjectBox;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author BD-PC27
 */
public class ScratchTicket implements Jackpot {

    private int card = 5;

    private int level;

    private Random random = new SecureRandom();

    @Override
    public ObjectBox produce() throws Exception {
        List<Objects> objects = new ArrayList<>();
        for (int i = 0; i< card; i++) {
            int pre = random.nextInt(30) + random.nextInt(level * 10);
            objects.add(Apple.of(pre));
        }
        return ObjectBox.put(objects);
    }

    @Override
    public Objects draw() throws Exception {
        return null;
    }

    public static ScratchTicket of(int level) {
        ScratchTicket ticket = new ScratchTicket();
        ticket.level = level;
        return ticket;
    }

}
