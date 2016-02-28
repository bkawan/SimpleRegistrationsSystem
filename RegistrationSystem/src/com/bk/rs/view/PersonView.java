/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rs.view;

import com.bk.rs.dao.CourseDAO;
import com.bk.rs.dao.RegistrationDAO;
import com.bk.rs.dao.impl.CourseDAOImpl;
import com.bk.rs.entity.Person;
import com.bk.rs.entity.Student;
import com.bk.rs.entity.Teacher;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 12:03:19 AM
 */
public class PersonView {
     public  int id = 1;

    private Scanner input;
    private RegistrationDAO regDAO;
    private CourseView cv;
    private CourseDAO courseDAO;

    public PersonView(Scanner input, RegistrationDAO regDAO) {
        this.input = input;
        this.regDAO = regDAO;
        cv = new CourseView(input, courseDAO);
        courseDAO = new CourseDAOImpl();
    }

    public void controller() {

        regMenu();

        switch (input.nextInt()) {

            case 1:
                registerStudent();
                break;

            case 2:
                registerTeacher();
                break;
            case 3:
                findByID();

                break;
            case 4:
                deleteByID();
                break;

            case 5:
                search();

                break;

            case 6:
                findAll();

                break;
            case 7:
                deleteAll();

                break;
            case 8:
                findAllStudents();
                break;
            case 9:
                findAllTeacher();
                break;
            case 10:
                System.out.println("Exit [Y/N]?");

                if (input.next().equalsIgnoreCase("y")) {
                    System.exit(0);
                }

                break;
        }

    }

    public void registerStudent() {

        boolean addCourse = false;

        while (true) {

            System.out.println("********* Registration For Student **********");
            //Register Student
            // instantiate Studnet object
            // set all the student object setter from user unput 
            Person student = new Student();
//                        System.out.println("Enter ID: ");
            student.setId(id++);
            student.setPersonType("Student");
            System.out.println("Enter First Name: ");
            student.setFirstName(input.next());

            System.out.println("Enter Last Name");
            student.setLastName(input.next());
            System.out.println("Enter Email Address: ");
            student.setEmail(input.next());
            System.out.println("Enter Phone Number: ");
            student.setPhoneNo(input.next());
            System.out.println("Enter Address: ");
            student.setAddress(input.next());

            System.out.println("Do you want to add course: [Y/N]: ?");
            if (input.next().equalsIgnoreCase("Y")) {
                cv.courseController();
            }
            // add the student object in collecion
            regDAO.register(student);
            System.out.println("Do you want to add more student[Y/N]?:]");
            if (input.next().equalsIgnoreCase("n")) {

                break;
            }
        }

    }

    public void findByID() {

        System.out.println("*********************************");
        System.out.println("**** [ Serching Record by ID ] ****");
        System.out.println("*********************************");
        while (true) {

            System.out.println("Enter Registration ID to Search Record.... ");
            //search person with input id passed and store as a variable
            Person person = regDAO.findByID(input.nextInt());
            // if person object is not  0 or null get the values of the object
            System.out.println("Search Result for recort [" + person.getId() + "]");
            System.out.println("---------------------------");

            if (person != null) {

                person.personDetails();
            } else {
                System.out.println("No Records found for the ID you have Entered");
            }
            System.out.println("Do you want to Search More...[Y/N] ?");
            if (input.next().equalsIgnoreCase("N")) {
                break;// get out from while
            }

        }
    }

    public void search() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("**** [ Serach Record.. ] ****");
            System.out.println("*********************************");
            System.out.println("Enter name/address/email etc to search...");

            String param = input.next();
            System.out.println("-----------------------------------");

            System.out.println("Search Results for [" + param + "] below.... ");
            System.out.println("-----------------------------------");

            regDAO.findByString(param).forEach(results -> {

                results.personDetails();

            });
            System.out.println("Do you want to Search More[Y/N]?");

            if (input.next().equalsIgnoreCase("n")) {

                break;
            }
        }
    }

    public void deleteByID() {

        while (true) {
            System.out.println("*********************************");
            System.out.println("**** [ Delete Record by ID ] ****");
            System.out.println("*********************************");
            System.out.println("Enter ID to Delete Record from Database: ");
            regDAO.delete(input.nextInt());

            System.out.println("----Delete Successfull-----");
            System.out.println("Do you want to delete more......[Y/N]?");
            if (input.next().equalsIgnoreCase("n")) {
                break;

            }
        }
    }

    public void deleteAll() {
        System.out.println("Do you want to Delete All Records[Y/N]? ");
        if (input.next().equalsIgnoreCase("y")) {
            regDAO.deleteAll();
            System.out.println("---------------------------");

            System.out.println("Sucessfully Deleted all the Records");
        }
        System.out.println("---------------------------");

    }

    public void count() {
        System.out.println("Total number of of Registration:  " + regDAO.findAll().size());

    }

    public void findAll() {
        System.out.println("*********************************");
        System.out.println("**** [ Listing all the records ]:****");
        System.out.println("*********************************");
        System.out.println("There are total records of " + regDAO.findAll().size() + " registration found");
        System.out.println("---------------------------");

        //p denotes to each person object found from the records
        regDAO.findAll().forEach(p -> {
            p.personDetails();

        });
    }

    public void findAllTeacher() {
        System.out.println("*********************************");
        System.out.println("**** [ Listing all the Teachers recordss ]:****");
        System.out.println("*********************************");

        //t denotes to each teacher object found from the records
        regDAO.findAllTeachers().forEach(t -> {
            t.personDetails();

        });

    }

    public void findAllStudents() {
        System.out.println("*********************************");
        System.out.println("**** [ Listing all the Students recordss ]:****");
        System.out.println("*********************************");

        //s denotes to each student object found from the records
        regDAO.findAllStudents().forEach(s -> {
            s.personDetails();

        });

    }

    private void registerTeacher() {

        while (true) {
            System.out.println("**** Registration for Teacher ****");
            Person teacher = new Teacher();
            teacher.setId(id++);
            teacher.setPersonType("Teacher");
            System.out.println("Enter First Name: ");
            teacher.setFirstName(input.next());

            System.out.println("Enter Last Name");
            teacher.setLastName(input.next());
            System.out.println("Enter Email Address: ");
            teacher.setEmail(input.next());
            System.out.println("Enter Phone Number: ");
            teacher.setPhoneNo(input.next());
            System.out.println("Enter Address: ");
            teacher.setAddress(input.next());

              System.out.println("Do you want to add course: [Y/N]: ?");
            if (input.next().equalsIgnoreCase("Y")) {
                cv.courseController();
            }
            regDAO.register(teacher);
            System.out.println("Do you want to add more Teacher[Y/N]?:]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void regMenu() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++ [[[[ Welcome to Registration Manager]]]]++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("[1]. Register Student");
        System.out.println("[2]. Register Facilitator");
        System.out.println("[3]. Search Record by ID: ");
        System.out.println("[4]. Delete Record by ID: ");
        System.out.println("[5]. Search Record: ");
        System.out.println("[6]. Find All Record:");
        System.out.println("[7]. Delete All Record");
        System.out.println("[8]. List all Students: ");

        System.out.println("[9]. List all Teachers: ");

        System.out.println("[10]. Exit: ");

        System.out.println("======================================================");
        System.out.println("Select the option between [1-8] :");

    }
}
