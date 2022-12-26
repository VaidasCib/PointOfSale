package dropdatabase.pos.impl.core.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserPutDto {
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String address;
    private String password;
}
