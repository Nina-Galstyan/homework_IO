package task2.util;

import task2.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileMaker {
    private static final String FILE_PATH = "homework_IO/src/task2/customerData";
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Please input file name");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(FILE_PATH + fileName);
        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNext()) {
                String fields = scanner1.nextLine();
                String[] splitField = fields.split(",");
                Customer customer = new Customer(splitField[0], splitField[1], Integer.parseInt(splitField[3]));
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<Customer> collect = customers.stream()
                .sorted(Comparator.comparingInt(Customer::getScore))
                .collect(Collectors.toList());

        File file1 = new File(FILE_PATH + "sorted");
        try (OutputStream outputStream = new FileOutputStream(file1)) {
            for (Customer customer : collect) {
                String name = customer.getName();
                String phone = customer.getPhone();
                int score = customer.getScore();
                String sortedCustomer = name + "," + phone + "," + score;
                outputStream.write(sortedCustomer.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
