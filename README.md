# My Personal Project — Formula 1 Driver Compare

#### By Tanvi Singh

#### An application that allows users to weigh their favourite Formula 1 drivers up against each other.

### So, what does it do?
The application will allow users to compare the career statistics of two or more Formula 1 drivers at a time. 

This application can be used either as a “*Trumps*” style card game, or it can be used individually to allow enthusiasts 
to analyse and/or compare the performances of their favourite (current or past) Formula 1 drivers.

In this application, the non-trivial class (called X) will be called **Driver**, which will include driver statistics, 
such as name, age, country of origin, current and former teams, and career statistics, such as career points, race wins,
top 3 finishes, pole positions, fastest laps, etc.

The methods that will be called in this class will be methods that can:
- Get the driver information (driverInfo())

The other non-trivial class (called Y) will be called **CompareDriver**, which will aim to compare the drivers, 
by calculating one holistic score for each driver, and picking the higher one.

The methods that will be called in this class will be methods that can:
- Calculate the holistic score (scoreCalculate())
- Compare the scores to each other (scoreCompare())
- Create a pop up image that indicates the “winner” between the drivers picked to be compared (showWinner())

### Who is it for?

This application is targeted to anyone with an interest in Formula 1. New Formula 1 fans can use it to explore the 
entire current driver’s grid, seasoned fans can use it to compare old favourites with new ones, and non-fans can simply 
use it as a card game that resembles “*Trumps*”.


### Why am I doing this?

When I first started gaining an interest in Formula 1, I did not have any guidance as to how to navigate the ever 
confusing grid. With the sport being as chaotic and volatile as it is, there is no fair way to analyse the strength of 
the drivers at face value. To prevent future enthusiasts from scouring the web to look up information about the drivers 
separately, I think that my application would be a big time saver (and good fun)!

### User Stories
- As a long time Formula 1 fan, I want to compare the older icons of the sport to the current World Champion of the 
sport to see how the sport has changed.
- As an avid game player, I want to add drivers to my "stack" (list) of cards, compare my chosen drivers with my
friend's and see who wins!
- As a user who is planning a Ferrari F1 themed party, I want to mathematically compare drivers from the same team over
the years to check how I can dress up as the best ever Ferrari driver!
- As a user who is interested in writing up an analysis about the relationship between fastest lap times and number of 
top 3 finishes, I can use this application to effectively compare specific metrics about the drivers.
- As a user who uses the comparison tool quite often, I want to be able to load data that I had previously saved of the 
drivers, so I can continue comparing them without losing the data.
- As a user, I want to be able to save a list of Formula One drivers of this current season, so I can compare their 
stats with drivers in future seasons. 

# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by clicking the "Add Driver" button; 
  this allows you to manually enter details of your favourite F1 driver!
- You can generate the second required action related to adding Xs to a Y by clicking the "Compare Driver" button; this 
  button displays the winning driver!
- You can locate my visual component by starting my application; you will see a splash screen of the logo once the 
  application is open!
- You can save the state of my application by clicking the "Save Data" button
- You can reload the state of my application by clicking the "Load Data" button
  