package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Auth {
    public boolean checkCredentials(String login, String password) {
        String hashedPW = DigestUtils.sha256Hex(password);
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/users.csv")))
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values[0].equals(login) && values[1].equals(hashedPW)) {
                    System.out.println("Dane poprawne");
                    return true;
                }
                else
                {
                    System.out.println("Błąd danych");
                    return false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}