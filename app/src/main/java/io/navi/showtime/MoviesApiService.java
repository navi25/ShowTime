package io.navi.showtime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface MoviesApiService {
    @GET(Constants.POPULAR_MOVIES_ENDPOINT)
    Call<Movie.MovieResult> getPopularMovies();
}
