package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.CompanyDto;
import com.example.Sprint7Final.dtos.ProfileDto;
import com.example.Sprint7Final.dtos.TeamDto;
import com.example.Sprint7Final.dtos.UserRequestDto;
import com.example.Sprint7Final.dtos.UserResponseDto;
import com.example.Sprint7Final.entities.Company;
import com.example.Sprint7Final.entities.Credentials;
import com.example.Sprint7Final.entities.Profile;
import com.example.Sprint7Final.entities.Team;
import com.example.Sprint7Final.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T09:29:12-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public UserResponseDto entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUsername( userCredentialsUsername( user ) );
        userResponseDto.setId( user.getId() );
        userResponseDto.setProfile( profileToProfileDto( user.getProfile() ) );
        userResponseDto.setActive( user.isActive() );
        userResponseDto.setAdmin( user.isAdmin() );
        userResponseDto.setStatus( user.getStatus() );
        userResponseDto.setTeam( teamToTeamDto( user.getTeam() ) );
        userResponseDto.setCompany( companyToCompanyDto( user.getCompany() ) );

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> entitiesToDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( users.size() );
        for ( User user : users ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }

    @Override
    public User dtoToEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userRequestDto.getId() );
        user.setCredentials( credentialsMapper.dtoToEntity( userRequestDto.getCredentials() ) );
        if ( userRequestDto.getActive() != null ) {
            user.setActive( userRequestDto.getActive() );
        }
        if ( userRequestDto.getAdmin() != null ) {
            user.setAdmin( userRequestDto.getAdmin() );
        }
        user.setStatus( userRequestDto.getStatus() );
        user.setTeam( teamDtoToTeam( userRequestDto.getTeam() ) );
        user.setCompany( companyDtoToCompany( userRequestDto.getCompany() ) );

        return user;
    }

    private String userCredentialsUsername(User user) {
        if ( user == null ) {
            return null;
        }
        Credentials credentials = user.getCredentials();
        if ( credentials == null ) {
            return null;
        }
        String username = credentials.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected ProfileDto profileToProfileDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.setFirstName( profile.getFirstName() );
        profileDto.setLastName( profile.getLastName() );
        profileDto.setEmail( profile.getEmail() );
        profileDto.setPhone( profile.getPhone() );

        return profileDto;
    }

    protected CompanyDto companyToCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId( company.getId() );
        companyDto.setCompanyName( company.getCompanyName() );
        companyDto.setCompanyDescription( company.getCompanyDescription() );

        return companyDto;
    }

    protected TeamDto teamToTeamDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setTeamName( team.getTeamName() );
        teamDto.setTeamDescription( team.getTeamDescription() );
        teamDto.setTeamCompany( companyToCompanyDto( team.getTeamCompany() ) );

        return teamDto;
    }

    protected Company companyDtoToCompany(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyDto.getId() );
        company.setCompanyName( companyDto.getCompanyName() );
        company.setCompanyDescription( companyDto.getCompanyDescription() );

        return company;
    }

    protected Team teamDtoToTeam(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamDto.getId() );
        team.setTeamName( teamDto.getTeamName() );
        team.setTeamDescription( teamDto.getTeamDescription() );
        team.setTeamCompany( companyDtoToCompany( teamDto.getTeamCompany() ) );

        return team;
    }
}
