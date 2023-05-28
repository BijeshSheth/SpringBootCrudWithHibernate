package com.sheth.SpringBootCrudWithHibernate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee1")
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "firstName1")
    //@JsonProperty("first_name")
    private String firstName;

    @Column(name = "lastName1")
    //@JsonProperty("last_name")
    private String lastName;

}
