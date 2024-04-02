package com.example.Request;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER = "PinggyAuthHeader";
    private static final ThreadLocal<String> AUTH_TOKEN = new ThreadLocal<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authToken = request.getHeader(AUTH_HEADER);
        
        if (StringUtils.hasText(authToken)) {
            AUTH_TOKEN.set(authToken);
            filterChain.doFilter(request, response); // Proceed with the request
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            
            // Create a map to hold the response data
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("timestamp", "2024-04-02T11:47:46.816+00:00");
            responseBody.put("status", HttpStatus.UNAUTHORIZED.value());
            responseBody.put("error", "Unauthorized");
            responseBody.put("path", request.getRequestURI());
            
            // Convert the map to a JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(responseBody);
            
            // Write the JSON response to the response body line by line
            response.getWriter().write("{\n");
            response.getWriter().write("\"timestamp\": \"" + responseBody.get("timestamp") + "\",\n");
            response.getWriter().write("\"status\": " + responseBody.get("status") + ",\n");
            response.getWriter().write("\"error\": \"" + responseBody.get("error") + "\",\n");
            response.getWriter().write("\"path\": \"" + responseBody.get("path") + "\"\n");
            response.getWriter().write("}\n");
            
            response.getWriter().flush();
        }
    }

    public static String getCurrentAuthToken() {
        return AUTH_TOKEN.get();
    }

    public static void clearAuthToken() {
        AUTH_TOKEN.remove();
    }
}
