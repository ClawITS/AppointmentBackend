package com.app.appointment_app.commons.application;

import com.app.appointment_app.commons.domain.mappers.SpecialityCommonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonsConfig {
    @Bean
    public SpecialityCommonMapper specialityCommonMapperConfig(){
        return new SpecialityCommonMapper();
    }
}
