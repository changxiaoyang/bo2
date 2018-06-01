package com.cxy890.boot2.module.base;

import com.cxy890.boot2.module.user.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author BD-PC27
 */
@RestController
@RequestMapping("/register")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterController {

    private final UserDetailServiceImpl reactiveUserDetailsService;

    @RequestMapping
    public Mono<UserDetails> register(String username, String password) {
        return reactiveUserDetailsService.createUser(username, password);
    }

}
