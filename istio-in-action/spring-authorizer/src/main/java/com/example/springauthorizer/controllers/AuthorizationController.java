package com.example.springauthorizer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

//@RestController
public class AuthorizationController {
//    @RequestMapping(path = {"/**", "/"})
    public void authorizeAnything(HttpServletRequest request, HttpServletResponse response) throws Exception {
        printEverythingAndAllow(request, response);
    }

    private static void printEverythingAndAllow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("***********URI*************");
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getPathInfo());

        // TODO matching implementation
        // TODO dividing configurations
        // Centralized authorization, why?
        // Within the next three months we won't control the external teams e.g. Ayman
        // However, there will be integration between the teams
        // We participate in the same transaction
        // 1. Different authorization policies between teams -> PO? Roles?
        // 2. Token size -> Cookie gets ignored ()
        // 3. More privileges would require restructuring to make token smaller
        // 4. Scattered ABAC (wont be solved by RBAC)

        System.out.println("*******HEADERS************\n");
        request.getHeaderNames().asIterator().forEachRemaining(h -> {
            System.out.println(h + ": " + request.getHeader(h));
        });

        String requestData = request.getReader().lines().collect(Collectors.joining());
        System.out.println("*******BODY************\n");
        System.out.println(requestData);

        response.setHeader("x-ext-authz-check-result", "allowed"); // or denied
        response.flushBuffer();
    }

//    @GetMapping("/subsidies/{id}")
    public void getSubsidy(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        printEverythingAndAllow(request, response);
        // decoded JWT -> privileges
        // response -> to write a header (utility  method)
    }
}
