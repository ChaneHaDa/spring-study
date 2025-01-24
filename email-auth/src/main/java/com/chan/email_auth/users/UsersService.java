package com.chan.email_auth.users;

import com.chan.email_auth.email.EmailService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    private final UsersRepository userRepository;
    private final EmailService emailService;

    public UsersService(UsersRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void initiateEmailRegistration(String email) {
        // 1) 이메일 중복 확인
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use.");
        }

        // 2) 임시 사용자 생성
        Users tempUser = new Users();
        tempUser.setEmail(email);
        tempUser.setVerified(false);

        // 토큰 생성 (UUID 등)
        String token = UUID.randomUUID().toString();
        tempUser.setVerificationToken(token);

        userRepository.save(tempUser);

        // 3) 이메일 전송
        emailService.sendVerificationEmail(email, token);
    }

    public boolean verifyEmail(String token) {
        // 토큰으로 사용자 찾기
        Users user = userRepository.findByVerificationToken(token).orElse(null);
        if (user == null) {
            return false;
        }
        // verified = true로 업데이트하고, verificationToken은 null 처리
        user.setVerified(true);
        user.setVerificationToken(null);
        userRepository.save(user);
        return true;
    }

    public void completeRegistration(String email, String password, String fullName, String phoneNumber) {
        // verified = true인 유저만 최종 가입 가능
        Users user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("No user found for the email.")
        );
        if (!user.isVerified()) {
            throw new IllegalStateException("Email not yet verified.");
        }
        // 비밀번호 설정, 추가 정보 입력
        user.setPassword(password); // 반드시 암호화(BCrypt 등)
        user.setFullName(fullName);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);
    }
}

