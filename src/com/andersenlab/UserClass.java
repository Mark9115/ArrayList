package com.andersenlab;

import java.util.Objects;

/**
 * Example class is for testing main features of HomeworkArrayListClass.
 */
class UserClass implements Comparable<UserClass>
{
    private Integer id;
    private String name;
    UserClass(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClass user = (UserClass) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(UserClass object)
    {
        return this.id.compareTo(object.id);
    }
}
