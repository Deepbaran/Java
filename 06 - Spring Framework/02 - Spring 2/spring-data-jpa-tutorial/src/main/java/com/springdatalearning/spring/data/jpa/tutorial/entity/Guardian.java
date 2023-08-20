package com.springdatalearning.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// We do not want to make this a separate entity.
// We want these guardian properties for the Student class only.
// So we will embed this class into the Student class.
// For this to happen, we need to annotate this class as Embeddable, for other classes/entities to embed it into themselves.
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ), @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ), @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        ),
})
public class Guardian {
    // As the attribute names have been modified from the names in the DB,
    // We need to mab them back to the fields in the DB.
    // We can do that using AttributeOverrrides.
    private String name;
    private String email;
    private String mobile;
}
