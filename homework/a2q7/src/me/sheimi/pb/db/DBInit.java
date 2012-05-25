package me.sheimi.pb.db;

import java.sql.*;

public class DBInit {
  //static final String DB_CONN_STR = "jdbc:sqlite::memory:";
  static final String DB_PATH = "phone.db";
  static final String DB_CONN_STR = "jdbc:sqlite:";
  
  static void initDB(Connection conn) {
    try {
      Statement stat = conn.createStatement();
      //init dbs
      stat.executeUpdate("PRAGMA foreign_kays = false;");
      stat.executeUpdate("DROP TABLE IF EXISTS 'Person';");
      stat.executeUpdate("CREATE TABLE 'Person' ("
        + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
        + " firstname VARCHAR NOT NULL,"
        + " lastname VARCHAR NOT NULL);");
      stat.executeUpdate("DROP TABLE IF EXISTS 'PhoneNumber'");
      stat.executeUpdate("CREATE TABLE 'PhoneNumber' ("
        + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
        + " number VARCHAR NOT NULL," 
        + " person_id INTEGER NOT NULL,"
        + " FOREIGN KEY(person_id) REFERENCES 'Person'(id));");

      /*
      //init person
      PreparedStatement prep = conn.prepareStatement(DBInit.PEOPLE_STAT);
      for (String[] s : DBInit.INIT_PEOPLE) {
        prep.setInt(1, Integer.parseInt(s[0]));
        prep.setString(2, s[1]);
        prep.setString(3, s[2]);
        prep.addBatch();
      }
      conn.setAutoCommit(false);
      prep.executeBatch();
      conn.setAutoCommit(true);

      prep = conn.prepareStatement(DBInit.PHONE_STAT);
      for (String[] s : DBInit.INIT_PHONE) {
        prep.setInt(1, Integer.parseInt(s[0]));
        prep.setString(2, s[1]);
        prep.setInt(3, Integer.parseInt(s[2]));
        prep.addBatch();
      }
      conn.setAutoCommit(false);
      prep.executeBatch();
      conn.setAutoCommit(true);
      */
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } 

  //const strings
  static final String PEOPLE_STAT = "INSERT INTO Person VALUES(?, ?, ?);";
	static final String[][] INIT_PEOPLE = { 
    { "1", "sheimi1", "mew"},
    { "2", "sheimi2", "mew" }
  };
  static final String PHONE_STAT = "INSERT INTO PhoneNumber VALUES(?, ?, ?);";
	static final String[][] INIT_PHONE = { 
    { "1", "123456", "1" },
    { "2", "123453", "1" },
    { "3", "123450", "1" },
    { "4", "123451", "1" },
    { "5", "12345", "2" } 
  };
}
