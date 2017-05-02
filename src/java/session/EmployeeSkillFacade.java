/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.EmployeeSkill;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SONY
 */
@Stateless
public class EmployeeSkillFacade extends AbstractFacade<EmployeeSkill> {

    @PersistenceContext(unitName = "BudgetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeSkillFacade() {
        super(EmployeeSkill.class);
    }
    
}
