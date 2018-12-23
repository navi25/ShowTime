package io.navendra.showtime.service


class ShowRepository(api : ShowsApiService){

    val popularShows = api.getPopularShows()
    val upcomingShows = api.getUpcomingShows()
    val nowPlayingShows = api.getNowPlayingShows()
    val topRatedShows = api.getTopRatedShows()



}