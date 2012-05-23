package me.sheimi.pb.control;

import me.sheimi.pb.exception.*;
import me.sheimi.pb.db.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class SearchPNControl {

  private DataManager dm = DataManager.instance();
  
  public List<PhoneNumber> searchPhoneNumber(String firstname, String lastname)
    throws PersonNotExistException {
    List<Person> persons = dm.queryPerson(firstname, lastname);
    if (persons.size() == 0) 
      throw new PersonNotExistException();
    Person p = persons.get(0);
    List<PhoneNumber> pns = dm.queryPhoneNumber(p);
    return pns;
  } 

}
