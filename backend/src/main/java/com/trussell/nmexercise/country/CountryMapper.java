package com.trussell.nmexercise.country;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

	@Mapping(source="alpha2", target="isoCode")
	CountryView entityToView(CountryEntity entity);

}
