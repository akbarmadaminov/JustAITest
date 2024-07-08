# VK Bot Service

This project is a simple VK bot service

## Project Setup

### Prerequisites

- Java 11 or higher
- Gradle 6.0 or higher
- A VK account and a community for the bot

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-repo/vk-bot-service.git
    cd vk-bot-service
    ```

2. Update the `application.properties` file with your VK API token and URL
    ```properties
    vkAccessToken=your_vk_access_token
    vkApiUrl=https://api.vk.com/method/messages.send
    ```

3. Build the project:
    ```sh
    ./gradlew build
    ```

4. Run the application:
    ```sh
    ./gradlew bootRun
    ```
### 
![screenshot](https://github.com/akbarmadaminov/JustAITest/blob/master/Screenshot.png)
