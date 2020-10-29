package ru.gos1984.demo.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gos1984.demo.library.entity.Author;
import ru.gos1984.demo.library.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "10") int size,
                       @RequestParam(name = "sort", defaultValue = "id") String sort,
                       @RequestParam(name = "direction", defaultValue = "asc") String direction
                       ) {
        model.addAttribute("authors", authorService
                .getAll(PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction.equals("desc") ? "desc" : "asc"), sort))));

        return "author/list";
    }

    @GetMapping("/{id}")
    public String view(Model model, @PathVariable("id") Long id) {

        model.addAttribute("author", authorService.findById(id));

        return "author/view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable("id") Long id) {

        model.addAttribute("author", authorService.findById(id));

        return "author/edit";
    }

    @PostMapping("/new")
    public String create(@RequestBody Author author, BindingResult result) {

        if(result.hasErrors()) {
            return "redirect:/new";
        }
        authorService.save(author);

        return "redirect:/new";

    }

}
