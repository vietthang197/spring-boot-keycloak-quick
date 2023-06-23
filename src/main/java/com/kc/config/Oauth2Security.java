package com.kc.config;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("oauth2Security")
public class Oauth2Security  {

    public boolean hasResourcePermission(HttpServletRequest httpServletRequest, String resourceName, String scope) {
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        return authzContext.hasPermission(resourceName, scope);
    }
}
