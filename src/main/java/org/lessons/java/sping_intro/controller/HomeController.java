package org.lessons.java.sping_intro.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.lessons.java.sping_intro.classes.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String home(Model model) {
        model.addAttribute("name", "Mike");
        return "home";
    }
    // nel browser "http://localhost:8080"

    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email,
            Model model) {
        model.addAttribute("email", email);
        model.addAttribute("currentDate", LocalDateTime.now());
        model.addAttribute("name", name);
        return "greetings";
    }
    // nel browser
    // "http://localhost:8080/welcome?name=farncesco&email=er_pupone76@gmail.com"

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

        Student franscescoTotti = new Student("Francesco", "Totti", "er_pupone76@asroma.com", "pupone");
        Student studentessa = new Student("Ginetta", "Bianchi", "ginbianchi@gmail.com", "ginbianchina");
        Student studente = new Student("Gino", "Rossi", "ginorossi@gmail.com", "ginred");
        Student studentessaDue = new Student("Nina", "Prof", "ninapro@gmail.com", "ninayeah");

        ArrayList<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(franscescoTotti);
        listaStudenti.add(studentessa);
        listaStudenti.add(studente);
        listaStudenti.add(studentessaDue);

        model.addAttribute("students", listaStudenti);
        return "students/index";
    }
    // nel browser:
    // http://localhost:8080/students

    // CHE SUCCEDE? ROTTA PARAMETRICA
    // content è quello che viene preso dopo pagina ("pagina/{content} - ln.78),
    // prende il content associato alla Path (@PathVariable("content") - ln.79) che
    // lo casta in una stringa (String urlContent), urlContent viene richiamato nel
    // nostro metodo come variabile locale (ln.80) e la pagina "pageById" lo
    // recupera (pageById - ln.15 - <h1 th:text="${contenuto}"></h1>)
    @GetMapping("pagina/{content}")
    public String pageById(Model model, @PathVariable("content") String urlContent) {
        model.addAttribute("contenuto", urlContent);
        return "pageById";
        // in questo caso utilizziamo questo metodo cosi ma potremmo anche:
        // - cercare il post con questo titolo (titolo=contenuto)
        // - cercarlo studente con questo id (id = contenuto)
        // - prend l'elemento indice in questo array (indice = contenuto)
    }
    // nel browser
    // http://127.0.0.1:8080/pagina/quellochetipare

}
