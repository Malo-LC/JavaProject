import java.util.ArrayList;
import java.util.List;

// Single Responsibility Principle (SRP)
class Course {
  private String name;

  public Course(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

class Topic {
  private String name;
  private List<Course> courses;

  public Topic(String name) {
    this.name = name;
    this.courses = new ArrayList<>();
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public String getName() {
    return name;
  }

  public List<Course> getCourses() {
    return courses;
  }
}

class Theme {
  private String name;
  private List<Topic> topics;

  public Theme(String name) {
    this.name = name;
    this.topics = new ArrayList<>();
  }

  public void addTopic(Topic topic) {
    topics.add(topic);
  }

  public String getName() {
    return name;
  }

  public List<Topic> getTopics() {
    return topics;
  }
}

// Creator pattern and Low Coupling principle
class Catalog {
  private List<Theme> themes;

  public Catalog() {
    this.themes = new ArrayList<>();
  }

  public void addTheme(Theme theme) {
    themes.add(theme);
  }

  public List<Theme> getThemes() {
    return themes;
  }
}

// Information Expert principle
class CatalogPrinter {
  public static void printCatalog(Catalog catalog) {
    for (Theme theme : catalog.getThemes()) {
      System.out.println("Theme: " + theme.getName());
      for (Topic topic : theme.getTopics()) {
        System.out.println("  Topic: " + topic.getName());
        for (Course course : topic.getCourses()) {
          System.out.println("    Course: " + course.getName());
        }
      }
      System.out.println();
    }
  }
}

public class Main {
  public static void main(String[] args) {
    // Creating catalog
    Catalog catalog = new Catalog();

    // Creating themes
    Theme networksTheme = new Theme("Networks");
    Theme operatingSystemsTheme = new Theme("Operating Systems");
    Theme projectManagementTheme = new Theme("Project Management");
    Theme developmentLanguagesTheme = new Theme("Development Languages");

    // Creating topics
    Topic webLanguagesTopic = new Topic("Web Languages");
    Topic javaTopic = new Topic("Java");
    Topic csharpTopic = new Topic("C#");
    Topic cppTopic = new Topic("C++");

    // Creating courses
    Course phpCourse = new Course("PHP");
    Course javascriptCourse = new Course("JavaScript");
    Course ajaxCourse = new Course("Ajax");

    // Adding courses to topics
    webLanguagesTopic.addCourse(phpCourse);
    webLanguagesTopic.addCourse(javascriptCourse);
    webLanguagesTopic.addCourse(ajaxCourse);

    // Adding topics to themes
    developmentLanguagesTheme.addTopic(webLanguagesTopic);
    developmentLanguagesTheme.addTopic(javaTopic);
    developmentLanguagesTheme.addTopic(csharpTopic);
    developmentLanguagesTheme.addTopic(cppTopic);

    // Adding themes to catalog
    catalog.addTheme(networksTheme);
    catalog.addTheme(operatingSystemsTheme);
    catalog.addTheme(projectManagementTheme);
    catalog.addTheme(developmentLanguagesTheme);

    // Printing the catalog
    CatalogPrinter.printCatalog(catalog);
  }
}

//    Single Responsibility Principle (SRP): Each class has a single responsibility and encapsulates related functionality.
//
//    Low Coupling Principle: The Catalog class, which manages the themes, doesn't depend directly on the printing functionality. The printing responsibility is delegated to the CatalogPrinter class, reducing coupling between classes.
//
//    Creator Pattern: The Catalog class is responsible for creating and managing themes, adhering to the Creator pattern.
//
//    Information Expert Principle: The CatalogPrinter class is responsible for printing the catalog as it has the necessary information about the catalog's structure.
