package com.healthcare.personal.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "enrollee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Enrollee {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "activation_status")
    public Boolean activationStatus;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @Column(name = "phone_number")
    public String phoneNumber;
}
