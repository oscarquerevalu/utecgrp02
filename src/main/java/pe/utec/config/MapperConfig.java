package pe.utec.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("customerMapper")
    public ModelMapper clientMapper(){
        return new ModelMapper();
    }
    @Bean("showMapper")
    public ModelMapper showMapper(){
        return new ModelMapper();
    }
    @Bean("saleMapper")
    public ModelMapper saleMapper(){
        return new ModelMapper();
    }

}
