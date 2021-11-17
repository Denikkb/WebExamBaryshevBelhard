package com.baryshev.WebExamBaryshevBelhard.controller;

import com.baryshev.WebExamBaryshevBelhard.DAO.PersonDAO;
import com.baryshev.WebExamBaryshevBelhard.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class PersonsController {


    private final PersonDAO personsDAO;

    @Autowired
    public  PersonsController(PersonDAO personsDAO) {

        this.personsDAO = personsDAO;
    }

    @GetMapping("/people")
    public String showAllPersons(Model model) throws SQLException {
        model.addAttribute("people1", personsDAO.showAllPersons());
        return "showAllPersons";
    }

    @GetMapping("/people/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("person", personsDAO.showPerson(id));
        return "showPerson";

    }

    @GetMapping("/people/new")
    public String newPerson (Model model) {
        model.addAttribute("person2", new Person());
        return "newPerson";

    }

    @PostMapping()
    public String create (@ModelAttribute("person2")  @Valid Person person, BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
        return "newPerson";}


        else {personsDAO.save(person);


        return "redirect:/people";}
    }

    @GetMapping("/people/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) throws SQLException {
        model.addAttribute("person",personsDAO.showPerson(id));
        return "edit";
    }

   /* @RequestMapping(value = "/people/{id}", method = RequestMethod.PATCH)
    public String update (@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personsDAO.update(id, person);
        return "redirect:/people"
    }*/

    @PatchMapping( "/people/{id}")
    public String update (@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "edit";
        }
        else {personsDAO.update(id, person);
        return "redirect:/people";}
    }

   @DeleteMapping("/people/{id}")
    public String delete (@PathVariable("id") int id) throws SQLException {
        personsDAO.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}/peopleWithProduct")
    public String peopleWithProduct (@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("person",personsDAO.peopleWithProduct(id));
        return "people_with_product";
    }

}
