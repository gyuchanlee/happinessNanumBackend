package com.dodo.happinessnanumbackend.users.service;

import com.dodo.happinessnanumbackend.users.domain.Follow;
import com.dodo.happinessnanumbackend.users.dto.UserRequestJoinDto;
import com.dodo.happinessnanumbackend.users.dto.UserRequestUpdateDto;
import com.dodo.happinessnanumbackend.users.dto.UserResponseDto;
import com.dodo.happinessnanumbackend.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> findByEmail(String email) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public UserResponseDto join(UserRequestJoinDto dto) {
        return null;
    }

    @Transactional
    @Override
    public UserResponseDto update(UserRequestUpdateDto dto) {
        log.info("{} 회원 업데이트 로직", dto.getUsername());
        return null;
    }

    @Transactional
    @Override
    public void delete(Long userId) {
        log.info("회원 삭제 로직");
    }

    @Override
    public List<Follow> getFollowers(Long userId) {
        return List.of();
    }

    @Override
    public List<Follow> getFollowings(Long userId) {
        return List.of();
    }

    @Transactional
    @Override
    public void follow(Long followerId, Long followingId) {

    }

    @Transactional
    @Override
    public void unfollow(Long followerId, Long followingId) {

    }

    @Override
    public boolean isFollowing(Long followerId, Long followingId) {
        return false;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        return false;
    }

    @Override
    public void rejoin(Long userId) {
        log.info("재가입 로직");
    }
}
