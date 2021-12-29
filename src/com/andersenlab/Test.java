package com.andersenlab;

import java.util.Objects;

class User implements Comparable<User>
{
    private Integer id;
    private String name;
    User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User object) {

        return this.id.compareTo(object.id);
    }
}

public class Test {
    static void printData(HomeworkArrayListClass<?> collection)
    {
        System.out.println("------------------");
        for (int i = 0; i < collection.size(); ++i)
        {
            System.out.println(collection.get(i));
        }
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        HomeworkArrayListClass<User> users = new HomeworkArrayListClass<>();
        //Добавление пользователей
        users.add(new User(1,"Alex"));
        users.add(new User(4,"Jack"));
        users.add(new User(3,"Charley"));
        users.add(new User(5,"Oleg"));
        users.add(new User(2,"Thomas"));
        users.add(new User(98,"Albert"));

        //Изменение пользователя
        users.set(0,new User(11,"Harry"));

        //удаление пользователя

        //Вывод списка
        printData(users);

        System.out.println("Сортировка");
        users.sort(0);

        //Вывод списка
        printData(users);
        /*
        HomeworkArrayListClass<String> test = new HomeworkArrayListClass<>();
        String newItem = "Какая замена";

        for (int i = 0; i < 5; ++i) {
            test.add("Hello" + i);
        }

        test.set(2, newItem);


        System.out.println("------------------");
        System.out.println("Список элементов по индексу:");
        for (int i = 0; i < test.size(); ++i)
        {
            System.out.println(test.get(i));
        }
        System.out.println("------------------");
        System.out.println("Вывод индекса по значению:");
        System.out.println(test.get("Hello3"));
        System.out.println("------------------");
        System.out.println("Количество элементов: " + test.size());
        System.out.println("------------------");
        System.out.println("Удаление элемента по индексу:");
        test.remove(0);
        for (int i = 0; i < test.size(); ++i)
        {
            System.out.println(test.get(i));
        }
        System.out.println("------------------");
        */

    }
}
