package com.example.assignment.service;

import java.util.List;
import java.util.UUID;

public interface BehaviorService<T> {

    List<T> getList();

    T getByID(UUID id);

    Boolean save(T e);

    Boolean update(T e);

    Boolean delete(T e);

    List<T> findByName(String name);

    String CheckForm(T e);

}
