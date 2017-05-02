/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Employee;
import entity.EmployeeSkill;
import entity.Skill;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.EmployeeFacade;
import session.EmployeeSkillFacade;
import session.SkillFacade;

/**
 *
 * @author tgiunipero
 */
@WebServlet(name = "Controller",
            loadOnStartup = 1,
            urlPatterns = {"/summary",
                            "/employee"})
public class ControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private SkillFacade skillFacade;
    @EJB
    private EmployeeFacade employeeFacade;
    @EJB
    private EmployeeSkillFacade esFacade;
    
    private String name = "";
    private String[] skills = new String[999];
    private String[] e = new String[999];
    
    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("skills", skillFacade.findAll());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        
        if (userPath.equals("/summary")) {

        } else if (userPath.equals("/employee")){
            
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/summary")) {
            NumberFormat formatter = new DecimalFormat("#0.00");
            double budget = 0;
            double hours = Double.parseDouble(request.getParameter("hours"));
            List<EmployeeSkill> es = esFacade.findAll();
            e = request.getParameterValues("employeeList");
            List<Employee> em = new ArrayList<Employee>();
            for(int i = 0; i < e.length; ++i){
                em.add(employeeFacade.find(Integer.parseInt(e[i])));
            }
            List<Skill> sks = new ArrayList<Skill>();
            for(int i = 0; i < skills.length; ++i){
                sks.add(skillFacade.find(Integer.parseInt(skills[i])));
            }
            for(int i = 0; i < em.size(); ++i){
                double rate = 0;
                for(int j = 0; j < es.size(); ++j){
                    if(es.get(j).getEdi() == em.get(i).getEid()){
                        if(skillFacade.find(es.get(j).getSid()).getRate() > rate){
                            rate = skillFacade.find(es.get(j).getSid()).getRate();
                        }
                    }
                }
                budget += (hours * (double)em.get(i).getSalary() * rate);
            }
            budget += ((budget * 30) / 100);
            getServletContext().setAttribute("project_name", name);
            getServletContext().setAttribute("skills", sks);
            getServletContext().setAttribute("employees", em);
            getServletContext().setAttribute("hours", hours);
            getServletContext().setAttribute("budget", formatter.format(budget));
            
        } else if (userPath.equals("/employee")){
            name = request.getParameter("pname");
            skills = request.getParameterValues("skillList");
            List<EmployeeSkill> es = esFacade.findAll();
            List<Integer> employees = new ArrayList<Integer>();
            for(int i = 0; i < es.size(); ++i){
                for(int j = 0; j < skills.length; ++j){
                    if(es.get(i).getSid() == Integer.parseInt(skills[j])){
                        employees.add(es.get(i).getEdi());
                    }
                }
            }
            List<Employee> em = new ArrayList<Employee>();
            for(int i = 0; i < employees.size(); ++i){
                em.add(employeeFacade.find(employees.get(i)));
            }
            getServletContext().setAttribute("project_name", name);
            getServletContext().setAttribute("employees", em);
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}