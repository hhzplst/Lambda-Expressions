public class Magazine extends LibraryItem {
  private Date issue;
  private String category;

  public Magazine(Date issue, String category) {
    super();
    this.issue = issue;
    this.category = category;
  }

  public Date getIssueDate() {
    return issue;
  }

  public String getcategory() {
    return category;
  }

  public void setcategory(String c) {
    category = c;
  }

  public void setIssueDate(Date i) {
    issue = i;
  }

  public String toString() {
    return "Magazine in: " + category;
  }
}