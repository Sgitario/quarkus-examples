package org.sgitario.email.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Note that this entity is only used as a super hack to force Quarkus to configure the Hibernate entity manager for us.
 */
@Entity
public class ReportEntity {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
