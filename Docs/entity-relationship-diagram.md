# erDiagram

```mermaid
erDiagram
    VEHICLE {
        int id PK
        string registrationNumber
        string brand
        string model
        string category
        boolean isAvailable
        date lastMaintenanceDate
        date purchaseDate
        double dailyRate
        string status
        string color
        int seatingCapacity
        string fuelType
        string transmission
        string imageUrl
    }
    
    AGENT {
        int id PK
        string name
        string contactNumber
        string email
        string role
        string username
        string passwordHash
        date hireDate
        boolean isActive
    }
    
    CLIENT {
        int id PK
        string name
        string contactNumber
        string email
        string address
        string licenseNumber
        date licenseExpiryDate
        date registrationDate
        string status
    }
    
    RENTAL_CONTRACT {
        int id PK
        int vehicleId FK
        int clientId FK
        int agentId FK
        date startDate
        date endDate
        date actualReturnDate
        string status
        double totalAmount
        double deposit
        string notes
    }
    
    PAYMENT {
        int id PK
        int rentalContractId FK
        double amount
        date paymentDate
        string paymentMethod
        string transactionReference
        string status
    }
    
    MAINTENANCE {
        int id PK
        int vehicleId FK
        date startDate
        date endDate
        string description
        double cost
        string status
    }
    
    NOTIFICATION {
        int id PK
        int referenceId
        string referenceType
        string message
        date creationDate
        boolean isRead
        string priority
    }
    
    REPORT {
        int id PK
        string name
        date generationDate
        string parameters
        string fileUrl
        string type
    }
    
    VEHICLE ||--o{ RENTAL_CONTRACT : "is rented in"
    VEHICLE ||--o{ MAINTENANCE : "undergoes"
    CLIENT ||--o{ RENTAL_CONTRACT : "creates"
    AGENT ||--o{ RENTAL_CONTRACT : "manages"
    RENTAL_CONTRACT ||--o{ PAYMENT : "receives"
    RENTAL_CONTRACT ||--o{ NOTIFICATION : "generates"
