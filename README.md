# Restaurant 

## Overview
This project is a simple restaurant management system implemented in Java, utilizing JDBC to connect to a MySQL database. The system consists of three main tables in the "restaurant" database: "admin," "menu," and "users." These tables store information about administrators, menu items, and users respectively.

## Prerequisites
Before running the project, make sure you have the following prerequisites installed and configured:

Java Development Kit (JDK): Ensure that you have Java installed on your system. You can download it from Oracle's official website or use an OpenJDK distribution.

MySQL Database Server: Set up a MySQL database server named "restaurant."

Database Tables:

admin Table:
Columns: "Admin_name," "Admin_password."

menu Table:
Columns: "id," "food_name," "price."

users Table:
Columns: "id," "username," "password," "balance."

## Project Structure
RestaurantProject
│ README.md
│ .gitignore
│
└───src
│ └───com
│ └───restaurant
│ │ RestaurantApp.java
│ │
│ └───model
│ │ Admin.java
│ │ MenuItem.java
│ │ User.java
│
└───lib
│ │ mysql-connector-java-x.x.x.jar
│
└───sql
│ restaurant.sql


