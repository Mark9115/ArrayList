package com.andersenlab;

import java.util.Arrays;
/**
 * implementation HomeworkArrayListInterface.
 */
public class HomeworkArrayListClass<T extends Comparable<T>> implements HomeworkArrayListInterface<T>
{
    private final int INITIAL_CAPACITY = 8;
    private int pointer = 0;
    private Object[] mainArray = new Object[INITIAL_CAPACITY];

    /**
     * Adding item of T object to static array.
     * Will increase two times array, if it is less than initial.
     * @param object - input parameter.
     */
    @Override
    public void add(T object)
    {
        if(pointer == mainArray.length - 1)
            resize(mainArray.length * 2);
        mainArray[pointer++] = object;
    }

    /**
     * Update item of T object.
     * Will update item by index.
     * @param index - input int.
     * @param object - input object T.
     * @throws IndexOutOfBoundsException if out of array.
     */
    @Override
    public void set(int index, T object) throws IndexOutOfBoundsException
    {
        checkRange(index);
        mainArray[index] = object;
    }

    /**
     * Getting item of T object by index.
     * @param index - input int.
     * @throws IndexOutOfBoundsException if out of array.
     * @return current object by index.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException
    {
        checkRange(index);
        return (T) mainArray[index];
    }

    /**
     * Deleting item of T object by index.
     * @param index - input int.
     * @throws IndexOutOfBoundsException if out of array.
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException
    {
        checkRange(index);
        // left side array
        Object[] tempLeftArray = Arrays.copyOf(mainArray, index);
        // right side array
        Object[] tempRightArray = Arrays.copyOfRange(mainArray, index + 1, pointer);
        // merging arrays
        System.arraycopy(tempLeftArray, 0, mainArray, 0, tempLeftArray.length);
        System.arraycopy(tempRightArray, 0, mainArray, tempLeftArray.length, tempRightArray.length);
        --pointer;
    }

    /**
     * Deleting item of T object.
     * Uses method equals to compare objects.
     * @param object - input object T.
     */
    @Override
    public void remove(T object)
    {
        for (int i = 0; i < pointer; ++i)
        {
            if (object.equals(mainArray[i]))
               this.remove(i);
        }
    }

    /**
     * Returns size of array.
     */
    @Override
    public int size()
    {
        return pointer;
    }

    /**
     * Sorting items of T object.
     * Uses mode definition.
     * @param mode - input int.
     * If mode = 0 => in ascending order.
     * If mode = 1 => in descending order.
     */
    @Override
    public void sort(int mode)
    {
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

    /**
     * Checking the array's capacity.
     * @param index - input int(array's length).
     */
    private void checkRange(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index > pointer - 1)
            throw new IndexOutOfBoundsException("Выход за пределы массива");
    }

    /**
     * Resizes the array.
     * @param newLength - input int(new array's length).
     */
    private void resize(int newLength)
    {
        //copping the original array & appending new slots
        mainArray = Arrays.copyOf(mainArray, newLength);
    }
}
