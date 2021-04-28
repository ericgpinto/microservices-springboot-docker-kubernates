package br.com.ericpinto.user.controller;

import br.com.ericpinto.user.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<>();
    @PostConstruct
    public	void	initiateList() {
        UserDTO	userDTO	=	new	UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua	a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());
        UserDTO	userDTO2	=	new	UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO.setEmail("luiz@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new	Date());
        UserDTO	userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua	c");
        userDTO.setEmail("bruna@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new	Date());
        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsuarios(){
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public	UserDTO	getUsersFiltro(@PathVariable String cpf){
        for (UserDTO userDTO: usuarios){
            if(userDTO.getCpf().equals(cpf)){
                return userDTO;
            }
        }
        return null;
    }

    @PostMapping("/users/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("users/{cpf}")
    public boolean remover(@PathVariable String cpf){
        for (UserDTO userDTO: usuarios){
            if(userDTO.getCpf().equals(cpf)){
                usuarios.remove(userDTO);
                return true;
            }
        }
        return false;
    }

}
