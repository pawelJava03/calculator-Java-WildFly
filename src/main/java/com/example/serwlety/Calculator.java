package com.example.serwlety;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("""
   			 <!DOCTYPE html>
   			 <html>
   				 <head>
   				 <title>Calculator</title>
   				 <link rel="stylesheet" href="style.css">
   			 </head>
   			 <body>
   					 <h1>Servlet calculator</h1>
   	 """);

        out.println("""
   			 <form>
                	<input name="num1" type="text">
                	<select name="operation">
                    	<option value='+'>+</option>
                    	<option value='-'>-</option>
                    	<option value='*'>*</option>
                    	<option value='/'>/</option>
                	</select>
                	<input name="num2" type="text">
                	<br/>
                	<button>Execute</button>
   			 </form>
   			 """);

        String arg1 = request.getParameter("num1");
        String arg2 = request.getParameter("num2");
        String mathOperation = request.getParameter("math operation");

        if(arg1 != null && arg2 != null) {
            long num1 = Long.parseLong(arg1);
            long num2 = Long.parseLong(arg2);
            long sum = oblicz(num2, num2, mathOperation);
            out.print("<div>Result: " + sum + "</div>");
        }

        out.println("</body></html>");
    }


    //math operations
    private long oblicz(long num1, long num2, String operation) {
        return switch(operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}


