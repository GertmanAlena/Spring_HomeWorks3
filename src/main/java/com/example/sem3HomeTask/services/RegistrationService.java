package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Регистрация пользователей
 */
@Service
public class RegistrationService {

    /**
     * Поле сервиса создания пользователей
     */
    private final UserService userService;

    /**
     * Поле сервиса уведомлений
     */
    private final NotificationService notificationService;

    /**
     * Поле сервиса работы с данными пользователей
     */
    private final DataProcessingService dataProcessingService;

    /**
     * Конструктор
     * @param userService
     * @param notificationService
     * @param dataProcessingService
     */
    public RegistrationService(UserService userService,
                               NotificationService notificationService,
                               DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * Поулчение сервиса работы с данными пользователей
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Добавление нового пользователя в бд
     * @param name
     * @param age
     * @param email
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Пользователь добавлен.");
    }
}
