package org.korit.restcontrollers;

import lombok.Data;

@Data
public class RequestLogin {
    private String userId;
    private String userPw;
}
