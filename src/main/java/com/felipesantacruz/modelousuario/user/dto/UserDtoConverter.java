package com.felipesantacruz.modelousuario.user.dto;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.felipesantacruz.modelousuario.user.model.UserEntity;
import com.felipesantacruz.modelousuario.user.model.UserRole;

@Component
public class UserDtoConverter
{	
	public GetUserDto toGetUserDto(UserEntity userEntity)
	{
		return GetUserDto
				.builder()
				.username(userEntity.getUsername())
				.avatar(userEntity.getAvatar())
				.roles(rolesAsString(userEntity))
				.build();
				
	}

	private Set<String> rolesAsString(UserEntity userEntity)
	{
		return userEntity.getRoles()
				.stream()
				.map(UserRole::name)
				.collect(Collectors.toSet());
	}
	
}
