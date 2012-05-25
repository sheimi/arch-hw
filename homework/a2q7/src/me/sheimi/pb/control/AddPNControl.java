package me.sheimi.pb.control;

import me.sheimi.pb.db.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class AddPNControl {

  private DataManager dm = DataManager.instance();
  
  public boolean addPhoneNumber(String firstname, String lastname, String number) {

    List<Person> persons = dm.queryPerson(firstname, lastname);
    if (persons.size() == 0) {
      Person p = dm.addPerson(firstname, lastname);
      dm.addPhoneNumber(p, number);
    } else {
      Person p = persons.get(0);
      dm.addPhoneNumber(p, number);
    }
    return true;

  } 

}
