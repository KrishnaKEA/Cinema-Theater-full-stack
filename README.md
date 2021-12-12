# cinema-app by KODAK


|  Name | gh  
|---|---|
|Adrian|https://github.com/adrian52x|
|Dom|https://github.com/Sintry1|
|Karo|https://github.com/shpomp|
|Krishna|https://github.com/KrishnaKEA|
|Omar|https://github.com/OmarExpo|


### Adrian
Made an endpoint to let an authenticated USER get a list of free/booked seats for a given cinema hall, date and time

### Dom
Made a description (or better implementation) of how you plan to get the “Movie Info”, demo a proof of concept for how to fetch movie data from an external source

### Karo
Attempted endpoint to let an authenticated USER edit a booking, sprint 2 documentation

### Krishna
Made endpoint to let an authenticated USER create a booking for seats for a specific movie, cinema hall and (start) time, made endpoint to let an authenticated USER cancel/edit a booking

### Omar
Completed missing parts from sprint1, Added link to image(s) to “Get Movie Info”


ENDPOINTS Documentation


http://3.90.205.148/users/{email} [find user by emal]
http://3.90.205.148/users/all [all users]
http://3.90.205.148/users/adduser [POST]

http://3.90.205.148/movies [all movies]
http://3.90.205.148/movies/{id} [movie by id]
http://3.90.205.148/movies/addmovie [POST]

http://3.90.205.148/schedules [all schedules]
http://3.90.205.148/schedules/find/{id} [schedule by id]
http://3.90.205.148/schedules/today [today's schedules]
http://3.90.205.148/schedules/week [schedules for 1 week starting from 'today']
http://3.90.205.148/schedules/{date} [schedules for a specific date (yyyy-MM-dd format)]
http://3.90.205.148/schedules/{date}/{timeSlot}/{hall}  [find unique schedule by date, timeSlot (Morning,Afternonn,Evening) and hall (A,B,C)]

http://3.90.205.148/bookings/bookedseats [all booked seats]
http://3.90.205.148/bookings/bookedseats/{date} [all booked seats by date]
http://3.90.205.148/bookings/bookedseats/{date}/{timeSlot} [all booked seats by date and timeSlot]


http://3.90.205.148/bookings/freeseats/{date}/{hall}/{timeSlot} [free seats for a specific schedule that can be identified by date+hall+timeSlot]

http://3.90.205.148/bookings/{date}/{movieName}/}{hallName}/{timeSlot}/{userId}/{seatNr} [book a seat for a specific schedule]