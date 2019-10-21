# receiving-and-triggering-fcm-push-notifications-android
This project's implemented in "Sahibinden.com dev.akademi Hackathon 2019". Generalized for public usage and uploaded to GitHub.

This project has 2 parts. First part is -> (fcm-with-database-value-change) -> Firebase Cloud Messaging with Database Value Changes 
You can see it from here : https://github.com/eneserkoc/fcm-with-database-value-change

This part is the second part of this project. In this app we'll implement a example mobile app that we can see the data in database, trigger the Firebase function and receive the push notifications.

## Requirements : 
You need to add your android app to your firebase project which has the realtime database. See if you dont know how to do it : https://www.geeksforgeeks.org/adding-firebase-to-android-app/ .
(Don't forget add your own json file to project if you want to use the app directly)
Explanation : 

## App has 4 different parts : 

DataActivity : Activity that shows the data from Firebase Realtime Database

FirebaseMessagingService : Service that allows us to listen notification channel of Firebase 

MainActivity : Activity to subscribe to notification topic via FirebaseMessagingService

LimitActivity : Activity that you can set the limit_view_count value to trigger the push notification


