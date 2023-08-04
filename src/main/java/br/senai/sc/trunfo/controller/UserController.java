package br.senai.sc.trunfo.controller;

import br.senai.sc.trunfo.model.dto.UserRankingUpdateDTO;
import br.senai.sc.trunfo.model.dto.UserUpdateDTO;
import br.senai.sc.trunfo.model.entity.User;
import br.senai.sc.trunfo.model.exception.NotFoundException;
import br.senai.sc.trunfo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/saveAdmin")
//    public ResponseEntity<User> saveAdmin(@RequestBody @Valid UserDTO objectDTO) {
//        return ResponseEntity.ok(userService.save(objectDTO));
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<User> save(@RequestBody @Valid UserDTO objectDTO) {
//        List<Card> cards = new ArrayList<>();
//        for (long i = 1L; i <= 6L; i++) {
//            cards.add(cardService.list(i));
//        }
//        objectDTO.setCards(cards);
//        return ResponseEntity.ok(userService.save(objectDTO));
//    }

    @GetMapping("/listLogin/{username}/{password}")
    public ResponseEntity<User> listLogin(@PathVariable String username, @PathVariable String password) {
        try {
            return ResponseEntity.ok(userService.listLogin(username, password));
        } catch (NotFoundException e) {
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO objectDTO) {
        return ResponseEntity.ok(userService.update(id, objectDTO));
    }

    @PutMapping("/userRankingUpdate/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserRankingUpdateDTO objectDTO) {
        return ResponseEntity.ok(userService.update(id, objectDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
