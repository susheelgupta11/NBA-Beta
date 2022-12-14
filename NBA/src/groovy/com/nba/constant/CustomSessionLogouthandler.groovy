/*
* Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nba.constant

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;
import org.springframework.security.core.session.SessionRegistry;

/**
 * {@link CustomSessionLogoutHandler} is in charge of removing the {@link SessionRegistry} upon logout. A
 * new {@link SessionRegistry} will then be generated by the framework upon the next request.
 *
 * @author Mohd Qusyairi
 * @since 0.1
 */
public final class CustomSessionLogoutHandler implements LogoutHandler {
    private final SessionRegistry sessionRegistry;

    /**
     * Creates a new instance
     * @param sessionRegistry the {@link SessionRegistry} to use
     */
    public CustomSessionLogoutHandler(SessionRegistry sessionRegistry) {
        Assert.notNull(sessionRegistry, "sessionRegistry cannot be null");
        this.sessionRegistry = sessionRegistry;
    }

    /**
     * Clears the {@link SessionRegistry}
     *
     * @see org.springframework.security.web.authentication.logout.LogoutHandler#logout(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    public void logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        this.sessionRegistry.removeSessionInformation(request.getSession().getId());
    }
}