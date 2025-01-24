package com.chan.email_auth.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompleteRegistrationDTO {
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
}
