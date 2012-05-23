package me.sheimi.pb.db;

import java.sql.*;
import java.util.*;
import me.sheimi.pb.bean.*;
import java.io.*;

public class DataManager {
  private static DataManager dm;
  private Connection conn;

  private DataManager() {
    try {
      Class.forName("org.sqlite.JDBC");
      File f = new File(DBInit.DB_PATH);
      boolean exist = f.exists();
      conn = 
        DriverManager.getConnection(DBInit.DB_CONN_STR + DBInit.DB_PATH);
      if (!exist) {
        DBInit.initDB(conn);
        System.out.println("DataBase Create Success");
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static DataManager instance() {
    if (dm == null) {
      dm = new DataManager();
    }
    return dm;
  } 

  public Person addPerson(String firstname, String lastname) {
    String sql = String.format("INSERT INTO Person('firstname', 'lastname') VALUES('%s', '%s');", firstname, lastname);
    ResultSet rs = execute(sql);
    Person p = new Person(firstname, lastname);
    try {
      while (rs.next()) {
        p.setId(rs.getInt("last_insert_rowid()"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return p;
  }

  public Person updatePerson(int pid, String firstname, String lastname) {
    String sql = "UPDATE Person SET";
    boolean connect = false;
    if (firstname != null) {
      sql += String.format(" firstname='%s' ", firstname);
      connect = true;
    }
    if (lastname != null) {
      sql += connect ? "," : ""; 
      sql += String.format(" lastname='%s' ", lastname);
    }
    sql += String.format("WHERE id=%d;", pid);
    execute(sql);
    return new Person(pid, firstname, lastname);
  }

  public void deletePerson(int pid) {
    deletePhoneNumberByPerson(pid);
    String sql = String.format("DELETE FROM Person WHERE id = %d;", pid);
    execute(sql);
  }

  public void deletePerson(Person person) {
    deletePerson(person.getId());
  }

  public Person updatePerson(Person person) {
    if (person.getId() == 0) {
      return addPerson(person.getFirstname(), person.getLastname());
    } else {
      return updatePerson(person.getId(), person.getFirstname(), person.getLastname());
    }
  }

  public Person getPerson(int id) {
    String sql = String.format("SELECT * FROM Person WHERE id=%s", id);
    ResultSet rs = query(sql);
    try {
      while (rs.next()) {
        return new Person(id, rs.getString("firstname"), rs.getString("lastname"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Person> queryPerson(Person person, boolean like) {
    return queryPerson(person.getFirstname(), person.getLastname(), like);
  }

  public List<Person> queryPerson(Person person) {
    return queryPerson(person, false);
  }

  public List<Person> queryPerson(String firstname, String lastname) {
    return queryPerson(firstname, lastname, false);
  }

  public List<Person> queryPerson(String firstname, String lastname, boolean like) {
    String sql = "SELECT * FROM Person";
    if (firstname != null || lastname != null) {
      sql += " WHERE ";
      boolean connect = false;
      if (firstname != null) {
        if (like) {
          sql += String.format(" firstname LIKE '%%%s%%' ", firstname);
        } else {
          sql += String.format(" firstname='%s' ", firstname);
        }
        connect = true;
      }
      if (lastname != null) {
        sql += connect ? " AND " : "";
        if (like) {
          sql += String.format(" lastname LIKE '%%%s%%' ", lastname);
        } else {
          sql += String.format(" lastname='%s' ", lastname);
        }
      }
    }
    sql += ";";
    ResultSet rs = query(sql);
    List<Person> lp = new ArrayList<Person>();
    try {
      while (rs.next()) {
        Person p = new Person(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
        lp.add(p);
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lp;
  }

  public PhoneNumber addPhoneNumber(int pid, String number) {
    String sql = String.format("INSERT INTO PhoneNumber('number', 'person_id') VALUES('%s', %d);", number, pid);
    ResultSet rs = execute(sql);
    PhoneNumber pn = new PhoneNumber(number, pid);
    try {
      while (rs.next()) {
        pn.setId(rs.getInt("last_insert_rowid()"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pn;
  }

  public PhoneNumber addPhoneNumber(Person person, String number) {
    return addPhoneNumber(person.getId(), number);
  }

  public PhoneNumber addPhoneNumber(int pid, PhoneNumber pn) {
    return addPhoneNumber(pid, pn.getNumber());
  }

  public PhoneNumber addPhoneNumber(Person person, PhoneNumber pn) {
    return addPhoneNumber(person.getId(), pn);
  }

  public PhoneNumber updatePhoneNumber(int id, String number, int pid) {
    String sql = String.format("UPDATE PhoneNumber SET number = '%s' WHERE id=%d;", number, id);
    execute(sql);
    return new PhoneNumber(id, number, pid); 
  }

  public PhoneNumber updatePhoneNumber(PhoneNumber pn) {
    return updatePhoneNumber(pn.getId(), pn.getNumber(), pn.getId());
  }

  public void deletePhoneNumber(int id) {
    String sql = String.format("DELETE FROM PhoneNumber WHERE id = %d;", id);
    execute(sql);
  }

  public void deletePhoneNumber(PhoneNumber pn) {
    deletePhoneNumber(pn.getId());
  }

  public void deletePhoneNumberByPerson(int pid) {
    String sql = String.format("DELETE FROM PhoneNumber WHERE person_id = %d;", pid);
    execute(sql);
  }

  public void deletePhoneNumberByPerson(Person person) {
    deletePhoneNumberByPerson(person.getId());
  }

  public List<PhoneNumber> queryPhoneNumber(int pid, String number) {
    String sql = "SELECT * FROM PhoneNumber";
    boolean connect = false;
    if (pid != 0) {
      sql += String.format(" WHERE person_id=%d", pid);
      connect = true;
    }
    if (number != null) {
      if (connect) {
        sql += " and ";
      } else {
        sql += " WHERE ";
      }
      sql += String.format(" number=%s ", number);
    }
    sql += ";";
    ResultSet rs = query(sql);
    List<PhoneNumber> lp = new ArrayList<PhoneNumber>();
    try {
      while (rs.next()) {
        PhoneNumber p = new PhoneNumber(rs.getInt("id"), rs.getString("number"), rs.getInt("person_id"));
        lp.add(p);
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lp;
  }

  public List<PhoneNumber> queryPhoneNumber() {
    return queryPhoneNumber(0, null);
  }

  public List<PhoneNumber> queryPhoneNumber(Person person, String number) {
    return queryPhoneNumber(person.getId(), number);
  }

  public List<PhoneNumber> queryPhoneNumber(Person person) {
    return queryPhoneNumber(person.getId(), null);
  }

  public ResultSet execute(String sql) {
    ResultSet rs = null;
    try {
      Statement stat = conn.createStatement();
      stat.executeUpdate(sql);
      rs = stat.getGeneratedKeys();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public ResultSet query(String sql) {
    ResultSet rs = null;
    try {
      Statement stat = conn.createStatement();
      rs = stat.executeQuery(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

}
