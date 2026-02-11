package auca.ac.rw.restfullApiAssignment.controller.librarian;

import auca.ac.rw.restfullApiAssignment.model.librarian.Librarian;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LibrarianController {

    private List<Librarian> librarians = new ArrayList<>();

    public LibrarianController() {
        librarians.add(new Librarian(0L, "Alice Mutoni", "alice.m@auca.ac.rw", "Senior", 10));
        librarians.add(new Librarian(1L, "Bob Mugisha", "bob.m@auca.ac.rw", "Junior", 2));
        librarians.add(new Librarian(2L, "Clara Uwineza", "clara.u@auca.ac.rw", "Senior", 8));
        librarians.add(new Librarian(3L, "David Keza", "david.k@auca.ac.rw", "Mid-Level", 5));
        librarians.add(new Librarian(5L, "Eric Ganza", "eric.g@auca.ac.rw", "Junior", 1));
    }

    @GetMapping("/api/librarians")
    public List<Librarian> getAll() { return librarians; }

    @GetMapping("/api/librarians/{librarianId}")
    public ResponseEntity<Librarian> getById(@PathVariable Long librarianId) {
        return librarians.stream()
                .filter(l -> l.getLibrarianId().equals(librarianId))
                .findFirst()
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/librarians/position/{position}")
    public List<Librarian> getByPosition(@PathVariable String position) {
        return librarians.stream()
                .filter(l -> l.getPosition().equalsIgnoreCase(position))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/librarians/experience")
    public List<Librarian> filterByExperience(@RequestParam int minYears) {
        return librarians.stream()
                .filter(l -> l.getYearsOfExperience() >= minYears)
                .collect(Collectors.toList());
    }
}