package com.ovi.app.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ovi.app.payload.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    private final ObjectMapper objectMapper;

    public CustomAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc)
            throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            logger.warn("User: {} attempted to access the protected URL: {}",
                    auth.getName(), request.getRequestURI());
        }
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        ResponseBody responseBody = new ResponseBody();
        responseBody.setSuccess(false);
        responseBody.setMessage("Access Denied.");

        final Map<String, Object> data = new HashMap<>();
        data.put("status", HttpServletResponse.SC_FORBIDDEN);
        data.put("error", "Access Denied");
        data.put("message", exc.getMessage());
        data.put("path", request.getServletPath());

        responseBody.setData(data);

        objectMapper.writeValue(response.getOutputStream(), responseBody);
    }
}