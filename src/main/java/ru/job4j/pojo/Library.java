package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book science = new Book("Science", 1500);
        Book horror = new Book("Horror", 450);
        Book classic = new Book("Classic", 700);
        Book fantasy = new Book("Clean code", 370);

        Book[] books = new Book[4];
        books[0] = science;
        books[1] = horror;
        books[2] = classic;
        books[3] = fantasy;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " " + bk.getPageCount());
        }
        System.out.println();

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " " + bk.getPageCount());
        }
        System.out.println();

        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " " + bk.getPageCount());
            }
        }
    }
}
