package com.olonte.softipac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.olonte.softipac.modelo.Genero;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer>, QueryDslPredicateExecutor<Genero> {

}
