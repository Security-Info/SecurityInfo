package edu.escuelaing.security.utils;

public interface Constants {
    String COOKIE_NAME = "securityInfo-JWT";

    String CLAIMS_ROLES_KEY = "securityInfo_roles";

    int TOKEN_DURATION_MINUTES = 1440;

    String ADMIN_ROLE = "ADMIN";
    String USER_ROLE = "USER";
}
