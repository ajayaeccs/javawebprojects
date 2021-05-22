/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cyntexia
 */
public class ThirdServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is doGet method");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1> This is doGet method of third servlet</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is doPost method");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1> This is doPost method of third servlet<h1>");
    }
    
}
