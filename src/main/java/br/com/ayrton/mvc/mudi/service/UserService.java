package br.com.ayrton.mvc.mudi.service;

import br.com.ayrton.mvc.mudi.model.User;
import br.com.ayrton.mvc.mudi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User buscarPorNome(String nome){
        return userRepository.findByUsername(nome);
    }
}
