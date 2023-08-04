package br.senai.sc.trunfo.security.service;

import br.senai.sc.trunfo.model.entity.Card;
import br.senai.sc.trunfo.model.entity.User;
import br.senai.sc.trunfo.security.model.dto.UserSecurityDTO;
import br.senai.sc.trunfo.security.model.entity.UserSecurity;
import br.senai.sc.trunfo.security.repository.UserSecurityRepository;
import br.senai.sc.trunfo.service.CardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserSecurityService {
    private final UserSecurityRepository repository;
    private final CardService service;

    public UserSecurity save(@RequestBody @Valid UserSecurityDTO objectDTO) {
        List<Card> cards = new ArrayList<>();
        for (long i = 1L; i <= 6L; i++) {
            cards.add(service.list(i));
        }
        User user = new User(objectDTO.getUsername(), new BCryptPasswordEncoder().encode(objectDTO.getPassword()));
        user.setCards(cards);
        UserSecurity userSecurity = new UserSecurity();
        userSecurity.setUser(user);
        return repository.save(userSecurity);
    }
}
