# CS102 ~ Design Project ~ Spring 2019/20
****
## g1H ~~ BilMeet ~~
****
### ~ MeetTheNeeds ~

## Project Description
People can sometimes have problems with socializing. This situation can be very annoying, especially for university students. With this 
application, we aim to get used to people who are shy and cannot make many friends. Moreover, enabling people to easily find places where 
the activities they attend or to organize events easily.

## Project Status
+ **Group/project Selection:** completed (16.02.2020)
+ **Requirements:** completed (23.02.2020)
+ **UI Design:** completed (15.03.2020)
+ **Detailed Design:** completed (21.05.2020)
+ **Implementation:** completed (28.05.2020)
+ **Reflections:** completed (28.05.2020)

## What Has Been Done and What Has Been Remained
When we login to the application, it opens with the login screen. The user can register without any problem and can login to the application 
after confirming it from bilkent mail. As long as we do not log out after logging into the application, the last user in the application 
remains open. After logging into the application, the map screen opens. We can add pins to our map, which we add as pictures. Then we can 
list the events created when the pin is clicked. However, when we make the pins open, we cannot use the zoom feature. In the Create an event 
section, we can select and write the features we want. However, when we press the save button, we return to the main screen. The pins we 
added in the Middle and East map section do not open, but the pictures can be zoomed. When we enter the profile section, user features do 
not appear because we do not add user profiles to the database. All users have the same features. However, these features can be changed in 
Settings. Even if you quit the application and re-enter, the changed and newly entered properties are saved. There are no adding friends or 
sending messages from the user profile. Then, after the changes we made in the code, we started to get an error in the user reporting 
section. However, he had a photograph working on github. In addition, we did not make the chat part that we thought of in addition. Finally, 
we can list the events we wrote on the event page. We can choose when we click the Filter button, but the filtering process does not work. 
In addition, our application size does not work for all devices. We tried the test part only for nexus 5.

#### Group Members
- Mert Atakan Onrat 
My task was to create Settings page. I tried to update Profile. I made address, biography and facebook parts modifiable. After changing 
these parts if the done button is pressed, they are saved. Even if user exits and re-run the program, the modified parts remain up to 
date. The saved parts are sent to Profile2. I used Intent to move between Activity to Activity or Fragment to Activity. Also I helped my 
group to solve some of the problems we encountered. We couldn't open the MainActivity from LoginFragment. After clicking login button we 
couldn't open MainActivity and the application stopped itself. However, I was using the codes in Profile that moves us from 
ProfileFragment to Settings. Then I used same codes to LoginFragment and then the problem is solved. I tried to help my group to set up 
the Firebase.

- Tuğberk Dikmen 
I specifically created the menu interface that allows the user to switch between pages and added it to the application. In addition, I 
made sure that the image map was added to the application and that it was zoomable and scrollable. I worked on adding a mark on the 
image maps and when these marks were clicked, showing the events there. In addition, I took part in finding the solutions of the 
errors we encountered during the whole project process. I helped to research and add Fire Base to our project.

- Oğulcan Karakollukçu 
At first I dealt with the appearance of the event page. This page writes the name of the events, the type, the remaining time and there
is a create an event button in the upper right corner and a filter button just below it to filter the events according to their types.
I designed the screen that opened when I pressed the create an event button, but later Faruk improved it with a more beautiful look.
Then I added a location cursor with tugberk, which can be zoomed in and out on the Bilkent map. We couldn't add these cursors with a
single method, so we had to write a new method for each cursor, I solved this problem and reduced it to a single method. Then I made
these cursors tactile and made them show the events that happened in that area. Finally, I added firebase to the register section and I
saved the emails to firebase. I set this part to accept only bilkent webmail and I sent a verification mail to every mail. I wrote a
page so that if the verification mail cannot be sent, the user will not be affected and can request verification mail again.

- Ahmet Faruk Ulutaş
I made the user interface of the profile section. It was a good start to learn xml and make android user interface. In 
the application registration section, I solved various bugs such as the user interface not fitting completely on the screen or not being 
able to come back from the XML layouts in showing the events. The Create an Event section was not working correctly. I completely redesigned 
that part. Thus, the event name prompt became hint and the type and duration of the event was selectable. When I click on the image in the 
Profile section, I opened the dialog and opened the report button. Thus, the user could be reported. I made the installation part of 
Firebase and adding it to the project. I wrote the method that creates an intent for the profile part and for a few other parts in order to 
switch from the activity to the activity. At the same time, I found the github library so that the pictures can be zoomed and pinned, and I 
wrote a few codes so that we can use the library in general. I kept assignments and github meetings logs to be added to Moodle. Also, I 
traced the mistakes faced by other group members and resolved these bugs.

- Bartu Teber 
I made the log in and registration page and connect its activities to the main screen of our app. It was instructive for me to
learn the xml layout and design of a user interface and connecting activities or fragments. It was a bit challenging for us to
add clickable pins on the map. I worked on onTouchEvent() so that the dialog appears when the pin is clicked. I worked on
firebase and set it up to our project.

## Details About the Project
We used the current version of Android studio. (3.6.3) We also used firebase for the database part. (17.4.2) We also used github to store 
and continue our project. (2.20.8) In order to provide various features in our project (zooming, panning and pinning) we used 
davemorrissey's github library. (https://github.com/davemorrissey/subsampling-scale-image-view) (3.10.0) In order to test, we download the 
project as github, unzip it and select the file we extracted from android studio by saying open file / project. . Waiting for a while after 
choosing, android studio automatically compiles and prepares the project. Then we can run the application with Nexus 5 API 25.
