package org.lessons.java.sping_intro.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.lessons.java.sping_intro.classes.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

//Definisco qui che questo è un controller:
@Controller
// Aggiungo indicazioni su sull URL BASE del quale si deve occupare (la rotta
// "/")
@RequestMapping("/")
public class HomeController {

    // creo un semplice metodo che mi ritorna una stringa che, tramite
    // la notazione @GetMapping("/"), fa riferimento alla rotta "/", e tramite le
    // sue caratteristiche base, fa riferimento a
    // un file contenuto nella cartella resources/teplate (home.html in questo caso)
    @GetMapping("/")
    public String home() {
        return "home";
    }
    // nel browser "http://localhost:8080"

    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("email", "gina@gmail.com");
        model.addAttribute("currentDate", LocalDateTime.now());
        model.addAttribute("name", name);
        return "greetings";
    }
    // nel browser "http://localhost:8080/welcome?name=Gina"

    @GetMapping("/blog")
    public String blog(@RequestParam(name = "article") String article,
            @RequestParam(name = "nextArticle") String nextArticle, Model model) {

        return "blog";
    }
    // nel browser:
    // "http://localhost:8080/blog?article=articoloUno&nextArticle=ArticoloDue"

    // JAVA BEAN - SERIALIZABLE (Vedi Student.java)
    @GetMapping("/students")
    public String students(Model model) {

        Student studentessa = new Student("Ginetta", "Bianchi", "ginbianchi@gmail.com", "ginbianchina");
        Student studente = new Student("Gino", "Rossi", "ginorossi@gmail.com", "ginred");
        Student studentessaDue = new Student("Nina", "Prof", "ninapro@gmail.com", "ninayeah");

        ArrayList<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(studentessa);
        listaStudenti.add(studente);
        listaStudenti.add(studentessaDue);

        model.addAttribute("students", listaStudenti);
        return "students/index";
    }
    // nel browser:
    // http://localhost:8080/students

}
