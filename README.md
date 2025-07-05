#  E-Commerce System

This is a simple object-oriented e-commerce system built in Java as part of an internship challenge.

The system simulates basic shopping flow including product definition, cart handling, shipping, and checkout with balance checks.

---
##  What the system does:

- Allows defining different product types:
  - Some can **expire** (like Cheese).
  - Some need **shipping** (like TVs).
  - Some don’t expire or ship (like mobile scratch cards).
  - ----

- Handles a **shopping cart**:
  - You can add products (if they are in stock and not expired).
  - Calculates the subtotal and shipping fees.
  - Shows errors if anything goes wrong (expired product, out of stock, not enough balance, etc).


- During **checkout**:
  - It prints all the order details.
  - Deducts the amount from customer balance.
  - Ships all the required items.

---
###  Shipping Service
- Collects all shippable products from the cart
- Calculates total shipping fees based on item weight
- Displays shipment notice

---

## ⚙️ Technologies used:

- Java 
- Object-Oriented Programming (OOP)
- Custom Exceptions
- BigDecimal for accurate prices

---
##  Project Structure

 The project follows a modular structure using packages:
- `model`: holds product, cart, and customer logic
- `service`: checkout and shipping logic
- `exception`: custom exception classes
- `interface`: defines `Shippable` interface
- `Main`: where the app runs and is tested

## Output Example
![UML](https://raw.githubusercontent.com/MalakMustafa7/E-commereceTask-oop-/1d777708fe6a60b3803f0cd18b2ce37ca5000c47/photo_2025-07-05_13-28-00.jpg)

## Notes
- The app doesn't use a database, products are initialized directly in code.
- Shipping fees are calculated as: `weight × 5`.
- Designed with separation of concerns using packages.

 
  
