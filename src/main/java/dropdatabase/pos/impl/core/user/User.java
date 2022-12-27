package dropdatabase.pos.impl.core.user;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.core.merchant.Merchant;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "password")
    private String password;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="merchant_id", referencedColumnName = "id")
    private Merchant merchant;
}
