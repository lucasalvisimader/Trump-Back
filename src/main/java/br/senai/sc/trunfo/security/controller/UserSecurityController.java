package br.senai.sc.trunfo.security.controller;

import br.senai.sc.trunfo.security.model.dto.UserSecurityDTO;
import br.senai.sc.trunfo.security.model.entity.UserSecurity;
import br.senai.sc.trunfo.security.service.UserSecurityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/user")
public class UserSecurityController {

    private UserSecurityService userSecurityService;

    @Autowired
    private void setUserService(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    @PostMapping("/saveAdmin")
    public ResponseEntity<UserSecurity> saveAdmin(@RequestBody @Valid UserSecurityDTO objectDTO) {
        return ResponseEntity.ok(userSecurityService.save(objectDTO));
    }

    @PostMapping("/save")
    public ResponseEntity<UserSecurity> save(@RequestBody @Valid UserSecurityDTO objectDTO) {
        return ResponseEntity.ok(userSecurityService.save(objectDTO));
    }
}
