package dropdatabase.pos.impl.core.user.dto;

import dropdatabase.pos.impl.core.merchant.dto.MerchantDto;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String address;
    private String password;
    private MerchantDto merchant;
}
