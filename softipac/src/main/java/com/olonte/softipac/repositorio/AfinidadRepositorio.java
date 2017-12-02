package com.olonte.softipac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.olonte.softipac.modelo.Afinidad;

@Repository
public interface AfinidadRepositorio extends JpaRepository<Afinidad, Integer>, QueryDslPredicateExecutor<Afinidad> {

}
