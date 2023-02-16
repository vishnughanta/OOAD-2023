# OOAD Homework - Friendly Neighborhood Car Dealership
#### Team Members: Nikhil Panda & Vishnu Ghanta
#### Java Version: Java 18

### Project 2.2

The FNCD class contains the main() method.

This code simulates the working of a Friendly Neighborhood Car Dealership. 

- Staff and Vehicle are the two abstract classes defined. Intern, Mechanic, and Salesperson extends Staff class and Car, Performance Car, Pickup classes extend the Vehicle class. NameGenerator and RandomGenerator are the two interfaces which provide 100% abstraction.

- Staff and Vehicle classes implement the above mentioned interfaces so that the concrete classes can access the alogorithms of the interfaces using the Strategy pattern.

The FNCD class creates the objects of the daily activities and delegates the work to each class.

#### Assumptions
- Assumed the values of wash bonus, repair bonus, and sales bonus for each vehicle as mentioned in the project.
- Named the staff and vehicles as Intern_1, Mechanic_1, Salesperson_1 and Car_1, Performance Car_1, and Pickup_1 (incremented the id on each object creation) instead of giving them particular names - Thanks for Sultan Alshkrah's piazza's post on this approach.
- Used the Factory method pattern to remove the dependency on the random generator and name generator functionalities.

Printed a summary table of staff members, inventory, total sales amount for each day.
