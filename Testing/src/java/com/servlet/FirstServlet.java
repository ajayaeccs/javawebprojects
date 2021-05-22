/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Cyntexia
 */
public class FirstServlet implements Servlet {
    private ServletConfig conf;
    
    @Override
    public void init(ServletConfig conf) throws ServletException {
        this.conf = conf;
        System.out.println("Initializing servlet object");
    }

    @Override
    public ServletConfig getServletConfig() {
        return conf;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("Servicing the first servlet");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> Response from first servlet</h1>");
        out.println("<h2> Todays date is:" + new Date().toString() + "</h2>");
        
    }

    @Override
    public String getServletInfo() {
        return "This is created by Ajay Srivastava";
    }

    @Override
    public void destroy() {
        System.out.println("Destroying the servlet object");
    }
    
}
