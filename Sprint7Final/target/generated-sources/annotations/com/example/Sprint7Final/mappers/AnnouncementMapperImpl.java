package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.AnnouncementRequestDto;
import com.example.Sprint7Final.dtos.AnnouncementResponseDto;
import com.example.Sprint7Final.dtos.CompanyDto;
import com.example.Sprint7Final.dtos.ProfileDto;
import com.example.Sprint7Final.dtos.TeamDto;
import com.example.Sprint7Final.dtos.UserResponseDto;
import com.example.Sprint7Final.entities.Announcement;
import com.example.Sprint7Final.entities.Company;
import com.example.Sprint7Final.entities.Profile;
import com.example.Sprint7Final.entities.Team;
import com.example.Sprint7Final.entities.User;
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
public class AnnouncementMapperImpl implements AnnouncementMapper {

    @Override
    public List<AnnouncementResponseDto> entitiesToDtos(List<Announcement> announcements) {
        if ( announcements == null ) {
            return null;
        }

        List<AnnouncementResponseDto> list = new ArrayList<AnnouncementResponseDto>( announcements.size() );
        for ( Announcement announcement : announcements ) {
            list.add( entityToDto( announcement ) );
        }

        return list;
    }

    @Override
    public Announcement dtoToEntity(AnnouncementRequestDto announcementRequestDto) {
        if ( announcementRequestDto == null ) {
            return null;
        }

        Announcement announcement = new Announcement();

        announcement.setId( announcementRequestDto.getId() );
        announcement.setTitle( announcementRequestDto.getTitle() );
        announcement.setMessage( announcementRequestDto.getMessage() );

        return announcement;
    }

    @Override
    public AnnouncementResponseDto entityToDto(Announcement announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementResponseDto announcementResponseDto = new AnnouncementResponseDto();

        announcementResponseDto.setTimePosted( announcement.getTimePosted() );
        announcementResponseDto.setTitle( announcement.getTitle() );
        announcementResponseDto.setMessage( announcement.getMessage() );
        announcementResponseDto.setCompanyMakingAnnouncement( companyToCompanyDto( announcement.getCompanyMakingAnnouncement() ) );
        announcementResponseDto.setAuthor( userToUserResponseDto( announcement.getAuthor() ) );

        return announcementResponseDto;
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

    protected UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( user.getId() );
        userResponseDto.setProfile( profileToProfileDto( user.getProfile() ) );
        userResponseDto.setActive( user.isActive() );
        userResponseDto.setAdmin( user.isAdmin() );
        userResponseDto.setStatus( user.getStatus() );
        userResponseDto.setTeam( teamToTeamDto( user.getTeam() ) );
        userResponseDto.setCompany( companyToCompanyDto( user.getCompany() ) );

        return userResponseDto;
    }
}
