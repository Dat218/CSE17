public class SimpleMain {
  public static void main(String[] args) {
    Store myStore = new Store();
    Book b = new Book(111, "The Hobbit", "J.R.R. Tolkien", 5.99);
    myStore.addItem(b, 10);
    Book c = new Book(112, "Adventures of Oscar Wao", "Daniel Truong", 8.99);
    myStore.addItem(c, 15);
    Shirt s = new Shirt(113, "Tee Shirt, Plain", "Large", "Black", 15.99);
    myStore.addItem(s, 20);
    Shirt g = new Shirt(114, "Tee Shirt, Plain", "Small", "Black", 15.99);
    myStore.addItem(g, 20);
    Shirt f = new Shirt(115, "Tee Shirt, Plain", "Medium", "Black", 15.99);
    myStore.addItem(f, 20);
    myStore.showInventory();
    System.out.println();
    
    Order o;
    o = new Order("M. Doughty", 112, 1);
    myStore.makeSale(o);
    System.out.println("Total Sales: $" + myStore.getTotalSales());
    System.out.println();
    
    o = new Order("M. Doughty", 115, 6);
    myStore.makeSale(o);
    System.out.println("Total Sales: $" + myStore.getTotalSales());
    System.out.println();
    
    o = new Order("Yuval Gabay", 111, 100);
    myStore.makeSale(o);
    System.out.println("Total Sales: $" + myStore.getTotalSales());
    System.out.println();
    
    o = new Order("M. Doughty", 116, 1);
    myStore.makeSale(o);
    System.out.println("Total Sales: $" + myStore.getTotalSales());
    System.out.println();
    
    myStore.showInventory();
  }
}
