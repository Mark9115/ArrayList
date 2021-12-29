package com.andersenlab;

/**
 * Интерфейс для для реализации динамического массива.
 */
public interface HomeworkArrayListInterface<T>
{
    void add (T t);
    T get(int index);
    void set(int index, T t);
    void remove(int index);
    void remove(T t);
    int size();
    void sort(int mode);
}
