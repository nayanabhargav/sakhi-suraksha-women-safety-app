# Sakhi Suraksha – Women Safety Android Application

Sakhi Suraksha is an Android-based women safety application designed to provide quick emergency support through SOS alerts, GPS location sharing, emergency calling, shake detection, and voice-triggered assistance.

## Features

* Emergency SOS alert
* Live GPS location sharing
* SMS alerts to saved emergency contacts
* Emergency calling
* Shake detection for SOS activation
* Voice-triggered emergency support
* Background SOS functionality
* Emergency helpline information
* Women safety laws and self-defense information
* Firebase authentication and data storage

## Technologies Used

* Java
* Android Studio
* Firebase
* GPS API
* SMS API
* Android Sensors
* XML
* Gradle

## Project Structure

```text
app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── Sakhii/
│       │           └── Suraksha/
│       ├── res/
│       │   ├── drawable/
│       │   ├── layout/
│       │   ├── mipmap/
│       │   └── values/
│       └── AndroidManifest.xml
├── build.gradle
└── proguard-rules.pro
```

## Main Modules

* `MainActivity.java` – Main application screen
* `PanicActivity.java` – Emergency SOS operations
* `ShakeDetector.java` – Detects shake gestures
* `LocationHelper.java` – Retrieves GPS location
* `LawsActivity.java` – Displays women safety laws
* `LawsDetailActivity.java` – Shows detailed law information
* `SelfDefenseActivity.java` – Provides self-defense guidance
* `Utils.java` – Common utility functions

## How It Works

1. The user registers emergency contacts.
2. The application monitors shake or voice-trigger actions.
3. When an emergency is detected, the SOS process starts.
4. The application sends an SMS with the user’s location.
5. It can also place an emergency call and activate an alert sound.

## Permissions Required

* Location access
* SMS permission
* Phone call permission
* Microphone permission
* Notification permission
* Foreground service permission

## How to Run

1. Clone this repository.

```bash
git clone https://github.com/nayanabhargav/sakhi-suraksha-women-safety-app.git
```

2. Open the project in Android Studio.
3. Sync Gradle files.
4. Configure Firebase if required.
5. Run the application on an Android device or emulator.

## Important Note

Do not upload Firebase secret keys, API keys, `google-services.json`, keystore files, personal phone numbers, or emergency-contact details to a public repository.

## Author

**Nayana B**

MCA Candidate | Aspiring Data Analyst and AI/ML Engineer
