/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rs.dao.impl;

import com.bk.rs.dao.CourseDAO;
import com.bk.rs.entity.Course;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 9:12:11 AM
 */
public class CourseDAOImpl implements CourseDAO {
    
    ArrayList<Course> courseList;

    public CourseDAOImpl() {
        courseList = new ArrayList<>();
       
    }

    
    @Override
    public void add(Course course) {
        courseList.add(course);
        
    }
    

}
