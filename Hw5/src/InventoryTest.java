import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/** This class is used to test a generic Inventory class. */
public class InventoryTest {
  
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat basicDates = new SimpleDateFormat("MM/dd/yy");
    Inventory<Milk> stockMilk = new Inventory<Milk>();
    try {
      stockMilk.addItem(new Milk("2%", 10, basicDates.parse("4/3/15")));
      stockMilk.addItem(new Milk("Whole", 5, basicDates.parse("3/23/15")));
      stockMilk.addItem(new Milk("No Fat", 12, basicDates.parse("4/1/15")));
    } catch (ParseException ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }
    System.out.println("Milk Inventory:");
    System.out.println("---------------------------");
    Inventory.printInventory(stockMilk);
    System.out.println();
    System.out.println("Quantity of Item at index 2: " + stockMilk.getQuantity(2));
    
    Milk oldMilk = Inventory.<Milk>getOldestItemFromInventory(stockMilk);
    System.out.println();
    System.out.println("Oldest Item: " + oldMilk.toString());
    Inventory<Fruit> stockFruit = new Inventory<Fruit>();
    Inventory.addOrangesToInventory(stockFruit, "Clementine", 20);
    // The following line should result in a compile error, if uncommented...
    // Inventory.addOrangesToInventory(stockMilk, "Clementine", 20);
    System.out.println();
    System.out.println("Fruit Inventory:");
    System.out.println("---------------------------");
    Inventory.printInventory(stockFruit);
    Inventory.addOrangesToInventory(stockFruit, "Clementine", 50);
    // The following line should result in a compile error, if uncommented...
    // Inventory.addOrangesToInventory(stockMilk, "Clementine", 20);
    System.out.println();
    System.out.println("Fruit Inventory:");
    System.out.println("---------------------------");
    Inventory.printInventory(stockFruit);
//    stockMilk.addItem(new Milk("2%", 10, basicDates.parse("4/3/15")));
//    stockMilk.addItem(new Milk("Whole", 5, basicDates.parse("3/23/15")));
//    stockMilk.addItem(new Milk("No Fat", 12, basicDates.parse("4/1/15")));
//    Inventory.printInventory(stockMilk);
  }
}

/* This class is for Milk inventory items. It is used in testing the
 * Inventory class. */
class Milk extends DatedItem {
  public Milk(String name, int quantity, Date packDate) {
    super(name, quantity, packDate);
  }
  
  public String toString() {
    return name + " Milk, " + quantity + " units, Packaged: " + packDate;
  }
}
