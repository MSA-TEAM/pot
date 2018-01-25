package kr.co.sicc.gsp.svm.sicc.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())); {
//            // CORS "pre-flight" request
//            response.addHeader("Access-Control-Allow-Methods", "GET, POST");
//            response.addHeader("Access-Control-Allow-Headers", "Authorization");
//            response.addHeader("Access-Control-Max-Age", "1728000");
//        }
//    	if(request.getHeader("Content-Type") != null && request.getHeader("Content-Type").indexOf("multipart/form-data") > -1)
//    		response.setHeader("Content-Type", "application/json;charset=UTF-8");
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Expose-Headers", "x-requested-with"); 
        response.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(request, response);
    }

}