package dropdatabase.pos.impl.category;

import dropdatabase.pos.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(name = "name")
    private String name;
}

