package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
