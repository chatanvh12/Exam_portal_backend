package com.exam.Examserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.Examserver.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
