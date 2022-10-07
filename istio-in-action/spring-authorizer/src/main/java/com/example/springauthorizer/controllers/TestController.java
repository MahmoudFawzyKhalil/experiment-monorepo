package com.example.springauthorizer.controllers;

import org.springframework.http.server.PathContainer;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.RequestMatchResult;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.ServletRequestPathUtils;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
//    @GetMapping("/hello/{id}")
    public void hello(@PathVariable Long id) {
        System.out.println("Hello: " + id);
    }

//    @RequestMapping({"/**"})
    public void test(HttpServletRequest request){
        printPathStuff(request);

    }

    public static void printPathStuff(HttpServletRequest request) {
        //        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();

        // Rule

        // url pattern -> from request, match
        // method -> from request
        // roles/privileges, send authorization header

        // yaml -> application.yaml + ConfigurationProperties


        PathPatternParser ppp = PathPatternParser.defaultInstance;
        PathPattern pathPattern = ppp.parse("/hello/{id}");
        RequestPath requestPath = ServletRequestPathUtils.parseAndCache(request);
        PathContainer pathContainer = requestPath.pathWithinApplication();

        System.out.println("PathPattern: " + pathPattern);
        System.out.println("RequestPath: " + requestPath);
        System.out.println("PathContainer: " + pathContainer);

        System.out.println("ServletRequest ContextPath:" + request.getContextPath());
        System.out.println("ServletRequest ServletPath:" + request.getServletPath());
        System.out.println("ServletRequest PathInfo:" + request.getPathInfo());

        var requestMatchResult = pathPattern.matches(pathContainer) ? new RequestMatchResult(pathPattern, pathContainer) : null;
        System.out.println("Path Variables: " + requestMatchResult.extractUriTemplateVariables());
        String method = request.getMethod(); // Istio sends the method
    }
}
