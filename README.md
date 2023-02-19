<h1>Product-Inventory-Management-System</h1>
<p>Manage your online store's inventory with this Java console app. Create, view, update, and remove products using Hibernate ORM. Built with Factory design pattern and layered approach for scalability and maintainability.</p>

<h2>Architecture</h2>
![image](https://user-images.githubusercontent.com/108913933/219918213-829c923c-a443-4ce8-b2c8-dd30022e06a3.png)

<h2>Features</h2>
<ul>
  <li>Add new products to the inventory</li>
  <li>View details of a particular product</li>
  <li>Update product information</li>
  <li>Delete products from the inventory</li>
</ul>

<h2>Technologies</h2>
<ul>
  <li>Java programming language for writing the application code</li>
  <li>Hibernate ORM tool for mapping Java objects to database tables, and for performing database operations in a platform-independent manner</li>
  <li>MySQL database for storing product data</li>
  <li>EhCache L2 caching mechanism for improved performance by reducing database hits and improving response time</li>
  <li>Factory design pattern for creating objects and promoting loose coupling between objects</li>
  <li>Layered architecture with separation of concerns for maintainability and scalability</li>
  <li>Hibernate Identity generator for autogenerating Product IDs, which ensures uniqueness and eliminates the need for manual ID assignment</li>
  <li>Timestamping for tracking open and last modified dates of products, which provides valuable information for inventory management and auditing purposes</li>
  <li>Model-View-Controller (MVC) design pattern for separating the application logic into three distinct layers - Model (data layer), View (presentation layer), and Controller (business logic layer)</li>
</ul>

<p>Overall, the Product Inventory Management System is a robust and efficient solution for managing an online store's inventory. By leveraging the MVC design pattern, the application benefits from clear separation of concerns and improved maintainability. Hibernate simplifies database access and improves portability across different platforms, while caching with EhCache L2 provides a significant performance boost by reducing the number of database hits. The use of design patterns and layered architecture ensures code scalability and the timestamping feature provides useful information for inventory tracking and auditing.</p>
