package com.climbtogether.climby.mapper;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.Province.ProvinceBuilder;
import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO;
import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO.ConsultationProvinceResponseDTOBuilder;
import com.climbtogether.climby.dto.CreateProvinceDTO;
import com.climbtogether.climby.dto.ModifiedProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO.ProvinceDTOBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-14T18:04:39+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class ProvinceMapperImpl implements ProvinceMapper {

    @Override
    public Province provinceDTOToprovince(ProvinceDTO provinceDTO) {
        if ( provinceDTO == null ) {
            return null;
        }

        ProvinceBuilder province = Province.builder();

        province.id( provinceDTO.getId() );
        province.name( provinceDTO.getName() );

        return province.build();
    }

    @Override
    public ProvinceDTO provinceToprovinceDTO(Province province) {
        if ( province == null ) {
            return null;
        }

        ProvinceDTOBuilder provinceDTO = ProvinceDTO.builder();

        provinceDTO.id( province.getId() );
        provinceDTO.name( province.getName() );

        return provinceDTO.build();
    }

    @Override
    public ConsultationProvinceResponseDTO provinceToConsultationProvinceResponseDTO(Province province) {
        if ( province == null ) {
            return null;
        }

        ConsultationProvinceResponseDTOBuilder consultationProvinceResponseDTO = ConsultationProvinceResponseDTO.builder();

        consultationProvinceResponseDTO.id( province.getId() );
        consultationProvinceResponseDTO.name( province.getName() );

        return consultationProvinceResponseDTO.build();
    }

    @Override
    public Province createProvinceDTOToProvince(CreateProvinceDTO createProvinceDTO) {
        if ( createProvinceDTO == null ) {
            return null;
        }

        ProvinceBuilder province = Province.builder();

        province.id( createProvinceDTO.getId() );
        province.name( createProvinceDTO.getName() );

        return province.build();
    }

    @Override
    public Province modifiedProvinceDTOToProvince(ModifiedProvinceDTO modifiedProvinceDTO) {
        if ( modifiedProvinceDTO == null ) {
            return null;
        }

        ProvinceBuilder province = Province.builder();

        province.id( modifiedProvinceDTO.getId() );
        province.name( modifiedProvinceDTO.getName() );

        return province.build();
    }
}
