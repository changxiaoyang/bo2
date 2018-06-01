package com.cxy890.boot2.util;

import com.cxy890.boot2.util.impl.JackpotService;
import com.cxy890.boot2.util.impl.ScratchTicket;

/**
 * @author BD-PC27
 */
public class Jackpots {

    public static JackpotService randamJackpot = JackpotService.of(1, 1, 0);

    public static JackpotService newFixedJackpot(long tote) {
        return JackpotService.of(tote, tote, 3);
    }

    public static JackpotService newRefillableJackpot(long tote) {
        return JackpotService.of(tote, tote, 2);
    }

    public static JackpotService newRandamJackpot() {
        return JackpotService.of(1, 1, 0);
    }

    public static ScratchTicket scratchTicket(int week) {
        return ScratchTicket.of(week);
    }

}
