package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.CompanyDto;
import com.example.Sprint7Final.dtos.ProjectRequestDto;
import com.example.Sprint7Final.dtos.ProjectResponseDto;
import com.example.Sprint7Final.dtos.TeamDto;
import com.example.Sprint7Final.entities.Company;
import com.example.Sprint7Final.entities.Project;
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
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public List<ProjectResponseDto> entitiesToResponseDtos(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectResponseDto> list = new ArrayList<ProjectResponseDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( entityToResponseDto( project ) );
        }

        return list;
    }

    @Override
    public ProjectResponseDto entityToResponseDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();

        projectResponseDto.setId( project.getId() );
        projectResponseDto.setName( project.getName() );
        projectResponseDto.setDescription( project.getDescription() );
        projectResponseDto.setTimePosted( project.getTimePosted() );
        projectResponseDto.setActive( project.getActive() );
        projectResponseDto.setTeamOnProject( teamToTeamDto( project.getTeamOnProject() ) );

        return projectResponseDto;
    }

    @Override
    public Project requestDtoToEntity(ProjectRequestDto projectRequestDto) {
        if ( projectRequestDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setName( projectRequestDto.getName() );
        project.setDescription( projectRequestDto.getDescription() );
        project.setActive( projectRequestDto.getActive() );

        return project;
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
}
