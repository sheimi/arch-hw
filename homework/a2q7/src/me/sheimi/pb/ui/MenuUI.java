package me.sheimi.pb.ui;

import me.sheimi.pb.control.*;
import me.sheimi.pb.exception.*;

public class MenuUI extends UI {

  private class Menu {
    UI ui;
    String hint;
    Menu(UI ui, String hint) {
      this.ui = ui;
      this.hint = hint;
    }
  }
  private Menu[] menus = {
    new Menu(null, "0. QUIT"),
    new Menu(new AddPNUI(),    "1. Add New Phone Number"),
    new Menu(new ModifyPNUI(), "2. Modify Existing Phone Number"),
    new Menu(new SearchPNUI(), "3. Search Phone Number By Person"),
    new Menu(new ViewPNUI(),   "4. List All Phone Number"), 
    new Menu(new DeletePNUI(), "5. Delete A Phone Number")
  };

  public void display() {
    seperator();
    hint("~~~~~~ Welcome to Your Phone Book: ~~~~~~");
    while (true) {
      seperator();
      displayMenu(); 
      seperator();
      String c = getInputLine();
      try {
        int i = Integer.parseInt(c);
        if (i < 0 || i > 5)
          throw new NumberFormatException();
        if (i == 0)
          return;
        Menu menu = menus[i];
        menu.ui.display();
      } catch (NumberFormatException e) {
        seperator(); 
        hint("Input Error");
      }
    }
  }

  public void displayMenu() {
    for (Menu menu : menus) {
      hint(menu.hint);
    }
  }

}
