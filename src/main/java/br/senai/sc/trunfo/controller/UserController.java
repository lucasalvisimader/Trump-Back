package br.senai.sc.trunfo.controller;

import br.senai.sc.trunfo.model.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import br.senai.sc.trunfo.model.dto.UserRankingUpdateDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import br.senai.sc.trunfo.service.UserService;
import br.senai.sc.trunfo.model.dto.UserDTO;
import br.senai.sc.trunfo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;

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

    public void saveAdmin(@RequestBody @Valid UserDTO objectDTO) {
        ResponseEntity.ok(userService.save(objectDTO));
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody @Valid UserDTO objectDTO) {
        return ResponseEntity.ok(userService.saveUser(objectDTO));
    }

//    @PreAuthorize("permitAll()")
//    @GetMapping("/listLogin/{username}/{password}")
//    public ResponseEntity<User> listLogin(@PathVariable String username, @PathVariable String password) {
//        try {
//            return ResponseEntity.ok(userService.listLogin(username, password));
//        } catch (NotFoundException e) {
//            return ResponseEntity.ok().build();
//        }
//    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO objectDTO) {
        return ResponseEntity.ok(userService.update(id, objectDTO));
    }

    @PreAuthorize("hasAuthority('PLAYER')")
    @PutMapping("/userRankingUpdate/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserRankingUpdateDTO objectDTO) {
        return ResponseEntity.ok(userService.update(id, objectDTO));
    }

    @PreAuthorize("hasAuthority('PLAYER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
