package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.Device;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author manga
 */
@WebServlet(name = "GetData", urlPatterns = {"/GetData"})
public class GetData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        JsonObject jsonObject = new JsonObject();
        
        Device device = (Device) session.get(Device.class, 12345);
        jsonObject.addProperty("status", device.getStatus());
        
        device.setStatus(0);
        session.save(device);

        session.beginTransaction().commit();
        session.close();

        resp.setContentType("application/json");
        resp.getWriter().write(new Gson().toJson(jsonObject));

    }

}
