package br.com.ericpinto.user.mappper;

import br.com.ericpinto.user.dto.UserDTO;
import br.com.ericpinto.user.model.User;

public class UserMapper {

    public static User mapToDTO(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .legalDocumentNumber(userDTO.getLegalDocumentNumber())
                .email(userDTO.getEmail())
                .cellPhone(userDTO.getCellPhone())
                .registrationDate(userDTO.getRegistrationDate())
                .build();
    }

    public static UserDTO mapToUser(User user){
        return UserDTO.builder()
                .name(user.getName())
                .address(user.getAddress())
                .legalDocumentNumber(user.getLegalDocumentNumber())
                .email(user.getEmail())
                .cellPhone(user.getCellPhone())
                .registrationDate(user.getRegistrationDate())
                .build();
    }
}
