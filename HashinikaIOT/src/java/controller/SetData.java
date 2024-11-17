/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Device;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author manga
 */
@WebServlet(name = "SetData", urlPatterns = {"/SetData"})
public class SetData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        Device device = (Device) session.get(Device.class, 12345);
        device.setStatus(1);
        
        session.save(device);        
        session.beginTransaction().commit();
        session.close();

    }

}