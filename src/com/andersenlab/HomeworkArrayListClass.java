package com.andersenlab;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeworkArrayListClass<T extends Comparable<T>> implements HomeworkArrayListInterface<T>
{
    private final int INITIAL_CAPACITY = 8;
    private int pointer = 0;
    private Object[] mainArray = new Object[INITIAL_CAPACITY];

    @Override
    public void add(T object)
    {
        if(pointer == mainArray.length - 1)
            resize(mainArray.length * 2);
        mainArray[pointer++] = object;
    }

    @Override
    public void set(int index, T object) throws IndexOutOfBoundsException
    {
        checkRange(index);
        mainArray[index] = object;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException
    {
        checkRange(index);

        return (T) mainArray[index];
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException
    {
        checkRange(index);

        Object[] tempLeftArray = Arrays.copyOf(mainArray, index);
        Object[] tempRightArray = Arrays.copyOfRange(mainArray, index + 1, pointer);
        System.arraycopy(tempLeftArray, 0, mainArray, 0, tempLeftArray.length);
        System.arraycopy(tempRightArray, 0, mainArray, tempLeftArray.length, tempRightArray.length);
        --pointer;
    }

    @Override
    public void remove(T object)
    {
        for (int i = 0; i < pointer; ++i)
        {
            if (object.equals(mainArray[i]))
               this.remove(i);
        }
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public void sort(int mode) {
        for (int i = pointer - 1; i > 0; --i)
        {
            for (int j = 0; j < i ; ++j)
            {
                int resultComparison = ((T) mainArray[j]).compareTo((T) mainArray[i]);

                if (mode == 0 && resultComparison > 0)
                {
                    T temp = (T) mainArray[j];
                    mainArray[j] = mainArray[i];
                    mainArray[i] = temp;
                } else if (mode == 1 && resultComparison < 0)
                {
                    T temp = (T) mainArray[j];
                    mainArray[j] = mainArray[i];
                    mainArray[i] = temp;
                }
            }
        }
    }

    private void checkRange(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index > pointer - 1)
            throw new IndexOutOfBoundsException("Выход за пределы массива");
    }

    private void resize(int newLength)
    {
        mainArray = Arrays.copyOf(mainArray, newLength);
    }
}
