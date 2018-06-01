package com.cxy890.boot2.module.history;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

/**
 * @author BD-PC27
 */
@RestController
@RequestMapping("/history")
public class HistoryController {

    @RequestMapping("/emperor")
    public Flux<String> emperor() {
        return Flux.fromIterable(new ArrayList<>());
    }

}
