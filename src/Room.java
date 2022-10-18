//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Room.java
///////////////////////////////////////////////////////////////////////////////

/**
 * This class manages location and capacity of classroom where the course conducts exam.
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class Room {

  private String location; // the building and room number,e.g.“Noland168”
  private int capacity; // the maximum number of people who can be in the room at a time

  /**
   * initializes the data fields to the values of the arguments. If the provided integer is negative
   * (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param location the location exam will be conducted
   * @param capacity  the capacity of the location
   * @throws IllegalArgumentException with a descriptive error message when provided integer < 0
   */
  public Room(String location, int capacity) throws IllegalArgumentException{

    if (capacity < 0) {
      throw new IllegalArgumentException("the capacity is negative");
    }

    this.location = location;
    this.capacity = capacity;
  }

  /**
   * Getter method to return name of the location
   * 
   * @return location - the location of this room
   */
  public String getLocation() {

    return this.location;

  }

  /**
   * Getter method to return the capacity of this room
   * 
   * @return capacity - the capacity of this room
   */
  public int getCapacity() {

    return this.capacity;

  }

  /**
   * Returns a NEW Room object with the same location as this one,but with a capacity less than this
   * one’s by the argument’s amount. For example, if Room r has a capacity of 10, calling
   * r.reduceCapacity (3) will return a new Room object with the same location as r but a capacity
   * of 7 If the argument 
   * is greater than the given Room’s capacity, this method should throw an
   * IllegalArgumentException with a descriptive error message.
   * 
   * @param numToReduce the number of capacity to reduce
   * @return a NEW Room object with the same location as this one
   * @throws IllegalArgumentException with a descriptive error message if argument is greater than
   *         the given Room’s capacity
   */
  public Room reduceCapacity(int numToReduce) throws IllegalArgumentException{
    
    if(numToReduce > this.capacity) {
      throw new IllegalArgumentException("the new capacity is negative");
    }
    
    Room newRoom = new Room(this.location, this.capacity - numToReduce);
    
    return newRoom;
    
  }

}
