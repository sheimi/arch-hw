package me.sheimi.pb.control;

import me.sheimi.pb.exception.*;
import me.sheimi.pb.db.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class DeletePNControl {

  private DataManager dm = DataManager.instance();
  
  public boolean deletePhoneNumber(String firstname, String lastname, String number) 
    throws PersonNotExistException, PhoneNumberNotExistException {

    List<Person> persons = dm.queryPerson(firstname, lastname);
    if (persons.size() == 0) 
      throw new PersonNotExistException();
    Person p = persons.get(0);
    List<PhoneNumber> pns = dm.queryPhoneNumber(p, number);
    if (pns.size() == 0)
      throw new PhoneNumberNotExistException();
    for (PhoneNumber pn : pns)
      dm.deletePhoneNumber(pn);
    return true;

  } 

}
