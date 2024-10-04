package com.dodo.happinessnanumbackend.users.controller;

import com.dodo.happinessnanumbackend.users.dto.UserRequestJoinDto;
import com.dodo.happinessnanumbackend.users.dto.UserResponseDto;
import com.dodo.happinessnanumbackend.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // username (사이트 아이디) 별 검색
    @GetMapping("{username}")
    public ResponseEntity<String> getUser(@PathVariable("username") String username) {

        return ResponseEntity.ok("Hello " + username);
    }

    // id pk값 검색
    @GetMapping("/id/{id}")
    public ResponseEntity<String> getUserByPk(@PathVariable("id") Long id) {

        return ResponseEntity.ok("Hello " + id);
    }

    // 회원 가입
    @PostMapping("")
    public ResponseEntity<String> joinUser(@RequestBody @Valid UserRequestJoinDto dto) {

        UserResponseDto joinedUser = userService.join(dto);

        return ResponseEntity.ok(joinedUser.getUsername());
    }

    // 회원 수정

    // 회원 탈퇴

    // 팔로워 리스트 검색

    // 팔로잉 리스트 검색
}
