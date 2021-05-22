/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ajay
 */
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h2>Welcome to Register Servlet</h2>");
        
        String user_name = req.getParameter("user_name");
        String user_pwd = req.getParameter("user_pwd");
        String user_email = req.getParameter("user_email");
        String user_gender = req.getParameter("user_gender");
        String user_course = req.getParameter("user_course");
        
        String condition = req.getParameter("condition");
        if(condition != null && condition.equals("checked")){
            out.print("<h3>UserName: "+user_name+"</h3>");
            out.print("<h3>Password: "+user_pwd+"</h3>");
            out.print("<h3>Email: "+user_email+"</h3>");
            out.print("<h3>Gender: "+user_gender+"</h3>");
            out.print("<h3>Course: "+user_course+"</h3>");
            
            //Do databse operations here
            
            RequestDispatcher rd = req.getRequestDispatcher("success");
            rd.forward(req, resp);
            
        }else{
            out.print("<h3>You have not accepted the terms and condition</h3>");
            
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
