package edu.escuelaing.security.exception;

import edu.escuelaing.security.exception.error.InternalServerErrorException;
import edu.escuelaing.security.exception.error.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class UserNotFoundException
    extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
               HttpStatus.NOT_FOUND );
    }
}
