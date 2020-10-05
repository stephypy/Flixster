# Flixster
Flixster is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [x] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [ ] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [ ] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [ ] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [ ] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply the popular ButterKnife annotation library to reduce view boilerplate. (1 point)
- [ ] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

<img src='Flickster_Part2.gif' title='Video Walkthrough' width=500 alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

### Notes

Date: 10/04/2020 <br />
This was a really fun part and I am happy to have learned how to use an Intent; that being said, I also ran into several technical difficulties due to errors when
importing the Youtube PlayerView. It took me awhile, but the TAs were helpful and I learned a lot. My UI/UX design is still incomplete, but part 2 contains more style changes. I am still planning on continuing this project, but its next update might have to wait till winter.

## Flixster Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [ ] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

#### Additional Features
The features below have been designed for portrait mode; a future update will handle landscape layout for the features below:
- [x] Include a explore page to browse movies by genres
   - [ ] Fetch movies based on genre
- [x] Include a watchlist page to save movie titles
   - [ ] Add selected movies to the watchlist fragment
   - [ ] Remove movies from watchlist
   - [ ] Persistence of saved movies in watchlist
- [ ] Allow users to search for movies
   - [x] Search fab on page
   - [ ] API call to find movie

### App Walkthough GIF

<img src='Flickster_Part1.gif' title='Video Walkthrough' width=500 alt='Video Walkthrough' />

<blockquote class="imgur-embed-pub" lang="en" data-id="a/i01jIIk"  ><a href="//imgur.com/a/i01jIIk">Flixster Part 1</a></blockquote>

GIF created with [LiceCap](http://www.cockos.com/licecap/).

### Notes
Date: 09/25/2020 <br />
Instead of just having one main activity, I decided to implement fragments in the app to have three tabs that would represent the homepage, explore page, and the watchlist page. The homepage includes the requirements for the assignment, but it was challenging to translate the code for an activity to a fragment. Namely, in main activity the method onCreate is used while in a fragment the method OnCreateView is used. It took several hours to debug, but I felt satisfied after being able to implement an app with three tabs. I still have future ideas for this app; namely adding functionality to the extra tabs of explore and watchlist since currently they serve as a placeholder for a future update.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
