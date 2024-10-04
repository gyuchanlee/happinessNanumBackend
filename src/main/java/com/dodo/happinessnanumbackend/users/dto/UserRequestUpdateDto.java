package com.dodo.happinessnanumbackend.users.dto;

import com.dodo.happinessnanumbackend.users.domain.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class UserRequestUpdateDto {

    private Long id;
    // 웹사이트 아이디
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private String name;
    private String nickname;
}
