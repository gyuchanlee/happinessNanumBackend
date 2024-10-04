package com.dodo.happinessnanumbackend.users.dto;

import com.dodo.happinessnanumbackend.users.domain.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class UserResponseDto {
    /**
     * 유저 정보 응답 Dto
     */

    private Long id;
    // 웹사이트 아이디
    private String username;
    private String email;
    private Gender gender;
    private String name;
    private String nickname;
    private LocalDateTime createdAt;
}
