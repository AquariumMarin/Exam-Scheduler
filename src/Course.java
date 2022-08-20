//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Course.java
// Course: CS 300 Spring 2022
//
// Author: Marin Suzuki
// Email: msuzuki9@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Xingzhen Cai
// Partner Email: xcai79@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class manages the name, the number of students of the course.
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class Course {

  private String name; // the name of the course,e.g.“CS300”
  private int numStudents; // the number of students enrolled in the course,e.g.250

  /**
   * initializes the data fields to the values of the arguments. If the provided integer is negative
   * (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param name the name of the course
   * @param numStudents the number of students who enrolled in the course
   * @throws IllegalArgumentException with a descriptive error message when provided integer < 0
   */
   public Course(String name, int numStudents) throws IllegalArgumentException{
     
     if(numStudents < 0) {
       throw new IllegalArgumentException("the number of students is negative");
     }
     
     this.name =  name;
     this.numStudents = numStudents;
     
   }
   
   /**
    * Getter method to return name of the course
    * 
    * @return name - the name of this course
    */
   public String getName(){
     
     return this.name;
     
   }
   
   /**
    * Getter method to return the number of students enrolled in this course
    * 
    * @return numStudents - the number of students enrolled in this course
    */
   public int getNumStudents() {
     
     return this.numStudents;
     
   }

}
