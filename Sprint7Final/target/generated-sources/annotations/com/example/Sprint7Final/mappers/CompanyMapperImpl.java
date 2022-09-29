package com.example.Sprint7Final.mappers;

import com.example.Sprint7Final.dtos.CompanyDto;
import com.example.Sprint7Final.dtos.CompanyRequestDto;
import com.example.Sprint7Final.entities.Company;
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
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDto entityToDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId( company.getId() );
        companyDto.setCompanyName( company.getCompanyName() );
        companyDto.setCompanyDescription( company.getCompanyDescription() );

        return companyDto;
    }

    @Override
    public List<CompanyDto> entitiesToDtos(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>( companies.size() );
        for ( Company company : companies ) {
            list.add( entityToDto( company ) );
        }

        return list;
    }

    @Override
    public Company dtoToEntity(CompanyRequestDto companyRequestDto) {
        if ( companyRequestDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setCompanyName( companyRequestDto.getCompanyName() );
        company.setCompanyDescription( companyRequestDto.getCompanyDescription() );

        return company;
    }
}
