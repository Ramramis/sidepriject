package user.side.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class UserDto {
    private String userid;
    private String email;
    private String password;
    private String name;
    private String role;
    private Timestamp created_at;
    private String address;
    private String Phone;
}
