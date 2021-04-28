package br.com.ericpinto.user.service;

import br.com.ericpinto.user.dto.UserDTO;
import br.com.ericpinto.user.mappper.UserMapper;
import br.com.ericpinto.user.model.User;
import br.com.ericpinto.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId){
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserMapper::mapToDTO).orElse(null);
    }

    public UserDTO save(UserDTO userDTO){
        User user = userRepository.save(UserMapper.mapToUser(userDTO));
        return UserMapper.mapToDTO(user);
    }

    public void delete(long userId){
        findById(userId);
        userRepository.deleteById(userId);
    }

    public UserDTO findByLegalDocumentNumber(String legalDocumentNumber){
        User user = userRepository.findByLegalDocumentNumber(legalDocumentNumber);
        if (user != null){
            return UserMapper.mapToDTO(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name){
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream()
                .map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}
