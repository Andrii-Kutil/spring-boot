package springboot.demo.model.dto;

import lombok.Data;

@Data
public class JwtResponse {
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
