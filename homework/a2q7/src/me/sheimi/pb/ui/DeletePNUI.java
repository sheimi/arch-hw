package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;
import me.sheimi.pb.exception.*;

public class DeletePNUI extends UI {
 
  private DeletePNControl control = new DeletePNControl();

  public void display() {
    seperator();
    hint("To Delete The Phone Number");
    seperator();
    String firstname = hintInput("First Name   (end with enter): ");
    String lastname  = hintInput("Last Name    (end with enter): ");
    String phonenum  = hintInput("Phone Number (end with enter): ");
    seperator();
    try {
      control.deletePhoneNumber(firstname, lastname, phonenum);
      hint("Delete Success");
    } catch (PersonNotExistException e) {
      hint("No Such Person");
    } catch (PhoneNumberNotExistException e) {
      hint("No Such Phone Number");
    }
    seperator();
  }

}
