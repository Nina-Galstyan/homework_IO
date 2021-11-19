package task4;

import task2.model.Customer;

import java.io.*;

public class SerializationCustomer {
    private static final String FILE_PATH="C:\\Users\\Admin\\Documents\\git\\homework_IO\\src\\task4\\example";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customer customer = new Customer("Aram","091000000",40);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        objectOutputStream.writeObject(customer);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Object deserialization = objectInputStream.readObject();
            Customer customer1 = (Customer) deserialization;
            System.out.println(customer1);
        }

    }
