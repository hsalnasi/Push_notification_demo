# 📱 Push Notification Demo: Flutter + Firebase + Node.js

This is a small demo project showing how to send push notifications from a backend to a Flutter app. It’s designed to be easy to test, easy to understand, and easy to extend later.

---

##  What This Project Does ❓

### **Flutter App**
- Connects to Firebase
- Gets the device’s FCM token and displays it on screen
- Listens for incoming notifications
- Shows:
  - A real Android notification
  - A popup inside the app
  - A snackbar log for debugging
  <img width="1351" height="736" alt="Screenshot 2025-11-30 020510" src="https://github.com/user-attachments/assets/de0a0c09-0f98-4e96-8669-c8ccec473ebe" />

---

### **Backend (Node.js + Firebase Admin)**
A simple Express server with one route:


You send a token + title + message → the device receives a push notification instantly.

---

### **Postman Testing**
Send a JSON request like:

```json
{
  "token": "DEVICE_FCM_TOKEN",
  "title": "Hello",
  "body": "It works!"
}
```

<img width="1126" height="558" alt="Screenshot 2025-11-30 012449" src="https://github.com/user-attachments/assets/9f234f7f-145e-444a-b4fb-b6dc5679774e" />
<img width="1043" height="189" alt="Screenshot 2025-11-30 012602" src="https://github.com/user-attachments/assets/e05e9609-b673-4551-826b-a4a13c68764c" />
--
Showcasing it in action :
<img width="1339" height="742" alt="Screenshot 2025-11-30 023331" src="https://github.com/user-attachments/assets/1bee8f3f-1eff-4e76-b006-a9b9d7ae232d" />

## How to Test It

1 - Run the Flutter app → copy the FCM token shown on screen

2 - Start the backend → node index.js

3 - Use Postman to send a request → check your device/emulator for the notification
**Note** : The Firebase service account key is NOT included in this repo for safety.
If you want to run the backend locally, add your own key in 
