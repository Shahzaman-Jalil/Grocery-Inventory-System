# Grocery Inventory Management System (Java + Stack)

A Java Swing-based desktop application for managing grocery items efficiently using the Stack data structure.
Developed as part of the Data Structures & Algorithms (DSA) course, this project demonstrates how stacks can be applied in real-world inventory systems.

## 🌟 Overview

This system allows users to manage grocery items through an elegant Java Swing GUI, while internally using a Stack (LIFO) approach to store and manage product data.

You can easily add, update, delete, and view items interactively — all through an intuitive interface with a custom background and styled buttons.

## 🎯 Features

- ✅ **Add Product** — Add a new grocery item to the stack (Push operation).
- ✏️ **Update Product** — Modify details of a specific product using its ID.
- 🗑️ **Delete Product** — Removes the most recently added item (Pop operation).
- 📋 **Show Inventory** — Displays all items in a styled JTable.
- 🎨 **Modern GUI** — Custom background, colored buttons, and overlay design.
- 🧮 **Stack Implementation** — Demonstrates LIFO (Last-In, First-Out) operations.

## ⚙️ Technologies Used

| Component | Technology |
| :--- | :--- |
| **Language** | Java |
| **Framework** | Java Swing |
| **Data Structure** | `java.util.Stack` |
| **File Handling** | (Coming Soon) |
| **IDE Used** | IntelliJ IDEA / NetBeans |
| **Version Control** | Git & GitHub |

## 🧩 System Architecture

The system is built with three primary layers:

### 🧠 1. Data Layer (Stack Logic)

Uses a `Stack<GroceryItem>` to store all items.

Each `GroceryItem` contains:
* `id`
* `name`
* `price`
* `quantity`
* `category`

### 💻 2. GUI Layer (Frontend)

Built using Java Swing.

Contains interactive components:
* TextFields for input
* Buttons for actions
* JTable for data display
* Includes background image + overlay effect for a modern design.

### 🧮 3. Operations Layer

* **Add Item:** `Push` new item to stack
* **Delete Item:** `Pop` top item
* **Update Item:** Search by ID and modify
* **Show Inventory:** Display stack contents in JTable

## 🧰 How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Shahzaman-Jalil/Grocery-Inventory-System.git](https://github.com/Shahzaman-Jalil/Grocery-Inventory-System.git)
    ```

2.  **Open the project in IntelliJ IDEA or NetBeans.**

3.  **Make sure the background image is located in:**
    ```
    src/Images/background.png
    ```

4.  **Run the file:**
    ```
    src/GroceryInventoryGUI.java
    ```

5.  **The application window will open — start managing your grocery items interactively!**

## 📸 Preview

Here’s a glimpse of the Grocery Inventory Management System in action 👇

<img width="982" height="735" alt="image" src="https://github.com/user-attachments/assets/624e7ef4-9bb9-46e8-bbe8-b1b4bbc969e9" />

## 🧠 Learning Outcome

- 🎯 Applied Stack data structure in a real-world GUI project.
- 🎨 Learned Swing GUI design with backgrounds and styling.
- 💾 Understood data management logic using Stacks (LIFO).
- 💡 Improved grasp of Object-Oriented Programming (OOP) in Java.

## 👨‍💻 Developer

**Shahzaman Jalil**
<br>
*3rd Semester — DSA Course Project*

---

### 🚀 Grocery Inventory Management System using Stack (Java Swing)

### 🛍️ "Where Data Structures meet Real-World Utility!" 💡
