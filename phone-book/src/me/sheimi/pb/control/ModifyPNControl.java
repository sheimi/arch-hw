package me.sheimi.pb.control;

import me.sheimi.pb.exception.*;
import me.sheimi.pb.db.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class ModifyPNControl {

  private DataManager dm = DataManager.instance();
  
  public boolean modifyPhoneNumber(String firstname, String lastname, String number, String newNumber) 
    throws PersonNotExistException, PhoneNumberNotExistException {
    List<Person> persons = dm.queryPerson(firstname, lastname);
    if (persons.size() == 0) 
      throw new PersonNotExistException();
    Person p = persons.get(0);
    List<PhoneNumber> pns = dm.queryPhoneNumber(p, number);
    if (pns.size() == 0)
      throw new PhoneNumberNotExistException();
    for (PhoneNumber pn : pns) {
      pn.setNumber(newNumber);
      dm.updatePhoneNumber(pn);
    }
    return true;

  } 

}
