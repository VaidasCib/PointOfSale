package dropdatabase.pos.impl.core.merchant;

import dropdatabase.pos.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "merchants")
public class Merchant extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "location")
    private String location;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "contact_email")
    private String contactEmail;
}
