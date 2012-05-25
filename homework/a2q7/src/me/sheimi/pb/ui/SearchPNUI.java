package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;
import me.sheimi.pb.bean.*;
import me.sheimi.pb.exception.*;
import java.util.*;

public class SearchPNUI extends UI {
 
  private SearchPNControl control = new SearchPNControl();

  public void display() {
    seperator();
    hint("Search Phone Numbers");
    seperator();
    String firstname = hintInput("First Name   (end with enter): ");
    String lastname  = hintInput("Last Name    (end with enter): ");
    seperator();
    hint(firstname + "  " + lastname);
    seperator();
    try {
      List<PhoneNumber> pns = control.searchPhoneNumber(firstname, lastname);
      for (PhoneNumber pn : pns) {
        hint(pn.getNumber());
      }
    } catch (PersonNotExistException e) {
      hint("No Such User");
    }
    seperator();
  }

}
