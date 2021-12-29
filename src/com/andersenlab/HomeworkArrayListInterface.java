package com.andersenlab;

/**
 * Interface for implementing a dynamic array.
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
