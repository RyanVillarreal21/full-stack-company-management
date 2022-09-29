package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.CompanyDto;
import com.example.Sprint7Final.dtos.TeamRequestDto;
import com.example.Sprint7Final.dtos.TeamResponseDto;
import com.example.Sprint7Final.entities.Company;
import com.example.Sprint7Final.entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T09:29:12-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team teamRequestDtoToEntity(TeamRequestDto teamRequestDto) {
        if ( teamRequestDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( teamRequestDto.getTeamName() );
        team.setTeamDescription( teamRequestDto.getTeamDescription() );

        return team;
    }

    @Override
    public TeamResponseDto entityToResponseDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamResponseDto teamResponseDto = new TeamResponseDto();

        teamResponseDto.setId( team.getId() );
        teamResponseDto.setTeamName( team.getTeamName() );
        teamResponseDto.setTeamDescription( team.getTeamDescription() );
        teamResponseDto.setTeamCompany( companyToCompanyDto( team.getTeamCompany() ) );

        return teamResponseDto;
    }

    @Override
    public List<TeamResponseDto> entitiesToResponseDtos(List<Team> team) {
        if ( team == null ) {
            return null;
        }

        List<TeamResponseDto> list = new ArrayList<TeamResponseDto>( team.size() );
        for ( Team team1 : team ) {
            list.add( entityToResponseDto( team1 ) );
        }

        return list;
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
}
