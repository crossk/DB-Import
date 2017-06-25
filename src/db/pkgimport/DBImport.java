/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.pkgimport;

import database.DatabaseManager;

/**
 *
 * @author Christian
 */
public class DBImport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatabaseManager dbm = new DatabaseManager("localhost", "testuser", "ming", "testdb");
        if(dbm.connect()) {
            System.out.println("Verbindung OK");
        }
        else {
            System.out.println("Verbindung NICHT OK");
        }
        
        String cols[] = {"Vorname", "Nachname"};
        String data[] = {"Christian", "Roßkamp"};
        dbm.insert("testtabelle", cols, data);
    }
    
}
