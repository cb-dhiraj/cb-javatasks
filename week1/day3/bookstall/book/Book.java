package week1.day3.bookstall.book;
import week1.day3.bookstall.author.Author;

import java.util.*;

public class Book {
    String name;
    Author[] authors;
    Author author;
    double price;
    int qtyInStock = 0;

    Book(String name, Author[] authors, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.authors = authors;
    }

    Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public Author[] getAuthors() {
        return this.authors;
    }

    public Author getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public String toDisplay(String bookName, Map<String, Book> booksList) {
        Book bookAuthors = booksList.get(bookName);
        String authorDetails = "";
        if (bookAuthors.getAuthors() != null) {
            Author[] authorObj = bookAuthors.getAuthors();
            int authorObjLen = authorObj.length;
            int i = 0;
            while (i < authorObjLen) {
                authorDetails += authorObj[i].toDisplay() + ", ";
            }
            return bookName + " by " + authorDetails + "\n" + "Price : " + bookAuthors.getPrice() + "\n" + "No Of Books Available : " + bookAuthors.getQtyInStock();
        } else {
            Author authorObj = bookAuthors.getAuthor();
            authorDetails += authorObj.toDisplay();
            return bookName + " by " + authorDetails + "\n" + "Price : " + bookAuthors.getPrice() + "\n" + "No Of Books Available : " + bookAuthors.getQtyInStock();
        }
    }

    public void printAuthors(String bookName, Map<String, Book> booksList) {
        Book bookAuthors = booksList.get(bookName);
        if (bookAuthors.getAuthors() != null) {
            Author[] authorObj = bookAuthors.getAuthors();
            int authorObjLen = authorObj.length;
            int i = 0;
            while (i < authorObjLen) {
                System.out.println(authorObj[i].getName());
                i++;
            }
        } else {
            Author authorObj = bookAuthors.getAuthor();
            System.out.println(authorObj.getName());
        }
    }

    public void addAuthor(Author author, String bookName, Map<String, Book> booksList) {
        Book book = booksList.get(bookName);
        if(book.getAuthors()!=null){
            Author[] oldAuthors = book.getAuthors();
            int authorsLength = book.getAuthors().length;
            Author[] newAuthor = new Author[authorsLength+1];
            int i=0;
            while(i<authorsLength){
                newAuthor[i] = oldAuthors[i];
                i++;
            }
            newAuthor[i] = author;
            booksList.put(bookName,new Book(bookName, newAuthor, book.price, book.qtyInStock));
        }
        else{
            Author[] newAuthor = new Author[2];
            newAuthor[0] = book.getAuthor();
            newAuthor[1] = author;
            booksList.put(bookName,new Book(bookName, newAuthor, book.price, book.qtyInStock));
        }
    }

    public static void main(String[] args) {
        Map<String, Book> booksList = new HashMap<String, Book>();
        Scanner inp = new Scanner(System.in);
        System.out.println("Number of Books you want to add?");
        int noOfBooks = inp.nextInt();
        inp.nextLine();
        while (noOfBooks-- > 0) {
            System.out.println("Book Name: ");
            String bookName = inp.nextLine();
            System.out.println("How many authors for this Book? ");
            int noOfAuthors = inp.nextInt();
            String authorName, authorEmail;
            char authorGender;
            int qtyInStock = 0;
            double price;
            if (noOfAuthors > 1) {
                int i = 0;
                Author[] authors = new Author[noOfAuthors];
                while (noOfAuthors-- > 0) {
                    inp.nextLine();
                    System.out.println("Author name: ");
                    authorName = inp.nextLine();
                    System.out.println("Author email: ");
                    authorEmail = inp.nextLine();
                    System.out.println("Author Gender(M or F): ");
                    authorGender = inp.next().charAt(0);
                    authors[i] = new Author(authorName, authorEmail, authorGender);
                    i++;
                }
                System.out.println("Book Price: ");
                price = inp.nextDouble();
                System.out.println("Quantity: ");
                qtyInStock = inp.nextInt();
                booksList.put(bookName, new Book(bookName, authors, price, qtyInStock));
            } else {
                inp.nextLine();
                System.out.println("Author name: ");
                authorName = inp.nextLine();
                System.out.println("Author email: ");
                authorEmail = inp.nextLine();
                System.out.println("Author gender: ");
                authorGender = inp.next().charAt(0);
                Author author = new Author(authorName, authorEmail, authorGender);
                System.out.println("Book Price: ");
                price = inp.nextDouble();
                System.out.println("Quantity: ");
                qtyInStock = inp.nextInt();
                booksList.put(bookName, new Book(bookName, author, price, qtyInStock));
            }
        }
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add Author for Particular book \n 2. Display the authors for a particular book \n 3. Display the Details of a book \n 4. Exit \n Choice??: ");
            int choice = inp.nextInt();
            if (choice != 4) {
                inp.nextLine();
                System.out.println("Enter book name: ");
                String bookName = inp.nextLine();
                if (choice == 1) {
                    System.out.println("Enter author name: ");
                    String authorName = inp.nextLine();
                    System.out.println("Enter author email: ");
                    String authorEmail = inp.nextLine();
                    System.out.println("Enter Gender: ");
                    char authorGender = inp.next().charAt(0);
                    Book book = booksList.get(bookName);
                    book.addAuthor(new Author(authorName, authorEmail, authorGender), bookName, booksList);
                }
                else if(choice == 2){
                    Book book = booksList.get(bookName);
                    book.printAuthors(bookName, booksList);
                }
                else if(choice == 3){
                    Book book = booksList.get(bookName);
                    System.out.println(book.toDisplay(bookName,booksList));
                }
            } else {
                flag = false;
            }
        }
    }
}
