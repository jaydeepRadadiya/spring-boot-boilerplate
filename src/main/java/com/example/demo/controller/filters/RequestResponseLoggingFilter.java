//package com.example.demo.controller.filters;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.micrometer.core.instrument.util.IOUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
//import java.time.Duration;
//import java.time.Instant;
//
//@Component
//@Order(2)
//@Slf4j
//public class RequestResponseLoggingFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest ;
//        HttpServletResponse res =  (HttpServletResponse) servletResponse ;
//        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(req);
//        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(res);
//
//        log.info(
//                "STARTED PROCESSING : METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={};", req.getMethod(),
//                req.getRequestURI(), "IOUtils.toString(req.getInputStream())");
//
//        long startTime = System.currentTimeMillis();
//        filterChain.doFilter(requestWrapper, responseWrapper);
//        long timeTaken = System.currentTimeMillis() - startTime;
//
//        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
//                req.getCharacterEncoding());
//        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),
//                res.getCharacterEncoding());
//
//        log.info(
//                "FINISHED PROCESSING : METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIM TAKEN={} ms",
//                req.getMethod(), req.getRequestURI(), requestBody, res.getStatus(), responseBody,
//                timeTaken);
//
//        responseWrapper.copyBodyToResponse();
//
//    }
//
//    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
//        try {
//            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
