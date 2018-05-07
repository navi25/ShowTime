package io.navi.showtime;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MoviesAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("aUsername", "aPassword"));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3")
                .client(okHttpClient)
                .build();

        MoviesApiService service = restAdapter.create(MoviesApiService.class);

//        final Callback callback = new Callback< Movie.MovieResult>() {
//            @Override
//            public void onResponse(Call<Movie.MovieResult> call, Response response) {
//                Movie.MovieResult movieResult = call.enqueue();
//                mAdapter.setMovieList(movieResult.getResults());
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//
//            }
//        }

//        service.getPopularMovies(new Callback() {
//            @Override
//            public void onResponse(, Response response) {
//
//            }
//
//
//        });

    }


    //View Holder
    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public MovieViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public static class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder>
    {
        private List<Movie> mMovieList;
        private LayoutInflater mInflater;
        private Context mContext;

        public MoviesAdapter(Context context)
        {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
            this.mMovieList = new ArrayList<>();
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = mInflater.inflate(R.layout.row_movie, parent, false);
            MovieViewHolder viewHolder = new MovieViewHolder(view);
            return viewHolder;
        }

        //Adapter
        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position)
        {
            Movie movie = mMovieList.get(position);

            // This is how we use Picasso to load images from the internet.

            Picasso.with(mContext).setLoggingEnabled(true);

            Picasso.with(mContext)
                    .load(movie.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount()
        {
            return (mMovieList == null) ? 0 : mMovieList.size();
        }

        public void setMovieList(List<Movie> movieList)
        {
            this.mMovieList.clear();
            this.mMovieList.addAll(movieList);
            // The adapter needs to know that the data has changed. If we don't call this, app will crash.
            notifyDataSetChanged();
        }
    }


}
