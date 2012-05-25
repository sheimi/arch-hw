package me.sheimi.pb.bean;

public class PhoneNumber {

  private int id;
  private String number;
  private int personId;
  
  private Person person;

  public PhoneNumber(int id, String number, int personId) {
    this.id = id;
    this.number = number;
    this.personId = personId;
  }

  public PhoneNumber(String number) {
    this(0, number, 0);
  }

  public PhoneNumber(String number, int personId) {
    this(0, number, personId);
  }

  public PhoneNumber(String number, Person person) {
    this(0, number, person.getId());
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public int getPersonId() {
    return personId;
  }
}
