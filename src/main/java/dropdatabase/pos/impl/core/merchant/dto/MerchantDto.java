package dropdatabase.pos.impl.core.merchant.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MerchantDto {
    private UUID id;
    private String name;
    private String companyCode;
    private String location;
    private String contactPhone;
    private String contactEmail;
}
