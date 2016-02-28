/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rs.entity;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 9:04:27 AM
 */
public class Course {

    private int cID, rID;
    private String courseTitle, courseDesc;

    public Course() {
    }

    public Course(int cID, int rID, String courseTitle, String courseDesc) {
        this.cID = cID;
        this.rID = rID;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" + "cID=" + cID + ", rID=" + rID + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc + '}';
    }
    
    public void myCourse(){
        System.out.println("Your Course: " + courseTitle);
    }
    
}
