package dto;

import lombok.Value;

@Value
public class User {
    String email;
    String username;
    String psw;
}
