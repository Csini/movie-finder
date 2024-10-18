package hu.exercise.movie.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.exercise.movie.dozer.OffsetDateTimeConverter;

@Configuration
public class MapperConfiguration {
	
	@Autowired
	OffsetDateTimeConverter offsetDateTimeConverter;
	
	@Bean
	public ModelMapper getMapper() {
		ModelMapper mapper = new ModelMapper(); 
		mapper.addConverter(offsetDateTimeConverter);
		return mapper;
	}
}
