package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.CredentialsDto;
import com.example.Sprint7Final.entities.Credentials;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T09:29:12-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class CredentialsMapperImpl implements CredentialsMapper {

    @Override
    public Credentials dtoToEntity(CredentialsDto credentialsDto) {
        if ( credentialsDto == null ) {
            return null;
        }

        Credentials credentials = new Credentials();

        credentials.setUsername( credentialsDto.getUsername() );
        credentials.setPassword( credentialsDto.getPassword() );

        return credentials;
    }
}
