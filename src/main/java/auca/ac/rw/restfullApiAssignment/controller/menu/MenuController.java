package auca.ac.rw.restfullApiAssignment.controller.menu;

import auca.ac.rw.restfullApiAssignment.model.menu.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class MenuController {

    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuController() {
        menuItems.add(new MenuItem(1L, "Samosa", "Meat filling", 500.0, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Spring Rolls", "Crispy", 600.0, "Appetizer", true));
        menuItems.add(new MenuItem(3L, "Grilled Chicken", "Served with chips", 4500.0, "Main Course", true));
        menuItems.add(new MenuItem(4L, "Beef Burger", "Cheese burger", 3500.0, "Main Course", false));
        menuItems.add(new MenuItem(5L, "Fruit Salad", "Fresh fruits", 1500.0, "Dessert", true));
        menuItems.add(new MenuItem(6L, "Chocolate Cake", "Chocolate", 2000.0, "Dessert", true));
        menuItems.add(new MenuItem(7L, "Coffee", "African coffee", 1200.0, "Beverage", true));
        menuItems.add(new MenuItem(8L, "Fresh Juice", "Mango or Pineapple", 1000.0, "Beverage", true));
    }

    @GetMapping("/api/menu")
    public List<MenuItem> getAll() { return menuItems; }

    @GetMapping("/api/menu/available")
    public List<MenuItem> getAvailable(@RequestParam boolean available) {
        return menuItems.stream()
                .filter(item -> item.isAvailable() == available)
                .collect(Collectors.toList());
    }

    @PutMapping("/api/menu/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable()); // Flips true to false or vice versa
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}