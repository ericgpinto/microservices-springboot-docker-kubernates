package br.com.ericpinto.user.controller;

import br.com.ericpinto.user.dto.UserDTO;
import br.com.ericpinto.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/newUser")
    UserDTO newUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public	UserDTO	getUsersFiltro(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/legalDocumentNumber/{legalDocumentNumber}")
    public	UserDTO	findByLegalDocumentNumber(@PathVariable String legalDocumentNumber){
        return userService.findByLegalDocumentNumber(legalDocumentNumber);
    }

    @GetMapping("/namesearch")
    public List<UserDTO> queryByName(@RequestParam(name = "name", required = true) String name){
        return userService.queryByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
