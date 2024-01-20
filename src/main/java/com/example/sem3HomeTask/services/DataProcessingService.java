package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Метод сортировки по возрасту
     * @param users
     * @return
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод фильтрации пользователей по возрасту
     * @param users
     * @param age
     * @return
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод расчёт среднего возраста
     * @param users
     * @return
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод добавления в лист пользователя
     * @param user
     */
    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

}
