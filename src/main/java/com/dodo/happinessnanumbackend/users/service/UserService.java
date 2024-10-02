package com.dodo.happinessnanumbackend.users.service;

import com.dodo.happinessnanumbackend.users.domain.Follow;
import com.dodo.happinessnanumbackend.users.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // 회원 한 건 (id 기준) 검색 todo Dto쓰기
    Optional<User> findById(Long id);
    // 회원 한 건 (username 기준) 검색 todo Dto쓰기
    Optional<User> findByUsername(String username);
    // 회원 한 건 (email 기준) 검색 todo Dto쓰기
    Optional<User> findByEmail(String email);
    // 회원 가입 todo Dto쓰기
    User join(User user);
    // 회원 수정 todo Dto쓰기
    User update(User user);
    // 회원 탈퇴
    void delete(Long userId);
    // 팔로워 리스트 검색 todo Dto쓰기 Follow -> FollowDto
    List<Follow> getFollowers(Long userId);
    // 팔로잉 리스트 검색 todo Dto쓰기 Follow -> FollowDto
    List<Follow> getFollowings(Long userId);
    // 팔로우 하기
    void follow(Long followerId, Long followingId);
    // 언팔로우 하기
    void unfollow(Long followerId, Long followingId);
    // 팔로우 여부 확인
    boolean isFollowing(Long followerId, Long followingId);
    // 회원 존재 여부 확인
    boolean existsByUsername(String username);
    // 이메일 존재 여부 확인
    boolean existsByEmail(String email);
}
