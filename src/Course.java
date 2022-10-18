//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Course.java
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
