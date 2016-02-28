/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rs.view;

import com.bk.rs.dao.CourseDAO;
import com.bk.rs.dao.impl.CourseDAOImpl;
import com.bk.rs.entity.Course;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 8:59:16 AM
 */
public class CourseView {

    private int cid = 100;
    private int rid = 1;
    private Scanner input;
    private CourseDAO courseDAO;

    public CourseView() {
    }

    public CourseView(Scanner input, CourseDAO courseDAO) {
        this.input = input;
        this.courseDAO = new CourseDAOImpl();

    }

    public void courseController() {

        
        

        Course c = new Course();
        c.setrID(rid++);

        boolean addCourse = true;
        while (true) {
            courseMenu();
            switch (input.nextInt()) {

                case 1:
                    c.setcID(cid++);
                    c.setCourseTitle("Core Java");
                    c.setCourseDesc("This is core java");
                    courseDAO.add(c);
                    System.out.println("Sucessfully added Core Java");

                    break;
                case 2:
                    c.setcID(cid++);
                    c.setCourseTitle("Advance Java");
                    c.setCourseDesc("This is Advance Java");
                    courseDAO.add(c);
                    System.out.println("Sucessfully added Advance Java");
                    break;
                case 3:
                    c.setcID(cid++);
                    c.setCourseTitle("Python Essential");
                    c.setCourseDesc("This is Python Essential");
                    courseDAO.add(c);
                    System.out.println("Sucessfully added Python Essential");
                    break;
                case 4:
                    c.setcID(cid++);
                    c.setCourseTitle("Php Essential");
                    c.setCourseDesc("This is php Essential ");
                    courseDAO.add(c);
                    System.out.println("Sucessfully added Php essential");
                    break;
               

            }
            System.out.println("Do you want to add more course[Y/N]: ?");
            if(input.next().equalsIgnoreCase("n")){
                addCourse = false;
                break;
            }
            
            if(!addCourse){
                break;
            }
            
        }

    }

    public void courseMenu() {

       
        System.out.println("++++++ [[[[ Course List Below]]]]++++++");
        
        System.out.println("[1]. Core Java :");
        System.out.println("[2]. Advance Java");
        System.out.println("[3]. Python Essential ");
        System.out.println("[4]. php Essential ");
       
        System.out.println("======================================================");
        System.out.println("Select the option between [1-4] :");
        }
    

}
