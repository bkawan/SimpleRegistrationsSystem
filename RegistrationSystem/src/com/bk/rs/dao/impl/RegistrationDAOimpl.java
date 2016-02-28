/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rs.dao.impl;

import com.bk.rs.dao.RegistrationDAO;
import com.bk.rs.entity.Person;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 27, 2016
 * @time 5:41:19 PM
 */
// this class implements all the methods in  RegistrationDAO interface 
public class RegistrationDAOimpl implements RegistrationDAO {

    // 1. to store all the registered person 
    private ArrayList<Person> personList;

    public RegistrationDAOimpl() {
        //2. Every time this class is called
        //instantiate new object of ArrayList Person
        personList = new ArrayList<>();

    }

    @Override
    public void register(Person person) {
        // 3. Store all the registered person in the personList ArrayList personList
        personList.add(person);
    }

    @Override
    public boolean delete(int id) {

        boolean hasDelete = false;
        //first loop throuth the personlList
        for (Person person : personList) {
            //check for id of person object
            if (person.getId() == id) {
                // if matched  remove person object
                personList.remove(person);
                System.out.println(person.getFirstName() + " " + person.getLastName() + " has been sucessfully deleted:");
                hasDelete = true;
                break;
            }

        }
        return true;

    }

    @Override
    public Person findByID(int id) {
        // loop through the personlList
        for (Person person : personList) {
            //check for person id 
            if (person.getId() == id) {
                // retrun person object if found
                return person;
            }
        }
        return null;
    }

    @Override

    public ArrayList<Person> findAll() {

        // just return arraylist collection and will procces according to needs
        return personList;
    }

    @Override
    public ArrayList<Person> findByString(String param) {
        // first create new arraylist object to store the search result
        ArrayList<Person> persons = new ArrayList<>();
        // loopthourgh the personList Container
        for (Person person : personList) {
            String firstName = person.getFirstName().toLowerCase();
            String LastName = person.getLastName().toLowerCase();
            String email = person.getEmail().toLowerCase();

            param = param.toLowerCase();

            if (firstName.contains(param) || LastName.contains(param) || email.contains(param)) {
                persons.add(person);

            }
        }
        if (persons.isEmpty()) {
            System.out.println("No Match found");
        }
        return persons;

    }

    public int count() {

        return personList.size();
    }

    @Override
    public void deleteAll() {
        boolean deleteAll = false;
        personList.clear();
    }

    @Override
    public ArrayList<Person> findAllTeachers() {

        ArrayList<Person> teachers = new ArrayList<>();

        for (Person teacher : personList) {
            if (teacher.getPersonType().contains("Teacher")) {

                teachers.add(teacher);

            }

        }
        System.out.println("Total Number of Teachers :" + teachers.size());

        System.out.println("--------------------------------");

        return teachers;
    }

    @Override
    public ArrayList<Person> findAllStudents() {
        ArrayList<Person> students = new ArrayList<>();

        for (Person student : personList) {
            if (student.getPersonType().contains("Student")) {

                students.add(student);

            }

        }
        System.out.println("Total Number of Students :" + students.size());
        System.out.println("--------------------------------");
        return students;

    }
}
