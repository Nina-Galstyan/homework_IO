package task5;

import java.io.*;
import java.util.Base64;

public class SerialDeserialByEncrypt {
    private static final String FILE_PATH = "C:\\Users\\Admin\\Documents\\git\\homework_IO\\src\\task4\\example";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customer customer = new Customer("Tigran", "077000000", 21, "1111 2222 555");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        String cardNumber = customer.getCardNumber();
        String encodeCardNumber = Base64.getEncoder().encodeToString(cardNumber.getBytes());
        customer.setCardNumber(encodeCardNumber);
        objectOutputStream.writeObject(customer);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        byte[] decode = Base64.getDecoder().decode(encodeCardNumber);
        String decodedCardNumber = new String(decode);
        customer.setCardNumber(decodedCardNumber);
        Object deserialization = objectInputStream.readObject();
        Customer deserCustomer = (Customer) deserialization;
        System.out.println(deserCustomer);
    }

}
