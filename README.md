<div align="center">
  <img src="VehicRent.png" alt="VehicRent" width="400"/>
</div>

## Leading Vehicle Rental Solution

Vehic Rent is a web-based online vehicle rental service that can be accessed anywhere and anytime. With Vehic Rent, users can survey the vehicle they want to rent without having to go to the rental place. Created by a group of 6 from IF 45 09 consisting of:

- Abdul Wasiul Khair
- Raditya Aydin
- Siti Vanesa Rahma 
- Zefanya Darma Putri 

### Class Diagram

![Class Diagram](classDiagram_vehicrent.jpg)

### Installation Steps

Make sure to have the following software installed in your local environment before starting:

- Java (version 17) : **https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.9+9.1/OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.msi**
- Setup ENV JAVA_HOME ![image](java_home.png)


1. **Clone the Repository**

    ```bash
    git clone https://github.com/Radiit/VehicRent.git
    ```

2. **Navigate to the Project Directory**

    ```bash
    cd your-project
    ```

3. **Creating a schema**

    After the installation is complete, create a MySQL schema named tubesrpl or simply follow the JDBC URL:

    - *application.properties*

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tubesrpl
    ```

    after that import sql using the **tubesrpl.sql** file

4. **Run the Application**

    Once the installation is complete, run the application using the command:

    ```bash
    ./mvnw spring-boot:run
    ```

5. **Access the Application**

    Open a browser and access the application via the URL:

    ```http
    http://localhost:8081
    ```

6. **Login**
   
   Use this account to login

| Role       | Email                | Password |
| ----------- | -------------------- | -------- |
| Regent (Rental Agent) | regent@dummy.com | password123 |
| Client     | client@dummy.com   | password123 |

