package com.olonte.softipac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.olonte.softipac.modelo.Diagnostico;

@Repository
public interface DiagnosticoRepositorio extends JpaRepository<Diagnostico, Integer>, QueryDslPredicateExecutor<Diagnostico> {

}
