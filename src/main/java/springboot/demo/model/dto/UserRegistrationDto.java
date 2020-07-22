package springboot.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private String userId;
    private String profileName;
    private String password;
    private String email;
}
