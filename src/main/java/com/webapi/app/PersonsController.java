package com.webapi.app;

import java.util.ArrayList;
import java.util.List;

import com.webapi.app.entities.Person;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class PersonsController {

    @GetMapping("/persons")
    //public ResponseEntity<List<Person>> GetPerson(){
    public List<Person> GetPersons(){

        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Jesus", 28));
        persons.add(new Person("Julio", 34));
        persons.add(new Person("Javier", 27));

        //return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
        return persons;
    }
    
    @GetMapping("/persons/{id}")
    //public ResponseEntity<List<Person>> GetPerson(){
    public Person GetPerson(@PathVariable("id") int id){

        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Jesus", 28));
        persons.add(new Person("Julio", 34));
        persons.add(new Person("Javier", 27));

        //return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
        return persons.get(id);
    }
}