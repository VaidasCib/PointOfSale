package dropdatabase.pos.impl.core.merchant.dto;

import lombok.Data;

@Data
public class MerchantPutDto {
    private String name;
    private String location;
    private String contactPhone;
    private String contactEmail;
}
