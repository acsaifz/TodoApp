package hu.acsaifz.todoapp.config;

import hu.acsaifz.todoapp.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {
    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        User principal = new User();
        principal.setUsername(customUser.username());
        principal.setPassword(customUser.password());

        Authentication authentication =
                UsernamePasswordAuthenticationToken.authenticated(principal, customUser.password(), principal.getAuthorities());

        context.setAuthentication(authentication);

        return context;
    }
}
