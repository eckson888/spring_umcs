package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository implements IUserRepository
{
    private ArrayList<User>userList=new ArrayList<>();

    public UserRepository() {
        this.userList = getFromCsv();
    }


    public void addUser(User user) throws IOException {
        userList.add(user);
        save();
    };
    @Override
    public User getUserObject(String login)
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

    public boolean checkLogin(String login)
    {
        for(User u: userList)
        {
            if(u.login.equals(login))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password)
    {
        password= DigestUtils.sha256Hex(password);
        for(User u: userList)
        {
            if(u.password.equals(password))
            {
                return true;
            }
        }
        return false;
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

    public ArrayList<User> getFromCsv()
    {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/users.csv")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(";");
                System.out.println(Arrays.toString(values));
                userList.add(new User(values[0],
                            values[1],
                            values[2],
                            values[3]) {});
                }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}