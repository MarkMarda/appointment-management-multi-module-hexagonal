package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E, ID> extends JpaRepository<E, ID> {
}
