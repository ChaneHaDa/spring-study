package com.chan.email_auth.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column // 비밀번호 (2단계에서 입력받기)
    private String password;

    // 이메일 인증 여부
    @Column(nullable = false)
    private boolean verified = false;

    // 인증 토큰 (임시)
    @Column
    private String verificationToken;

    // 추가 정보 (2단계에서 입력받기)
    @Column
    private String fullName;
    @Column
    private String phoneNumber;
}

