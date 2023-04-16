/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person;

import Person.Client.Client;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class PersonDirectory {
    ArrayList<Person> personList;

    public PersonDirectory(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
    }


    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person createClient(String id, String name) {
        Client c = new Client();
        c.setId(id);
        c.setName(name);
      
        this.personList.add(c);
        return c;
    }
    
    public Person createPerson(String id, String name) {
        Person p = new Person();
        p.setId(id);
        p.setName(name);
      
        this.personList.add(p);
        return p;
    }
}
