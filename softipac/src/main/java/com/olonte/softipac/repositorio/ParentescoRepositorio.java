package com.olonte.softipac.repositorio;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.olonte.softipac.modelo.Parentesco;

@Repository
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public interface ParentescoRepositorio extends JpaRepository<Parentesco, Integer>, QueryDslPredicateExecutor<Parentesco> {

}
