package whu.iss.insurancesys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("whu.iss.insurancesys.dao")
public class InsurancesysApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsurancesysApplication.class, args);
    }

}