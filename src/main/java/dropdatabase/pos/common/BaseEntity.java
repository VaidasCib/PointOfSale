package dropdatabase.pos.common;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column
    @GeneratedValue
    protected UUID id;
}
