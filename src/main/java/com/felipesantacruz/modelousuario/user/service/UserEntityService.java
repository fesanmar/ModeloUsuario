package com.felipesantacruz.modelousuario.user.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.felipesantacruz.modelousuario.error.exepction.NewUserWithDifferentPasswordsException;
import com.felipesantacruz.modelousuario.user.dto.CreateUserDto;
import com.felipesantacruz.modelousuario.user.dto.GetUserDto;
import com.felipesantacruz.modelousuario.user.dto.UserDtoConverter;
import com.felipesantacruz.modelousuario.user.model.UserEntity;
import com.felipesantacruz.modelousuario.user.model.UserRole;
import com.felipesantacruz.modelousuario.user.repo.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository>
{
	private final PasswordEncoder passwordEncoder;
	private final UserDtoConverter userDtoConverter;
	
	public Optional<UserEntity> findByUsername(String username)
	{
		return repository.findByUsername(username);
	}
	
	public GetUserDto newUser(CreateUserDto createUserDto)
	{
		if (createUserDto.getPassword().contentEquals(createUserDto.getPassword2()))
		{
			return userDtoConverter.toGetUserDto(
					save(UserEntity
					.builder()
					.username(createUserDto.getUsername())
					.password(passwordEncoder.encode(createUserDto.getPassword()))
					.avatar(createUserDto.getAvatar())
					.roles(Stream.of(UserRole.USER).collect(Collectors.toSet()))
					.build()));			
		} 
		else
		{
			throw new NewUserWithDifferentPasswordsException();
		}
	}
}
