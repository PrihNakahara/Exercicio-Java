package org.generation.artemis.user;

import org.generation.artemis.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users") //endpoint
    public User Save(@RequestBody User cliente) {
        return userRepository.save(cliente);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{id}")
    public User Update(@PathVariable Long id, @RequestBody User users) throws ResourceNotFoundException {
        return userRepository.findById(id).map(user -> {
            user.setNome(users.getNome());
            user.setEmail(users.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("Não existe cliente com o ID: " + id));
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
