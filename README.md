# Weather Data Storage System

## 📌 Project Description
The **Weather Data Storage System** is a Java-based project designed to store, retrieve, and manage weather data such as temperatures across different cities and years. It demonstrates the use of **Abstract Data Types (ADT)**, **2D arrays**, and **sparse data structures (HashMap)**. The project also compares the efficiency of **row-major vs column-major traversal** and analyzes **time and space complexity**.

---

## 🎯 Features
- Define a **WeatherRecord ADT** with attributes: Date, City, Temperature.
- **Dense 2D Array Storage**: rows = years, columns = cities, sentinel values for missing data.
- **Sparse Storage** using HashMap: only stores non-empty records, memory efficient.
- **Operations**:
  - Insert a new record
  - Delete an existing record
  - Retrieve weather data for a city and year
- **Traversal methods**:
  - Row-major traversal
  - Column-major traversal
- **Complexity Analysis** displayed at program exit.
- **Interactive menu** for user input.

---

## 🏗 System Design
1. **WeatherRecord ADT**
   - Attributes: `LocalDate date`, `String city`, `double temperature`
2. **Dense Storage**
   - `double[][]` array with sentinel values (`Double.NaN`)
   - O(1) for insert, delete, and retrieve
3. **Sparse Storage**
   - `HashMap<String, Double>` with keys formatted as `year-city`
   - O(1) average case for insert, delete, and retrieve
4. **Traversal**
   - Row-major: iterate year by year
   - Column-major: iterate city by city

---

## ⚡ Complexity Analysis
- Insert: O(1)
- Delete: O(1)
- Retrieve: O(1)
- Row/Column Traversal: O(R × C)
- Space (Dense): O(R × C)
- Space (Sparse): O(K), where K = number of records

---

## ▶️ How to Run
1. Save the file as `WeatherAssignment.java`
2. Compile the code:
   ```bash
   javac WeatherAssignment.java
   ```
3. Run the program:
   ```bash
   java WeatherAssignment
   ```

---

## 📄 Example Interaction
```
=== Weather Data System ===
Available cities: [Delhi, Mumbai, Chennai, Kolkata, Bengaluru]

Choose option: 1=Retrieve  2=Insert  3=Delete  4=Exit : 1
Enter city: Delhi
Enter year (2021-2025): 2022
[Dense] No record found for Delhi in 2022
[Sparse] No record found for Delhi in 2022

Choose option: 2
Enter city: Delhi
Enter year (2021-2025): 2022
Enter temperature: 25.6
Inserted Delhi 2022 -> 25.6°C

Choose option: 1
Enter city: Delhi
Enter year (2021-2025): 2022
[Dense] Delhi 2022 -> 25.6°C
[Sparse] Delhi 2022 -> 25.6°C
```

---

## ✅ Outcome
This project fulfills all assignment requirements:
- WeatherRecord ADT ✔
- 2D Array Storage ✔
- Row/Column traversal ✔
- Sparse data handling ✔
- Insert, Delete, Retrieve ✔
- Complexity analysis ✔
- Interactive menu ✔

---

## 📚 References
- *Data Structures and Algorithm Analysis in C++* by Mark Allen Weiss  
- *Python Data Structures and Algorithms* by Benjamin Baka  
- GeeksforGeeks: Sparse Matrix Representation  
- W3Schools: Java Arrays
