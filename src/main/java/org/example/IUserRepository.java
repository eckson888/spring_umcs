package org.example;

import java.io.IOException;
import java.util.ArrayList;

public interface IUserRepository
{
    public User getUser(String login);
    public ArrayList<User> getUsers();
    public void save() throws IOException;
}
