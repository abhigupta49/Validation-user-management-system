package org.AbhishekKumar.configuration;

import org.AbhishekKumar.model.User;
import org.AbhishekKumar.model.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<User> getuserList(){
        User defaultUser = new User(0,"gouthamPeddi", LocalDate.of(2001,5,15),"peddigoutham93172@gmail.com","gouthaM@1","830960000000",LocalDate.of(2023,6,29),LocalTime.now(Clock.systemDefaultZone()),Type.ADMIN,22);
        List<User> userList = new ArrayList<>();
        userList.add(defaultUser);
        return userList;
    }
}
