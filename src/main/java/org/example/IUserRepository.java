package org.example;

import java.io.IOException;
import java.util.ArrayList;

public interface IUserRepository
{
    User getUserObject(String login);

    public ArrayList<User> getUsers();
    public void save() throws IOException;
}
