package com.cxy890.boot2.module.base;

import com.cxy890.boot2.common.annotation.AopPoint;
import com.cxy890.boot2.module.user.domain.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.io.File;
import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author BD-PC27
 */
@RestController
@Slf4j
public class HomeController {

    @AopPoint
    @RequestMapping("/count")
    public Object signCount(ServerHttpRequest httpRequest) {
        // todo : count data from database
        Map<String, Long> counter = new HashMap<>();
        counter.put("body", 12300L);
        counter.put("contract", 866000L);
        counter.put("time", 866000L * 3);
        counter.put("paper", 866000L * 5);
        return counter;
    }

    @RequestMapping("/error")
    public Mono error() {
        Map<String, Long> counter = new HashMap<>();
        counter.put("asaaa", 12300L);
        return Mono.just(counter);
    }

    @RequestMapping("/test")
    public Mono test() {
        Map<String, Long> counter = new HashMap<>();
        counter.put("body", 12300L);
        counter.put("contract", 866000L);
        counter.put("time", 866000L * 3);
        counter.put("paper", 866000L * 5);
        return Mono.just(counter);
    }

    @RequestMapping("/pets")
    public String handle(String pet, SessionStatus status) throws Exception {
        String[] split = pet.split(";");
        status.setComplete();
        return "111";
    }

    @GetMapping("/hello")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }

    @GetMapping("/randomNumbers")
    public Flux<ServerSentEvent<Integer>> randomNumbers() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                        .event("random")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2())
                        .build());
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> requestBodyFlux(@RequestPart("file") FilePart filePart) throws IOException {
        System.out.println(filePart.filename());
        Path tempFile = Files.createTempFile("test", filePart.filename());

        //NOTE 方法一
        AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    System.out.println("finish");
                })
                .subscribe();

        //NOTE 方法二
//        filePart.transferTo(tempFile.toFile());

        System.out.println(tempFile.toString());
        return Mono.just(filePart.filename());
    }

    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=e_contract.png");
        response.getHeaders().setContentType(MediaType.IMAGE_PNG);

        File file = new File("D:\\E57317A4-53DF-4387-9DA4-AD163D26C562.jpeg");
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }

    @GetMapping("/me")
    public Mono<CurrentUser> getCurrentUser() {
        log.debug("sssss");
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .cast(CurrentUser.class);
    }

}
