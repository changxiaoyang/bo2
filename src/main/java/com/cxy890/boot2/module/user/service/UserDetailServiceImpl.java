package com.cxy890.boot2.module.user.service;

import com.cxy890.boot2.module.user.domain.CurrentUser;
import com.cxy890.boot2.module.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author BD-PC27
 */
@Service("reactiveUserDetailsService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailServiceImpl implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public Mono<UserDetails> findByUsername(String inputUsername) {
        UserDetails result = userRepository.findOne((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("username").as(String.class), inputUsername),
                        criteriaBuilder.equal(root.get("id").as(String.class), inputUsername)
                )).orElse(null);
        return result == null ? Mono.empty() : Mono.just(result);
    }

    public Mono<UserDetails> createUser(String username, String password) {
        CurrentUser user = new CurrentUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities("user");
        CurrentUser currentUser = userRepository.save(user);
        return Mono.just(currentUser);
    }
}
