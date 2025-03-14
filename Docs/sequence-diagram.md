# sequenceDiagram

```mermaid
sequenceDiagram
    participant Client
    participant Agent
    participant RentalSystem
    participant Database
    participant NotificationSystem
    
    Client->>Agent: Request vehicle rental
    Agent->>RentalSystem: Check vehicle availability
    RentalSystem->>Database: Query available vehicles
    Database-->>RentalSystem: Return matching vehicles
    RentalSystem-->>Agent: Display available vehicles
    Agent->>Client: Present vehicle options
    Client->>Agent: Select vehicle and rental period
    Agent->>RentalSystem: Input rental details
    RentalSystem->>Database: Verify client eligibility
    Database-->>RentalSystem: Return client status
    
    alt Client eligible
        RentalSystem->>Database: Create rental contract
        Database-->>RentalSystem: Confirm contract creation
        RentalSystem->>Agent: Display contract details
        Agent->>Client: Review contract with client
        Client->>Agent: Provide payment
        Agent->>RentalSystem: Record payment
        RentalSystem->>Database: Update payment records
        Database-->>RentalSystem: Confirm payment recorded
        RentalSystem->>Database: Update vehicle availability
        Database-->>RentalSystem: Confirm update
        RentalSystem->>NotificationSystem: Schedule return reminders
        RentalSystem-->>Agent: Generate rental agreement
        Agent->>Client: Provide rental agreement and keys
    else Client not eligible
        RentalSystem-->>Agent: Display eligibility issues
        Agent->>Client: Explain requirements
    end
    
    Note over Client,NotificationSystem: Prior to return date
    NotificationSystem->>Client: Send return date reminder
    
    Note over Client,Agent: On return date
    Client->>Agent: Return vehicle
    Agent->>RentalSystem: Process vehicle return
    RentalSystem->>Database: Update vehicle status
    RentalSystem->>Database: Close rental contract
    Database-->>RentalSystem: Confirm updates
    RentalSystem-->>Agent: Display final charges
    Agent->>Client: Process final payment/refund
