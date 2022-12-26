package dropdatabase.pos.impl.core.user.dto;

import dropdatabase.pos.impl.core.merchant.dto.MerchantPostDto;
import lombok.Data;

import java.util.Date;

@Data
public class UserPostDto {
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String address;
    private String password;
    private MerchantPostDto merchant;
}