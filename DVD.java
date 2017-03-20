public class DVD extends LibraryItem implements Borrowable {
  private String name, format;
  protected Date checkoutDate, dueDate;

  public DVD(String name, String format) {
    super();
    this.name = name;
    this.format = format;
  }

  public String getName() {
    return name;
  }

  public void setName(String n) {
    name = n;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String f) {
    format = f;
  }

  public Date getCheckoutDate() {
    return checkoutDate;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setCheckoutDate(Date d) {
    checkoutDate = d;
  }

  public void setDueDate(Date d) {
    dueDate = d;
  }

  public String toString() {
    return "DVD: " + name;
  }
}