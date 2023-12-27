package com.xjgv.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/tarea1")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        String fechaFormateada = fechaActual.format(formateador);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("     <head>");
        out.println("         <meta charset=\" UTF-8\">");
        out.println("         <title></title>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("         <h1>Conexion al servlet exitosa ! </h1>");
        if(nombre!=null&apellido!=null){
            out.println("         <h1>Nombre : " + nombre + "</h1>");
            out.println("         <h1>Apellido : " + apellido + "</h1>");
        } else {
            out.println("         <h1>No se pasaron datos por el get !</h1>");
        }
        out.println("         <h1>Fecha Actual : " + fechaFormateada + "</h1>");
        out.println("     </body>");
        out.println("</html>");
        out.close();
    }
}
