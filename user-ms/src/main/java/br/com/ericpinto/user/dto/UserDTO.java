package br.com.ericpinto.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDTO {

    private String name;
    private String legalDocumentNumber;
    private String address;
    private String email;
    private String cellPhone;
    private Date registrationDate;
}
