package com.shark.sharkbank;

import com.shark.sharkbank.auth_users.entity.User;
import com.shark.sharkbank.enums.NotificationType;
import com.shark.sharkbank.notification.dtos.NotificationDTO;
import com.shark.sharkbank.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@RequiredArgsConstructor
public class SharkbankApplication {

//    private final NotificationService notificationService;
	public static void main(String[] args) {

        SpringApplication.run(SharkbankApplication.class, args);

	}

//    @Bean
//    CommandLineRunner runner(){
//        return args -> {
//            NotificationDTO notificationDTO = NotificationDTO.builder()
//                    .recipient("nnson1209@gmail.com")
//                    .subject("Hello testing email")
//                    .body("This is testing email")
//                    .type(NotificationType.EMAIL)
//                    .build();
//
//            notificationService.sendEmail(notificationDTO, new User());
//        };
//    }

}
