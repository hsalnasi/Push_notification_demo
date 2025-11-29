const admin = require("firebase-admin");
const express = require("express");

const app = express();
app.use(express.json());

// Initialize Firebase Admin with your service account
const serviceAccount = require("./serviceAccountKey.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

// Test route
app.get("/", (req, res) => {
  res.send("Push notification backend is running!");
});

// Endpoint to send a push notification
app.post("/send", async (req, res) => {
  const { token, title, body } = req.body;

  const message = {
    notification: { title, body },
    token: token,
  };

  try {
    const response = await admin.messaging().send(message);
    res.json({ success: true, response });
  } catch (error) {
    console.error(error);
    res.json({ success: false, error });
  }
});

// Start server
app.listen(3000, () => {
  console.log("Backend running on http://localhost:3000");
});
