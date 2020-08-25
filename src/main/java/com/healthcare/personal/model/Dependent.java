package com.healthcare.personal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dependent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dependent {
    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "dependent_enrollee_id")
    public Enrollee dependentEnrolleeId;
}
