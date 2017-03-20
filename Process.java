import java.util.ArrayList;

public class Process {
  public static void main(String[] args) {
    ArrayList<LibraryItem> items = new ArrayList<>();

    Book b1 = new Book("t1", "p1");
    Book b2 = new Book("t2", "p2");
    DVD d1 = new DVD("n1", "f1");
    DVD d2 = new DVD("n2", "f2");
    Magazine m1 = new Magazine(new Date(2017, 3, 15), "sports");
    Magazine m2 = new Magazine(new Date(2016, 6, 21), "health");
    Magazine m3 = new Magazine(new Date(2016, 2, 13), "food");

    d2.setDescription("d2 description");
    m3.setDescription("m3 description");

    b1.setDueDate(new Date(2017, 3, 1));
    b2.setDueDate(new Date(2017, 3, 2));
    d1.setDueDate(new Date(2017, 3, 5));
    d2.setDueDate(new Date(2017, 3, 10));

    items.add(b1);
    items.add(b2);
    items.add(d1);
    items.add(d2);
    items.add(m1);
    items.add(m2);
    items.add(m3);

    Consumer<LibraryItem> c = (item) -> System.out.println(item);
    Consumer<String> c1 = (item) -> System.out.println(item);

    Predicate<LibraryItem> p = (item) -> { return item instanceof Book; };
    Predicate<LibraryItem> p1 = (item) -> {
        return item instanceof Borrowable && ((Borrowable)item).getDueDate().before(new Date(2017, 3, 7)); 
    };
  
    Function<LibraryItem, String> f = (item) -> { return item.getDescription(); };

    System.out.println("Printing the list of library items...");
    ListProcesser.forEach(items, c);

    System.out.println("\nPrinting the list of books...");
    ListProcesser.forEach(ListProcesser.filter(items, p), c);

    System.out.println("\nPrinting the list of library item descriptions...");
    ListProcesser.forEach(ListProcesser.map(items, f), c1);

    System.out.println("\nPrinting the list of overdue(3/7) library items...");
    ListProcesser.forEach(ListProcesser.filter(items, p1), c);

    System.out.println("\nPrinting the list of overdue(3/7) books...");
    ListProcesser.forEach(ListProcesser.filter(ListProcesser.filter(items, p), p1), c);    
  }  
}


/***************************************OUTPUT***************************************

➜  AssignmentC git:(master) ✗ java Process
Printing the list of library items...
Book: t1
Book: t2
DVD: n1
DVD: n2
Magazine in: sports
Magazine in: health
Magazine in: food

Printing the list of books...
Book: t1
Book: t2

Printing the list of library item descriptions...
null
null
null
d2 description
null
null
m3 description

Printing the list of overdue(3/7) library items...
Book: t1
Book: t2
DVD: n1

Printing the list of overdue(3/7) books...
Book: t1
Book: t2

**************************************END OUTPUT*************************************/