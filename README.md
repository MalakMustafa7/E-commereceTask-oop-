#  E-Commerce System

A simple Java console-based system that simulates an e-commerce checkout process with product validation, cart management, shipping calculations, and custom exception handling.

---

## Features

### 🧾 Product Management
- Products have `name`, `price`, and `quantity`.
- Types of products:
  - **Expirable products** (e.g., Milk, Cheese)
  - **Non-expirable products** (e.g., Scratch Cards)
  - **Shippable products** (e.g., Book, Laptop) — each has a `weight`
  - **Non-shippable products** (e.g., Digital Products)

---

### Cart Operations
- Add products to cart with specified quantity
- Prevent adding:
  - Expired products
  - Out-of-stock products
  - Invalid (non-existent) products
- Automatically updates product quantity after checkout

---

###  Checkout
- Shows a summary:
  - Order subtotal
  - Shipping fees (calculated as 5 × weight)
  - Total amount paid
  - Customer balance after payment
- Validates:
  - Cart is not empty
  - Customer has enough balance
  - All products are valid (not expired or out-of-stock)

---

###  Shipping Service
- Collects all shippable products from the cart
- Calculates total shipping fees based on item weight
- Displays shipment notice

---

### ❗ Custom Exceptions
- `ExpiredProductException`
- `OutOfStockException`
- `InsufficientBalanceException`
- `ProductNotFoundException`

---
##  Project Structure

src/main/java/org/example/
├── model/
│ ├── Product.java
│ ├── ExpirableProduct.java
│ ├── ShippableProduct.java
│ ├── NonShippableProduct.java
│ ├── CartItem.java
│ ├── Cart.java
│ └── Customer.java
├── service/
│ ├── ShippingService.java
│ └── CheckoutService.java
├── interface/
│ └── Shippable.java
├── exception/
│ ├── ExpiredProductException.java
│ ├── OutOfStockException.java
│ ├── InsufficientBalanceException.java
│ └── ProductNotFoundException.java
├── E-CommerceSystem
  └──Main

 # Usage Example
 Enter customer balance: 3000
Our products:
cheese  Biscuits  tv  mobileScratchCards  mobile  
enter name of product
cheese
enter quantity of product
2
Cannot add expired product to cart
enter name of product
tv
enter quantity of product
2
product added successfully
enter name of product
mobileScratchCards
enter quantity of product
1
product added successfully
enter name of product
end
Shipping item: tv, Weight: 100.0 kg
Checkout Details:
Order Subtotal: $100.0
Shipping Fees: $500.0
Paid Amount: $600.0
Customer Balance After Payment: $2400.0

##  Error Handling

- **Expired Product:** throws `ExpiredProductException`
- **Out of Stock:** throws `OutOfStockException`
- **Insufficient Funds:** throws `InsufficientBalanceException`
- **Product Not Found:** throws `ProductNotFoundException`

 ##  Assumption
- Product names are unique
- Customer balance is entered at runtime
- Shipping fee = `itemWeight × 5.0`
- Products are added manually in the `Main.java` for testing

  
