# KODAK cinema API documentation

# **MOVIE**

<span style="background-color:blue">**GET** [/movies](http://localhost:8082/movies) get a list of all movies
</span>

**Model:**

```
[
  {
    id: long, 
    name: string, 
    story: string, 
    rating: enum[ low, medium, high ], 
    actor: string
  }
]
```

rating ❓

**Example value:**

```json
[
  {
    "id": 1, 
    "name": "Fast and Furious 8", 
    "story": "With Dom and Letty married, Brian and Mia retired and the rest of the crew exonerated, the globe-trotting team has found some semblance of a normal life", 
    "rating": "High", 
    "actor": "Vin Diesel and Tyrese Gibson"
  }, 
  {
    "id": 2, 
    "name": "Titanic", 
    "story": "James Cameron is 'Titanic' is an epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic; the pride and joy of the White Star Line and, at the time, the largest moving object ever built.", 
    "rating": "High", 
    "actor": " Leonardo DiCaprio and Kate Winslet"
  }
]
```

**Responses:**

code | description
------------ | -------------
200 | successful operation
404| data not found

<br/><br/>

<span style="background-color:blue">**GET** [/movies/{movieId}](http://localhost:8082/movies/1) get a specific movie by id
</span>

**Model:**

```
{
  id: long,
  name: string,
  story: string,
  rating: enum: [ low, medium, high ],
  actor: string
}
```

rating ❓

**Example value:**

```json
{
    "id": 1, 
    "name": "Fast and Furious 8",
    "story": "With Dom and Letty married, Brian and Mia retired and the rest of the crew exonerated, the globe-trotting team has found some semblance of a normal life",
    "rating": "High",
    "actor": "Vin Diesel and Tyrese Gibson"
 }
```

**Responses:**

code | description
------------ | -------------
200 | successful operation
400 | invalid movie id supplied
404	| movie not found

<br/><br/>


<span style="background-color:green">**POST** [/movies/new](http://localhost:8082/movies/new)  add a new movie
</span>

**Parameters:**

body: movie object that needs to be added to the database

**Model:**

```
{
  name: string,
  story: string,
  rating: enum: [ low, medium, high ],
  actor: string
}
```

**Example value:**

```json
{
  "name": "Tennet", 
  "story": "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.", 
  "rating": "High", 
  "actor": "John David Washington and Robert Pattinson"
 }
```

**Responses:**

code | description
------------ | -------------
201 | successful operation
405 | invalid request body

<br/><br/>

<span style="background-color:orange">**PUT** [/movies/update/{movieID}](http://localhost:8082/movies/update/99) update a specific movie by id
</span>

**Parameters:**

body: movie object that needs to be updated in the database

**Model:**

```
{
  name: string,
  story: string,
  rating: enum: [ low, medium, high ],
  actor: string
}
```

**Example value:**

```json
{
  "id": 1, 
  "rating": "low"
}
```

**Responses:**

code | description
------------ | -------------
201 | successful operation
400 |invalid movie id supplied
404 | movie not found
405 | invalid request body


<br/><br/>

<span style="background-color:red">**DELETE** [/movies/delete/{movieID}](http://localhost:8082/movies/delete/99) delete a specific movie by id
</span>

**Parameters:**

id: id of the movie that needs to be deleted

**Responses:**

code | description
------------ | -------------
201 | successful operation
400 |invalid movie id supplied
404 | movie not found

<hr>

# SCHEDULE

<span style="background-color:blue">**GET** [/schedule/{date}](http://localhost:8082/schedule/15-10-2021) movie showings in the theater for a specific date
</span>

**Parameters:**

date: a specific date for which to show the movie showings information

**Model:**

```
[
  {
    id: long, 
    movie_id: integer,
    date: string,
    hall_id: integer,
    slot_id: integer
  }
]
```

date string❓

Example value:

```json
[
  {
    "id": 1, 
    "movie_id": 2,
    "date": "15-10-2021",
    "hall_id": 2, 
    "slot_id": 3
  }
]
```
**Responses:**

code | description
------------ | -------------
201 | successful operation
400 |invalid date supplied
404 | data not found

<br/><br/>

<span style="background-color:blue">**GET** [/schedule/{startingDate}](http://localhost:8082/schedule/15-10-2021) movie showings in the theater for a week from a specific starting date
</span>

**Parameters:**

startingDate: a specific date as a starting date for the interval for which to show the movie showings information (7 days)

**Model:**

```
[
  {
    id: long,
    movie_id: integer,
    date: string,
    hall_id: integer,
    slot_id: integer
  }
]
```

date string❓

Example value:

```json
[
  {
    "id": 1,
    "movie_id": 2,
    "date": "15-10-2021",
    "hall_id": 2, 
    "slot_id": 3
  }, 
  {
    "id": 2,
    "movie_id": 4,
    "date": "17-10-2021",
    "hall_id": 2, 
    "slot_id": 3
  }
]
```
**Responses:**

code | description
------------ | -------------
201 | successful operation
400 |invalid date supplied
404 | data not found

<hr>

# **MODELS**
... to be added.

<hr>

## 🪛 SCRUM

meeting minutes 14/10/2021

Krishna  working on implementing security

Dominic working on fetching the movie showings for a specific date

Omar working on fetching movie information

Adrian solving problems with nested objects when fetching movies by date interval and working on processing date interval for the GET endpoint

Karolina  continuing forming API documentation