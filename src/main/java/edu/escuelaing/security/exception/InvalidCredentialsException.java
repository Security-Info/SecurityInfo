package edu.escuelaing.security.exception;

import edu.escuelaing.security.exception.error.ErrorCodeEnum;
import edu.escuelaing.security.exception.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}