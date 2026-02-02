# Astra 🌟 Smart Voice Assistant
Desktop voice assistant that listens for "Astra" wake word. Tells time, opens apps, checks Dehradun weather. Built with live analytics dashboard.

🎙️ Demo Commands
"Astra what time is it?" → Speaks current time
"Astra open notepad" → Launches Notepad
"Astra weather" → Dehradun weather API


 ✨ Features
📊 Live analytics dashboard (Swing + MySQL)
🌤️ Dehradun weather API integration
⚡ 8-thread concurrent processing
🎤 Offline speech recognition (Sphinx4)
🎵 Natural voice synthesis (FreeTTS)


🚀 Quickstart
1. Download Sphinx4 + FreeTTS JARs → lib/
2. mysql < database.sql
3. javac -cp "lib/*" *.java
4. java -cp "lib/*:." VoiceAssistPro

 🛠️ Tech Stack
Java 17 | Swing GUI | MySQL | Sphinx4 | FreeTTS
