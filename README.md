# JavaProject


//    Single Responsibility Principle (SRP): Each class has a single responsibility and encapsulates related functionality.
//
//    Low Coupling Principle: The Catalog class, which manages the themes, doesn't depend directly on the printing functionality. The printing responsibility is delegated to the CatalogPrinter class, reducing coupling between classes.
//
//    Creator Pattern: The Catalog class is responsible for creating and managing themes, adhering to the Creator pattern.
//
//    Information Expert Principle: The CatalogPrinter class is responsible for printing the catalog as it has the necessary information about the catalog's structure.
