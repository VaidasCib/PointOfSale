package dropdatabase.pos.impl.core.merchant.dto;

import lombok.Data;

@Data
public class MerchantPostDto {
    private String name;
    private String companyCode;
    private String location;
    private String contactPhone;
    private String contactEmail;
}
