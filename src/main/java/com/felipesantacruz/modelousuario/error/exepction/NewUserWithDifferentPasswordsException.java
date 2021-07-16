package com.felipesantacruz.modelousuario.error.exepction;

public class NewUserWithDifferentPasswordsException extends RuntimeException
{
	private static final long serialVersionUID = -7978601526802035152L;

	public NewUserWithDifferentPasswordsException() 
	{
		super("Passwords doesn't match");
	}
}
