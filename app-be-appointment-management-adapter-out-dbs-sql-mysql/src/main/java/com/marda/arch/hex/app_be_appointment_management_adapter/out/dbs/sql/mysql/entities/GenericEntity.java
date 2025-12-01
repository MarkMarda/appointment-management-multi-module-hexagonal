package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//Not Table in DB
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class GenericEntity {
    @Column(name = "state_register", nullable = false)
    protected Integer estateRegister; // 0: deleted, 1:active

    //Audit fields
}
