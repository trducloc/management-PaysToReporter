package entity;

import java.util.Scanner;

public class PostType implements InputTable {
    private static int AUTO_ID = 100;
    private int id;
    private String postName;
    private double price;


    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PostType{" +
                "id=" + id +
                ", postName='" + postName + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public void inputInfo() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên kiểu bài: ");
        this.setPostName(new Scanner(System.in).nextLine());
        System.out.print("Nhập đơn giá: ");
        this.setPrice(new Scanner(System.in).nextInt());
    }
}


