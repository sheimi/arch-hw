package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class ViewPNUI extends UI {
 
  private ViewPNControl control = new ViewPNControl();

  public void display() {
    seperator();
    hint("HERE YOU CAN VIEW ALL NUMBERS");
    seperator();
    System.out.printf("%-20s%-20s%-20s\n", "FirstName", "LastName", "PhoneNumber");
    seperator();
    List<PhoneNumber> pns = control.viewPhoneNumber();
    for (PhoneNumber pn : pns) {
      Person p = pn.getPerson();
      System.out.printf("%-20s%-20s%-20s\n", p.getFirstname(), p.getLastname(), pn.getNumber());
    }
    seperator();
  }

}
