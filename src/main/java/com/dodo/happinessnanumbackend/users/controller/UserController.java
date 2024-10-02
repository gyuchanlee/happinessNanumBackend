package com.dodo.happinessnanumbackend.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    // username (사이트 아이디) 별 검색
    @GetMapping("{username}")
    public ResponseEntity<String> getUser(@PathVariable("username") String username) {

        return ResponseEntity.ok("Hello " + username);
    }

    // 회원 가입

    // 회원 수정

    // 회원 탈퇴

    // 팔로워 리스트 검색

    // 팔로잉 리스트 검색
}
