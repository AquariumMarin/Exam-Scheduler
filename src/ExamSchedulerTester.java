//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExamSchedulerTester.java
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * This class contains the tester methods for ExamScheduler class, Course class, Room class, and
 * Schedule class.
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class ExamSchedulerTester {

  public static void main(String[] args) {

    System.out.println(testCourse());
    System.out.println(testRoom());
    System.out.println(testScheduleAccessors());
    System.out.println(testAssignCourse());
    System.out.println(testFindSchedule());
    System.out.println(testFindAllSchedules());

  }

  /**
   * This method verifies that the constructor and methods work properly in Course class and any
   * relevant exceptions are thrown.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testCourse() {

    String name = "CS300";

    // check the constructor if numStudents < 0
    try {
      int numStudents = -1;
      Course cs300 = new Course(name, numStudents); // must throw Exception

      return false; // incorrect
    } catch (IllegalArgumentException e) { // test passed
    } catch (Exception e) {
      return false; // test failed
    }

    // when created new object successfully, check constructor method, getName(), and
    // getNumStudents()
    try {
      int numStudents = 10;
      String expectedName = "CS300";
      int expectedNumStudents = 10;

      Course cs300 = new Course(name, numStudents); // successfully constructed

      if (cs300.getName().equals(expectedName) && cs300.getNumStudents() == expectedNumStudents) {

        // test passed

      }
    } catch (Exception e) {
      return false; // test failed
    }

    return true; // test passed

  }

  /**
   * This method verifies that the constructor and methods in Room class work properly and any
   * relevant exceptions are thrown.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testRoom() {
    String location = "Noland168";

    // check the constructor if capacity < 0

    try {
      int capacity = -1;
      Room noland168 = new Room(location, capacity); // must throw Exception
      return false; // false
    } catch (IllegalArgumentException e) { // test passed
    } catch (Exception e) {
      return false; // test failed
    }

    // when created new object successfully, check constructor method, getLocation(), and
    // getCapacity()

    try {
      int capacity = 10;
      String expectedLocation = "Noland168";
      int expectedCapacity = 10;

      Room noland168 = new Room(location, capacity); // successfully constructed

      if (noland168.getLocation().equals(expectedLocation)
          && noland168.getCapacity() == expectedCapacity) {

        // test passed

      }
    } catch (Exception e) {
      return false; // test failed
    }

    // when trying to create new object by calling reduceCapacity() with larger capacity to be
    // reduced than original capacity, check reduceCapacity(), getLocation(), and getCapacity()
    try {

      int capacity = 10;
      String expectedLocation = "Noland168";
      int capacityToReduce = 11;

      Room noland168 = new Room(location, capacity); // successfully constructed
      Room noland168_1 = noland168.reduceCapacity(capacityToReduce); // must throw exception

      return false; // incorrect
    } catch (IllegalArgumentException e) {
      // test passed
    } catch (Exception e) {
      return false; // test failed
    }

    // when created new object successfully by calling reduceCapacity(), check reduceCapacity(),
    // getLocation(), and getCapacity()
    try {

      int capacity = 10;
      String expectedLocation = "Noland168";
      int capacityToReduce = 1;
      int expectedCapacity = 9;

      Room noland168 = new Room(location, capacity); // successfully constructed
      Room noland168_2 = noland168.reduceCapacity(capacityToReduce); // successfully constructed

      if (noland168_2.getLocation().equals(expectedLocation)
          && noland168_2.getCapacity() == expectedCapacity) {
        // correct
      }
    } catch (IllegalArgumentException e) {
      return false; // incorrect
    } catch (Exception e) {
      return false; // test failed
    }

    return true; // test passed
  }

  /**
   * This method verifies that the constructor and accessor methods(getAssignment(int) will be
   * checked in the next tester method) work properly in Schedule class and any relevant exceptions
   * are thrown.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testScheduleAccessors() {

    // create rooms
    Room noland168 = new Room("Noland168", 200);
    Room socialScience102 = new Room("SocialScience102", 100);
    Room[] rooms = {noland168, socialScience102};

    // create courses
    Course cs300 = new Course("CS300", 200);
    Course esl118 = new Course("ESL118", 10);
    Course[] courses = {cs300, esl118};

    // check getNumRooms() and constructor
    int expectedNumRoomAvairable = 2;

    try {
      Schedule schedule = new Schedule(rooms, courses);
      if (schedule.getNumRooms() != expectedNumRoomAvairable) {
        return false; // incorrect
      }

    } catch (Exception e) {
      return false; // test failed
    }

    // check getRoom(int) if index is invalid
    try {
      int index = -1;
      Schedule schedule = new Schedule(rooms, courses);
      schedule.getRoom(index); // must throw exception
      return false; // incorrect
    } catch (IndexOutOfBoundsException e) {

      // correct

    } catch (Exception e) {
      return false; // test failed
    }

    // check getRoom(int) if index is valid and constructor
    try {
      int index1 = 0;
      int index2 = 1;
      Room expectedRoom1 = noland168;
      Room expectedRoom2 = socialScience102;
      Schedule schedule = new Schedule(rooms, courses);

      if (schedule.getRoom(index1) != expectedRoom1 || schedule.getRoom(index2) != expectedRoom2) {
        return false; // incorrect
      }

      // correct
    } catch (IndexOutOfBoundsException e) {

      return false; // incorrect

    } catch (Exception e) {
      return false; // test failed
    }

    // check getNumCourses() and constructor
    try {
      int expectedNumCourses = 2;
      Schedule schedule = new Schedule(rooms, courses);
      if (schedule.getNumCourses() != expectedNumCourses) {
        return false; // incorrect
      }

      // correct

    } catch (Exception e) {
      return false; // incorrect
    }

    // check getCourse(int) if index is invalid
    try {
      int index = -1;
      Schedule schedule = new Schedule(rooms, courses);
      schedule.getCourse(index); // must throw exception
      return false; // incorrect
    } catch (IndexOutOfBoundsException e) {

      // correct

    } catch (Exception e) {
      return false; // test failed
    }

    // check getCourse(int) if index is valid and constructor
    try {
      int index1 = 0;
      int index2 = 1;
      Course expectedCourse1 = cs300;
      Course expectedCourse2 = esl118;
      Schedule schedule = new Schedule(rooms, courses);

      if (schedule.getCourse(index1) != expectedCourse1
          || schedule.getCourse(index2) != expectedCourse2) {
        return false; // incorrect
      }

      // correct
    } catch (IndexOutOfBoundsException e) {
      return false; // incorrect

    } catch (Exception e) {
      return false; // test failed
    }

    // create assignments
    int[] assignments;

    return true; // test passed
  }

  /**
   * This method verifies that the constructor and assign methods work properly and any relevant
   * exceptions are thrown.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testAssignCourse() {

    // create rooms
    Room noland168 = new Room("Noland168", 200);
    Room socialScience102 = new Room("SocialScience102", 100);
    Room[] rooms = {noland168, socialScience102};

    // create courses
    Course cs300 = new Course("CS300", 200);
    Course esl118 = new Course("ESL118", 10);
    Course[] courses = {cs300, esl118};

    // check isAssigned(int), assignCourse(int,int) and constructor
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0); // assign the first course to the first room
      newSchedule = newSchedule.assignCourse(1, 1); // assign the second course to the second course

      if (newSchedule.isAssigned(0) == false || newSchedule.isAssigned(1) == false) {
        return false; // incorrect
      }

      // correct

    } catch (Exception e) {
      return false; // incorrect
    }

    // check getAssignment(int) if the course has not been assigned a room
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0); // assign the first course to the first room

      newSchedule.getAssignment(1); // not yet assigned

      return false; // incorrect

    } catch (IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // check getAssignment(int) in successful case
    try {

      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0); // assign the first course to the first room

      if (newSchedule.getAssignment(0) != newSchedule.getRoom(0)) {

        return false; // incorrect

      }
      
      // correct

    } catch (IllegalArgumentException e) {
      return false; // incorrect
    } catch (Exception e) {
      return false; // incorrect
    }

    // check getAssignment(int) if the given course index is invalid
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0); // assign the first course to the first room

      newSchedule.getAssignment(-1); // invalid

      return false; // incorrect

    } catch (IndexOutOfBoundsException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // assignCourse(int,int) if the given course or room index is invalid
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(-1, 0);

      return false; // incorrect

    } catch (IndexOutOfBoundsException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // assignCourse(int,int) if the given course or room index is invalid
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 2);

      return false; // incorrect

    } catch (IndexOutOfBoundsException e) { // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // assignCourse(int,int) if the given course has already been assigned a room
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0);
      newSchedule = newSchedule.assignCourse(0, 1); // try to assign the same course again

      return false; // incorrect
    } catch (IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // assignCourse(int,int) if the room does not have sufficient capacity
    try {

      Room backyRoom = new Room("backyRoom", 100);
      Room[] newRooms = {backyRoom, noland168}; // create new rooms

      int[] assignments = new int[] {0, 1};

      Schedule newSchedule = new Schedule(newRooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0);
      newSchedule = newSchedule.assignCourse(1, 0); // try to assign the backyroom which already has
                                                    // 0 capacity

      return false; // incorrect
    } catch (IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // check isComplete() and constructor
    try {

      int[] assignments = new int[] {0, 1};
      Schedule newSchedule = new Schedule(rooms, courses);
      newSchedule = newSchedule.assignCourse(0, 0); // assign the first course to the first room
      newSchedule = newSchedule.assignCourse(1, 1); // assign the second course to the second course

      if (newSchedule.isComplete() == false) {
        return false; // incorrect
      }

      // correct

    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // test passed
  }

  /**
   * Verify that the primary, public findAllSchedules methods produce in ExamScheduler class the
   * results as expected.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testFindAllSchedules() {

    // make a new rooms
    Room[] rooms1 = {new Room("Noland 168", 100), new Room("Grainger 100", 500),
        new Room("Bascom Hall 100", 350)};

    // make a new courses
    Course[] courses1 =
        {new Course("cs200", 300), new Course("cs300", 100), new Course("cs400", 300)};

    // success case
    ArrayList<String> expectedList = new ArrayList<String>();
    expectedList.add("{cs200: Grainger 100, cs300: Noland 168, cs400: Bascom Hall 100}");
    expectedList.add("{cs200: Grainger 100, cs300: Grainger 100, cs400: Bascom Hall 100}");
    expectedList.add("{cs200: Bascom Hall 100, cs300: Noland 168, cs400: Grainger 100}");
    expectedList.add("{cs200: Bascom Hall 100, cs300: Grainger 100, cs400: Grainger 100}");

    int i = 0;

    try {
      for (Schedule schedule : ExamScheduler.findAllSchedules(rooms1, courses1)) {
        if (!schedule.toString().equals(expectedList.get(i))) {
          return false; // incorrect
        }
        i++;
      }
    } catch (Exception e) {
      return false; // incorrect
    }
    
    // unsuccess case
    // make a new rooms
    Room[] rooms2 = {new Room("Noland 168", 1), new Room("Grainger 100", 1),
        new Room("Bascom Hall 100", 350)};

    // make a new courses
    Course[] courses2 =
        {new Course("cs200", 300), new Course("cs300", 100), new Course("cs400", 300)};
    
    try {
      ArrayList<Schedule> newAllList = ExamScheduler.findAllSchedules(rooms2,  courses2);
      if(!newAllList.isEmpty()) {
        return false; // incorrect
      }
    } catch(Exception e) {
      return false;
    }
    
    return true; // test passed

  }

  /**
   * Verify that the primary, public findSchedule methods in ExamScheduler class produce the results
   * as expected.
   * 
   * @return true if the test pass, or return false otherwise
   */
  public static boolean testFindSchedule() {

    // make rooms
    Room[] rooms1 = {new Room("Noland 168", 100), new Room("Grainger 100", 500),
        new Room("Bascom Hall 100", 350)};

    // make courses
    Course[] courses1 =
        {new Course("cs200", 300), new Course("cs300", 100), new Course("cs400", 300)};

    String expected = "{cs200: Bascom Hall 100, cs300: Grainger 100, cs400: Grainger 100}";
    
    // success case
    try {
      if (!ExamScheduler.findSchedule(rooms1, courses1).toString().equals(expected)) {
        return false; // incorect
      }
    } catch (Exception e) {
      return false; // incorrect
    }

    // when schedule is invalid
    // make rooms
    Room[] rooms2 =
        {new Room("Noland 168", 10), new Room("Grainger 100", 50), new Room("Bascom Hall 100", 35)};

    // make courses
    Course[] courses2 =
        {new Course("cs200", 300), new Course("cs300", 100), new Course("cs400", 300)};

    try {
      ExamScheduler.findSchedule(rooms2, courses2);
      return false; // incorrect
    } catch (IllegalStateException e) {

      // correct

    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // test passed
  }

}

