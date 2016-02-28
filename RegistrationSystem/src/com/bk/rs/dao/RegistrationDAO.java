/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rs.dao;

import com.bk.rs.entity.Person;
import com.bk.rs.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 27, 2016
 * @time 5:34:21 PM
 */
// interface to acess person object
public interface RegistrationDAO {
    
    void register(Person person);
    boolean delete(int id);
    Person findByID(int id);
    ArrayList<Person> findAll();
    ArrayList<Person> findByString(String param);
    void deleteAll();
    ArrayList<Person> findAllTeachers();
        ArrayList<Person> findAllStudents();


}
