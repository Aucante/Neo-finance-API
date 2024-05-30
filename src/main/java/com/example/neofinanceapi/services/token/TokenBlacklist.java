package com.example.neofinanceapi.services.token;

import jakarta.servlet.http.HttpServletRequest;

public interface TokenBlacklist {

    void addToBlacklist(String token);

    boolean isBlacklisted(String token);

    void addBlacklistTokenList(HttpServletRequest request);

    String extractTokenFromRequest(HttpServletRequest request);

}
