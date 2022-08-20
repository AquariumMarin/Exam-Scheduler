//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Schedule.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * This class manages the matching between Course and Room objects. This class contains
 * the methods to assign courses to room and getter methods.
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class Schedule {

  private Room[] rooms; // an array of the Room objects available for exams
  private Course[] courses; // an array of the Course objects which require exam rooms
  private int[] assignments; // an array where the integer at index N is the index of the room that
                             // course[N] has been assigned to

  /**
   * initializes the rooms and courses arrays to the provided values, and creates an assignments
   * array of the correct length where all values are -1, indicating that the corresponding course
   * has not yet been assigned a room.
   * 
   * @param rooms   an array of the Room objects available for exams
   * @param courses an array of the Course objects which require exam rooms
   */
  public Schedule(Room[] rooms, Course[] courses) {

    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[this.courses.length];

    // array of the correct length where all values are -1
    for (int i = 0; i < this.assignments.length; i++) {
      this.assignments[i] = -1;
    }

  }

  /**
   * Initializes the rooms and courses arrays to the provided values and assignments to the provided
   * assignments array. May assume the assignments array is the correct length (equal to the length
   * of the courses array).
   * 
   * @param rooms       an array of the Room objects available for exams
   * @param courses     an array of the Course objects which require exam rooms
   * @param assignments an array where the integer at index N is the index of the room that
   *                    course[N] has been assigned to
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {

    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;

  }

  /**
   * Getter method to return the number of rooms available in this schedule
   * 
   * @return the number of rooms available in this schedule
   */
  public int getNumRooms() {

    return this.rooms.length;

  }

  /**
   * returns the Room object at the given index in the rooms array throws an
   * IndexOutOfBoundsException with a descriptive error message if the given index is invalid
   * 
   * @param index of rooms array
   * @return Room object at the given index in the rooms array
   * @throws IndexOutOfBoundsException with a descriptive error message if the given index is
   *                                   invalid
   */
  public Room getRoom(int index) throws IndexOutOfBoundsException{
    if (index < 0 || index >= rooms.length) {
      throw new IndexOutOfBoundsException("Error: The index entered is invalid.");
    }
    return this.rooms[index];
  }

  /**
   * Getter method to return the number of courses in this schedule
   * 
   * @return the number of courses in this schedule
   */
  public int getNumCourses() {

    return this.courses.length;

  }

  /**
   * returns the Course object at the given index in the courses array
   * 
   * @param index of courses array
   * @return Course object at the given index in the courses array
   * @throws IndexOutOfBoundsException with a descriptive error message if the given index is
   *                                   invalid
   */
  public Course getCourse(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index > this.courses.length - 1) {
      throw new IndexOutOfBoundsException("index is invalid");
    }

    return this.courses[index];
  }

  /**
   * returns true if and only if the course at the given index has been assigned a room; false
   * otherwise
   * 
   * @param int index of course
   * @return true if and only if the course at the given index has been assigned a room, or false
   *         otherwise
   */
  public boolean isAssigned(int index) {

    if (this.assignments[index] != -1) {
      return true; // assigned
    }

    return false; // not assigned
  }

  /**
   * returns the Room object assigned to the course at the given index
   * 
   * @param int index of course
   * @return Room object assigned to the course at the given index
   * @throws an                        IllegalArgumentException if the course has not been assigned
   *                                   a room, or an
   * @throws IndexOutOfBoundsException with a descriptive error message if the given course index is
   *                                   invalid
   * 
   */
  public Room getAssignment(int index) throws IllegalArgumentException, IndexOutOfBoundsException {

    if (index < 0 || index > this.assignments.length - 1) {
      throw new IndexOutOfBoundsException("index is invalid");
    }

    if (isAssigned(index) != true) {
      throw new IllegalArgumentException("the course has not been assigned a room");
    }

    return this.rooms[this.assignments[index]];

  }

  /**
   * returns true if and only if all courses have been assigned to rooms;false otherwise
   * 
   * @throws true if and only if all courses have been assigned to rooms, or false otherwise
   */
  public boolean isComplete() {

    for (int i = 0; i < this.assignments.length; i++) {
      if (this.isAssigned(i) == false) {
        return false; // not assigned
      }
    }

    return true; // all assigned

  }

  /**
   * returns a NEW Schedule object with the course at the first argument index assigned to the room
   * at the second argument index; throws an IndexOutOfBoundsException with a descriptive error
   * message if the given course or room index is invalid, or an IllegalArgumentException with a
   * descriptive error message if the given course has already been assigned a room, or if the room
   * does not have sufficient capacity.
   * 
   * @param int index of course
   * @param int index of room
   * @return NEW Schedule object with the course at the first argument index assigned to the room at
   *         the second argument index
   * @throws IndexOutOfBoundsException with a descriptive error message if the given course or room
   *                                   index is invalid
   * @throws IllegalArgumentException  with a descriptive error message if the given course has
   *                                   already been assigned a room, or if the room does not have
   *                                   sufficient capacity.
   */
  public Schedule assignCourse(int indexOfCourse, int indexOfRoom)
      throws IndexOutOfBoundsException, IllegalArgumentException {

    // invalid index of course
    if (indexOfCourse < 0 || indexOfCourse > this.assignments.length - 1
        || indexOfCourse > this.courses.length - 1) {
      throw new IndexOutOfBoundsException("index is invalid");
    }

    // invalid index of room
    if (indexOfRoom < 0 || indexOfRoom > this.rooms.length - 1) {
      throw new IndexOutOfBoundsException("index is invalid");
    }

    // given course has already been assigned a room
    if (this.assignments[indexOfCourse] != -1) {
      throw new IllegalArgumentException("given course has already been assigned a room");
    }

    // if the room does not have sufficient capacity.
    if (this.rooms[indexOfRoom].getCapacity() < this.courses[indexOfCourse].getNumStudents()) {
      throw new IllegalArgumentException("the room does not have sufficient capacity");
    }

    // deep copy since assignments changed
    int[] newAssignments = Arrays.copyOf(assignments, assignments.length);
    newAssignments[indexOfCourse] = indexOfRoom; // assign the course to the room
    //this.assignments[indexOfCourse] = indexOfRoom;

    // deep copy since rooms changed
    Room[] newRooms = Arrays.copyOf(rooms, rooms.length);

    // Reduce the number of capacity of the room by the number of students in the course
    newRooms[indexOfRoom] =
        newRooms[indexOfRoom].reduceCapacity(courses[indexOfCourse].getNumStudents());
    //this.rooms[indexOfRoom] = this.rooms[indexOfRoom].reduceCapacity(this.courses[indexOfCourse].getNumStudents());

    return new Schedule(newRooms, courses, newAssignments);
    //return new Schedule(this.rooms, this.courses, this.assignments);

  }

  /**
   * method to create a String representation, formatted as follows for example: {CS300: AG 125,
   * CS200: HUM 3650, CS400: Unassigned} where the courses were named ["CS300", "CS200", "CS400"],
   * and the rooms had locations ["SCI 180", "HUM 3650", "AG 125"]. Note that CS400 has not yet been
   * assigned a room, so the corresponding assignments array contains the values [2, 1, -1] at this
   * time.
   * 
   * @return String representation for this class
   */
  @Override
  public String toString() {

    String representation = "{";

    for (int i = 0; i < assignments.length; i++) {
      representation = representation + courses[i].getName(); // add course name

      representation = representation + ": "; // add ": " between course name and room name

      if (assignments[i] == -1) { // the course is not assigned to room yet
        representation = representation + "Unassigned";
      } else {
        representation = representation + rooms[assignments[i]].getLocation(); // add location
      }

      if (i != assignments.length - 1) {
        representation = representation + ", "; // add ", " between course name and room name
      }

    }

    representation = representation + "}"; // close the {}

    return representation;
  }

}
