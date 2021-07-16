package com.felipesantacruz.modelousuario.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesantacruz.modelousuario.user.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>
{
	Optional<UserEntity> findByUsername(String username);
	
}
