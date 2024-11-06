package com.dodo.happinessnanumbackend.users.controller;

import com.dodo.happinessnanumbackend.users.dto.UserRequestJoinDto;
import com.dodo.happinessnanumbackend.users.dto.UserRequestUpdateDto;
import com.dodo.happinessnanumbackend.users.dto.UserResponseDto;
import com.dodo.happinessnanumbackend.users.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // username (사이트 아이디) 별 검색
    @GetMapping("{username}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("username") String username) {

        UserResponseDto userResponseDto = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return ResponseEntity.ok(userResponseDto);
    }

    // id pk값 검색
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> getUserByPk(@PathVariable("id") Long id) {

        UserResponseDto userResponseDto = userService.findById(id).orElseThrow(() -> new UsernameNotFoundException(id.toString()));

        return ResponseEntity.ok(userResponseDto);
    }

    // 회원 가입
    @PostMapping("")
    public ResponseEntity<String> joinUser(@RequestBody @Valid UserRequestJoinDto dto) {

        UserResponseDto joinedUser = userService.join(dto);

        return ResponseEntity.created(URI.create("/api/users/" + joinedUser.getId()))
                .body(joinedUser.getUsername());
    }

    // 회원 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserRequestUpdateDto dto) {

        checkSessionUserId(id);

        UserResponseDto updated = userService.update(dto);

        return ResponseEntity.ok("updated user " + updated.getId() + " : " + updated.getUsername());
    }

    // 회원 탈퇴 (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {

        checkSessionUserId(id);

        userService.delete(id);

        return ResponseEntity.ok("deleted user " + id);
    }

    // 회원 재가입 (is_deleted)
    @PostMapping("/rejoin/{id}")
    public ResponseEntity<String> rejoinUser(@PathVariable("id") Long id) {

        checkSessionUserId(id);

        userService.rejoin(id);

        return ResponseEntity
                .created(URI.create("/api/users/" + id))
                .body("rejoined user " + id);
    }

    // 팔로워 리스트 검색
    @GetMapping("/{id}/followers")
    public ResponseEntity<List<UserResponseDto>> getFollowers(@PathVariable("id") Long id) {

        checkSessionUserId(id);
        userService.getFollowers(id);

        return null;
    }

    // 팔로잉 리스트 검색
    @GetMapping("/{id}/following")
    public ResponseEntity<List<UserResponseDto>> getFollowing(@PathVariable("id") Long id) {

        checkSessionUserId(id);

        userService.getFollowings(id);

        return null;
    }


    // 현재 로그인된 세션의 userId 검증 메서드
    private void checkSessionUserId(Long id) {
        Long sessionUserId = (Long) session.getAttribute("userId");
        if (sessionUserId == null) {
            throw new RuntimeException("로그인이 필요합니다"); // todo 추후 커스터마이징
        }
        if (sessionUserId.equals(id)) {
            throw new RuntimeException("접근이 허용되지 않는 계정입니다"); // todo 추후 커스터마이징
        }
    }
}
