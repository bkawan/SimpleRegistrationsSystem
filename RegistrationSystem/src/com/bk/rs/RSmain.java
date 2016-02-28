/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rs;

import com.bk.rs.dao.CourseDAO;
import com.bk.rs.dao.RegistrationDAO;
import com.bk.rs.dao.impl.CourseDAOImpl;
import com.bk.rs.dao.impl.RegistrationDAOimpl;
import com.bk.rs.view.CourseView;

import com.bk.rs.view.PersonView;
import java.util.Scanner;

/**
 *
 * @author bikeshkawan
 */
public class RSmain {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // need to call RegistrationDAOimpl to call all the methods
        RegistrationDAO regDAO = new RegistrationDAOimpl();
        CourseDAO cDAO = new CourseDAOImpl();
        // need Scanner to get user input 
        Scanner input = new Scanner(System.in);

        PersonView pv = new PersonView(input, regDAO);
        // TODO code application logic here
        CourseView cv = new CourseView(input, cDAO);

        while (true) {
            pv.controller();

        }
    }

}
