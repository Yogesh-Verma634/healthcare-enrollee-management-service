package com.healthcare.personal.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Enrollee {

    @Id
    @Column(name = "enrollee_id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "activation_status")
    public Boolean activationStatus;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "created_at")
    @CreationTimestamp
    @NotNull
    public LocalDateTime createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    public LocalDateTime modifiedAt;
}
