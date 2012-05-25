package me.sheimi.pb.bean;

public class Person {

  private int id;
  private String firstname;
  private String lastname;

  public Person(int id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public Person(String firstname, String lastname) {
    this(0, firstname, lastname);
  }

  public void setId(int id) {
    this.id = id;
  } 

  public int getId() {
    return id;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getLastname() {
    return lastname;
  }
}
