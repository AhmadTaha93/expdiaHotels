/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expdia.expdiatask.controllers;

import com.expdia.expdiatask.beans.RequestSearchBean;
import com.expdia.expdiatask.jackson.RootJsonExpdia;
import com.expdia.expdiatask.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmad
 */
public class HandlerSearchHotels extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            Object next = attributeNames.nextElement();
            System.out.println("att : " + next);
        }

        System.out.println("com.expdia.expdiatask.controllers.HandlerSearchHotels.processRequest()");
        String url = "pages/error.jsp";
        try {
            RequestSearchBean beanRequest = Utils.getBeanRequest(request);
            String json = Utils.httpCall(Utils.getURLExpdia(beanRequest,Utils.URL_EXPDIA));
            ObjectMapper mapper = new ObjectMapper();
            RootJsonExpdia beanJsonExpdia = mapper.readValue(json, RootJsonExpdia.class);
            System.out.println("beanJsonExpdia : " + beanJsonExpdia);
            System.out.println("beanJsonExpdia.getOffers() : " + beanJsonExpdia.getOffers());
            
            if (!beanJsonExpdia.getAdditionalProperties().isEmpty()) {
                System.out.println("beanJsonExpdia : " + beanJsonExpdia);
                request.setAttribute("beanJsonExpdia", beanJsonExpdia);
                url = "pages/showdata.jsp";
            }
        } catch (IOException e) {
            System.out.println("IO Exc : " + e);
             url = "pages/error.jsp";
        } catch (ParseException ex) {
            System.out.println("ParseException : " + ex);
             url = "pages/error.jsp";
        }
        System.out.println("URL : " + url);

        getServletContext().getRequestDispatcher("/" + url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet handel search procceing in index.jsp first page ";
    }// </editor-fold>

}
