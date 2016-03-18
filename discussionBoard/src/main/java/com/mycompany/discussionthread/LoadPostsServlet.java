package com.mycompany.discussionthread;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hyung-jun An
 */
@WebServlet(urlPatterns = {"/LoadPostsServlet"})
public class LoadPostsServlet extends HttpServlet {

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

        BufferedReader br;
        String sCurrentLine;
        String path = System.getenv("OPENSHIFT_DATA_DIR")  + "posts.txt";
        br = new BufferedReader(new FileReader(path));
        
        List<Post> postArray = new ArrayList<>();
        
        while ((sCurrentLine = br.readLine()) != null) {
            String content = br.readLine();
            String username = br.readLine();
            
            Post post = new Post(content, username, sCurrentLine);
                    
            System.out.println("content: " + content);
            System.out.println("uername: " + username);
            System.out.println("time: " + sCurrentLine);
            postArray.add(post); 
        }
        
        System.out.println(postArray.size());
        
        if (br != null)
            br.close();
     Iterator itr = postArray.iterator();
 
   System.out.println("Iterating through ArrayList elements...");


         while(itr.hasNext())
              System.out.println(itr.next());
Collections.reverse(postArray);
 
        request.setAttribute("postArray", postArray);
        request.getRequestDispatcher("view_posts.jsp").forward(request, response);
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
        return "Short description";
    }// </editor-fold>

}
