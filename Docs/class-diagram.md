# ClassDiagram

```mermaid
classDiagram
    class Vehicle {
        -int id
        -String registrationNumber
        -String brand
        -String model
        -String category
        -boolean isAvailable
        -Date lastMaintenanceDate
        -double dailyRate
        -String status
        +getDetails()
        +updateAvailability()
        +calculateRentalCost(days)
        +scheduleMaintenanceCheck()
    }

    class Agent {
        -int id
        -String name
        -String contactNumber
        -String email
        -String role
        -String username
        -String passwordHash
        +login()
        +createRentalContract()
        +generateReport()
        +manageVehicles()
    }
    
    class Client {
        -int id
        -String name
        -String contactNumber
        -String email
        -String address
        -String licenseNumber
        -Date licenseExpiryDate
        +getRentalHistory()
        +updateProfile()
        +checkEligibility()
    }
    
    class RentalContract {
        -int id
        -int vehicleId
        -int clientId
        -int agentId
        -Date startDate
        -Date endDate
        -Date actualReturnDate
        -String status
        -double totalAmount
        +calculateTotalCost()
        +extend(days)
        +close()
        +generateInvoice()
    }
    
    class Payment {
        -int id
        -int rentalContractId
        -double amount
        -Date paymentDate
        -String paymentMethod
        -String status
        +processPayment()
        +generateReceipt()
        +refund()
    }
    
    class DatabaseManager {
        -Connection connection
        +connect()
        +disconnect()
        +executeQuery()
        +executeUpdate()
        +beginTransaction()
        +commitTransaction()
        +rollbackTransaction()
    }
    
    class NotificationManager {
        +sendReminderNotification()
        +sendOverdueNotification()
        +sendMaintenanceAlert()
        +markAsRead()
    }
    
    class ReportGenerator {
        +generateVehicleUtilizationReport()
        +generateRevenueReport()
        +generateClientHistoryReport()
        +exportToExcel()
        +exportToPDF()
    }
    
    Vehicle "1" -- "many" RentalContract
    Client "1" -- "many" RentalContract
    Agent "1" -- "many" RentalContract
    RentalContract "1" -- "many" Payment
    DatabaseManager -- Vehicle
    DatabaseManager -- Client
    DatabaseManager -- Agent
    DatabaseManager -- RentalContract
    DatabaseManager -- Payment
    NotificationManager -- RentalContract
    ReportGenerator -- RentalContract
    ReportGenerator -- Vehicle
    ReportGenerator -- Payment
