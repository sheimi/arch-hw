package me.sheimi.pb.control;

import me.sheimi.pb.exception.*;
import me.sheimi.pb.db.*;
import me.sheimi.pb.bean.*;
import java.util.*;

public class ViewPNControl {

  private DataManager dm = DataManager.instance();
  
  public List<PhoneNumber> viewPhoneNumber() {
    List<PhoneNumber> pns= dm.queryPhoneNumber();
    for (PhoneNumber pn : pns) {
      Person p = dm.getPerson(pn.getPersonId());
      pn.setPerson(p);
    }
    return pns;
  } 

}
