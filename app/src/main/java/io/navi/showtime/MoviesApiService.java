package io.navi.showtime;

import retrofit2.Callback;
import retrofit2.http.GET;

public interface MoviesApiService {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);
}
