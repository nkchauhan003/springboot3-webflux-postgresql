package com.cb.service;

import com.cb.dto.UserDto;
import com.cb.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> create(Mono<UserDto> userDto);

    Mono<User> retrieve(int userId);

    Mono<User> update(int userId, Mono<UserDto> userDto);

    Mono<Void> delete(int userId);

    Flux<User> list();
}
