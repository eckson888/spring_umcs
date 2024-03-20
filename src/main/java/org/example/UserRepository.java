package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserRepository implements IUserRepository
{
    private ArrayList<User>userList=new ArrayList<>();

    public void addUser(User user) throws IOException {
        userList.add(user);
        save();
    };
    @Override
    public User getUser(String login)
    {
        for(User u: userList)
        {
            if(u.login.equals(login))
            {
                return u;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.userList;
    }

    @Override
    public void save() throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/users.csv");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.flush();
        printWriter.write("");
        for(User u: userList)
        {
            printWriter.printf(u.toCsv());
        }
        printWriter.close();
        fileWriter.close();
    }
}