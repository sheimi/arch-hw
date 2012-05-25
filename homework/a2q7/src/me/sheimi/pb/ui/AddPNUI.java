package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;

public class AddPNUI extends UI {
 
  private AddPNControl control = new AddPNControl();

  public void display() {
    seperator();
    hint("Add New Phone Number");
    seperator();
    String firstname = hintInput("First Name   (end with enter): ");
    String lastname  = hintInput("Last Name    (end with enter): ");
    String phonenum  = hintInput("Phone Number (end with enter): ");
    boolean suc = control.addPhoneNumber(firstname, lastname, phonenum);
    seperator();
    if (suc) {
      hint("Phone Number Add Success");
    } else {
      hint("Phone Number Add Error");
    }
    seperator();
  }

}
