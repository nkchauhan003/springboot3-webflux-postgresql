package com.cb.service;

import com.cb.dto.UserDto;
import com.cb.model.User;
import com.cb.repository.UserRepository;
import com.cb.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Mono<User> create(Mono<UserDto> userDto) {
        return userDto.map(UserUtils::toUser).flatMap(userRepository::save);
    }

    @Override
    public Mono<User> retrieve(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Mono<User> update(int userId, Mono<UserDto> userDto) {
        return userRepository.findById(userId)
                .flatMap(user -> userDto
                        .map(UserUtils::toUser)
                        .doOnNext(u -> u.setId(userId)))
                .flatMap(userRepository::save);
    }

    @Override
    public Mono<Void> delete(int userId) {
        return userRepository.deleteById(userId);
    }

    @Override
    public Flux<User> list() {
        return userRepository.findAll();
    }
}
