package com.andersenlab;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("Custom Class:\n-----------------------------------------");
        {
            HomeworkArrayListClass<UserClass> users = new HomeworkArrayListClass<>();
            //Adding new users
            users.add(new UserClass(1,"Alex"));
            users.add(new UserClass(4,"Jack"));
            users.add(new UserClass(3,"Charley"));
            users.add(new UserClass(5,"Oleg"));
            users.add(new UserClass(2,"Thomas"));
            users.add(new UserClass(98,"Albert"));

            //Updating the user
            users.set(0,new UserClass(11,"Harry"));

            //Deleting user by id
            users.remove(2);
            //Deleting user by object
            users.remove(new UserClass(98,"Albert"));

            printData(users);

            System.out.println("Sorting");
            users.sort(0);

            printData(users);
        }
        System.out.println("-----------------------------------------");

        System.out.println("Integer:\n-----------------------------------------");
        {
            HomeworkArrayListClass<Integer> integers = new HomeworkArrayListClass<>();

            integers.add(1);
            integers.add(14);
            integers.add(45);
            integers.add(2);
            integers.add(9);
            integers.add(5);

            integers.set(1,222);

            integers.remove(5);
            integers.remove(Integer.valueOf(222));

            printData(integers);

            System.out.println("Sorting");
            integers.sort(1);

            printData(integers);
        }
        System.out.println("-----------------------------------------");

        System.out.println("String:\n-----------------------------------------");
        {
            HomeworkArrayListClass<String> strings = new HomeworkArrayListClass<>();

            strings.add("yesterday");
            strings.add("seemed");
            strings.add("troubles");
            strings.add("though");
            strings.add("here");
            strings.add("stay");

            strings.set(5,"end");

            strings.remove(4);
            strings.remove("yesterday");

            printData(strings);

            System.out.println("Sorting");
            strings.sort(0);

            printData(strings);
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * Prints list items.
     * @param collection - input instance of HomeworkArrayListClass.
     */
    static void printData(HomeworkArrayListClass<?> collection)
    {
        System.out.println("------------------");
        for (int i = 0; i < collection.size(); ++i)
        {
            System.out.println(collection.get(i));
        }
        System.out.println("------------------");
    }
}
