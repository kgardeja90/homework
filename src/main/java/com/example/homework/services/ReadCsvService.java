package com.example.homework.services;

import java.util.List;

public interface ReadCsvService<T> {
    List<T> readCsv(List<String> paths);
}
