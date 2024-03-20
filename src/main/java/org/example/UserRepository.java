package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserRepository implements IUserRepository
{
    private ArrayList<User>userList;

    @Override
    public User getUser(String login) {

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
}
