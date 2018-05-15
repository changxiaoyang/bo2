package com.cxy890.boot2.controller;

import com.cxy890.boot2.model.domain.CurrentUser;
import com.cxy890.boot2.model.domain.Fortune;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.security.SecureRandom;

/**
 * @author BD-PC27
 */
@Slf4j
@RestController
public class LotteryController {

    private static SecureRandom random = new SecureRandom();

    @RequestMapping("/lottery")
    public Object lottery(Fortune fortune, WebSession session, Authentication authentication) throws Exception {
        CurrentUser principal = (CurrentUser) authentication.getPrincipal();

        int max = 0;
        int counter = fortune.getCounter();
        for (int i = 0; i < fortune.getExp(); i++) {
            int anInt = random.nextInt(counter);
            max = Math.min(max, anInt);
        }
        return max + 1;
    }

    @RequestMapping("/cal")
    public Object cal(int times, int scale, double level) {
        BigDecimal sum = new BigDecimal(0);
        BigDecimal last = new BigDecimal(0);
        for (int i = 1; i <= level ;i++) {
            BigDecimal bigDecimal = new BigDecimal(i / level);
            BigDecimal pow = bigDecimal.pow(times);
            BigDecimal subtract = pow.setScale(scale, BigDecimal.ROUND_HALF_UP).subtract(last.setScale(scale, BigDecimal.ROUND_HALF_UP));
            sum = sum.add(subtract);
            System.out.println(subtract.doubleValue());
            last = pow;
        }

        System.out.println(sum.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue());
        return "ok";
    }


}
