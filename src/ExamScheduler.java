//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExamScheduler.java
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

/**
 * This class
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class ExamScheduler {

  /**
   * returns a valid Schedule for the given set of rooms and courses, or throws an
   * IllegalStateException if no such schedule exists. This method should contain only a call to the
   * helper method, providing an empty starting Schedule.
   * 
   * @param rooms   the list of rooms
   * @param courses the list of courses
   * @return Schedule a valid Schedule for the given set of rooms and courses
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {

    Schedule schedule = new Schedule(rooms, courses); // make an empty starting Schedule
    return findScheduleHelper(schedule, 0);

  }

  /**
   * recursive method that assigns all unassigned courses in a Schedule beginning from the index
   * provided as an argument
   * 
   * @param schedule - Schedule for the given set of rooms and courses
   * @param index    - the first ideal index of course which will be assigned
   * @return Schedule - new schedule which each course are tried to be assigned to rooms
   * @throws IllegalStateException if no such schedule exists
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index)
      throws IllegalStateException {

    // If the provided index is equal to the number of courses, check to see if the Schedule is
    // complete. If so, return the schedule; otherwise throw an IllegalStateException indicating
    // that this Schedule is invalid.
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        return schedule;
      } else {
        throw new IllegalStateException("Schedule is invalid");
      }
    }

    // If the provided index corresponds to a course that has already been assigned to a room,
    // recursively assign the courses at the following indexes and return the resulting schedule.
    if (schedule.isAssigned(index)) {
      return findScheduleHelper(schedule, ++index);
    } else {

      // If the provided index corresponds to a course that has NOT already been assigned to a room,
      // iteratively try to assign it to each possible valid Room and recursively assign the courses
      // at the following indexes. If this course cannot be assigned to that room, try the next one;
      // return the resulting schedule.
      Schedule scheduleOut = null;
      for (int i = 0; i < schedule.getNumRooms(); i++) { // check available room
        if (schedule.getRoom(i).getCapacity() >= schedule.getCourse(index).getNumStudents()) {
          try {
            // try to assign
            scheduleOut = findScheduleHelper(schedule.assignCourse(index, i), index + 1);
          } catch (IllegalStateException e) {
          }
        }
      }
      if (scheduleOut == null) { // all courses are not assigned
        throw new IllegalStateException("error: Schedule is invalid");
      }
      return scheduleOut;
    }
  }

  /**
   * returns an ArrayList containing all possible Schedules for the given set of rooms and courses.
   * (If none can be created, this ArrayList is empty.) This method should contain only a call to
   * the helper method, providing an empty starting Schedule.
   * 
   * @param rooms   - list of rooms
   * @param courses - list of courses
   * @return ArrayList<Schedule> ArrayList containing all possible Schedules for the given set of
   *         rooms and courses
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {

    Schedule schedule = new Schedule(rooms, courses); // make an empty starting Schedule

    return findAllSchedulesHelper(schedule, 0); // return all schedule combinations

  }

  /**
   * recursive method that assigns all unassigned courses in a Schedule in ALL POSSIBLE ways,
   * beginning from the index provided as an argument
   * 
   * @param schedule - Schedule for the given set of rooms and courses
   * @param index    - the first ideal index of course
   * @return ArrayList<Schedule> ArrayList containing possible Schedules for the given set of rooms
   *         and courses
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {

    ArrayList<Schedule> allSchedules = new ArrayList<Schedule>();

    // If the provided index is equal to the number of courses, check to see if the Schedule is
    // complete. If so, add it to an ArrayList of possible schedules and return the ArrayList.
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        allSchedules.add(schedule);
        return allSchedules;
      }
    }

    // If the provided index corresponds to a course that has already been assigned to a room,
    // recursively add all possible valid schedules from the following indexes to an ArrayList of
    // Schedules and return this ArrayList.
    if (schedule.isAssigned(index)) {
      allSchedules.addAll(findAllSchedulesHelper(schedule, index + 1));
      return allSchedules;
    }

    // If the provided index corresponds to a course that has NOT already been assigned to a room,
    // iteratively try to assign it to each possible valid Room and recursively add all possible
    // valid schedules from the following indexes to an ArrayList of Schedules and return this
    // ArrayList.
    if (schedule.isAssigned(index) == false) {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        if (schedule.getRoom(i).getCapacity() >= schedule.getCourse(index).getNumStudents()) {
          // try to assign
          allSchedules.addAll(findAllSchedulesHelper(schedule.assignCourse(index, i), index + 1));
        }
      }
    }
    return allSchedules;
  }

}
