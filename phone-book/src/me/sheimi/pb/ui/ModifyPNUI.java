package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;
import me.sheimi.pb.exception.*;

public class ModifyPNUI extends UI {
 
  private ModifyPNControl control = new ModifyPNControl();

  public void display() {
    seperator();
    hint("To Modify The Phone Number");
    seperator();
    String firstname = hintInput("First Name   (end with enter): ");
    String lastname  = hintInput("Last Name    (end with enter): ");
    String oldPhonenum  = hintInput("Old Phone Number (end with enter): ");
    String newPhonenum  = hintInput("New Phone Number (end with enter): ");
    seperator();
    try {
      control.modifyPhoneNumber(firstname, lastname, oldPhonenum, newPhonenum);
      hint("Modify Success");
    } catch (PersonNotExistException e) {
      hint("No Such Person");
    } catch (PhoneNumberNotExistException e) {
      hint("No Such Phone Number");
    }
    seperator();
  }

}
