package com.felipesantacruz.modelousuario.user.controller;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipesantacruz.modelousuario.user.dto.CreateUserDto;
import com.felipesantacruz.modelousuario.user.dto.GetUserDto;
import com.felipesantacruz.modelousuario.user.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{
	private final UserEntityService userEntityService;
	
	@PostMapping("/")
	public ResponseEntity<GetUserDto> newUser(@Valid @RequestBody CreateUserDto newUserDto)
	{
		try
		{
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(userEntityService.newUser(newUserDto));			
		} catch (DataIntegrityViolationException ex) // If newUser already exist
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, newUserDto.getUsername().concat(" already exists."));
		}
	}
}
