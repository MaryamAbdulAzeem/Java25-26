public class BooksExpenses {
    private String name;
    private String ID;
    private int num_books;
    private double amount;

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getNum_books() {
        return num_books;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNum_books(int num_books) {
        this.num_books = num_books;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void buyMoreBooks(int num, double cost) {
        num_books += num;
        amount += cost;
    }

    public void sellBooks(int num, double cost) {
        num_books -= num;
        amount -= cost;
    }

    public BooksExpenses(String name, String ID, int num_books, double amount) {
        this.name = name;
        this.ID = ID;
        this.num_books = num_books;
        this.amount = amount;
    }

    public static void main(String[] args) {
        BooksExpenses bookInfo = new BooksExpenses("Ali", "u202110324", 2, 345.0);
        System.out.println("Name: " + bookInfo.getName() + ", id " + bookInfo.getID() + ", number of Books: " + bookInfo.getNum_books() + ", Cost: " +
                bookInfo.getAmount());

        System.out.print("The info after buying 3 more books for AED 700 is: ");
        bookInfo.buyMoreBooks(3, 700);
        System.out.println("Name: " + bookInfo.getName() + ", id " + bookInfo.getID() + ", number of Books: " + bookInfo.getNum_books() + ", Cost: " +
                bookInfo.getAmount());

        System.out.print("The info after selling 2 books for AED 345 is: ");
        bookInfo.sellBooks(2, 345);
        System.out.println("Name: " + bookInfo.getName() + ", id " + bookInfo.getID() + ", number of Books: " + bookInfo.getNum_books() + ", Cost: " +
                bookInfo.getAmount());
    }
}
