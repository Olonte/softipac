package com.olonte.softipac.repositorio;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.olonte.softipac.modelo.Cita;

@Repository
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public interface CitaRepositorio extends JpaRepository<Cita, Integer>, QueryDslPredicateExecutor<Cita> {
}
