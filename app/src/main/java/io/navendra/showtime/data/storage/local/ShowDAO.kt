//package io.navendra.showtime.data.storage.local
//
//import androidx.lifecycle.MutableLiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import io.navendra.showtime.AppConstants.ShowTable.Queries as ShowQueryConstants
//import io.navendra.showtime.data.model.Show
//
//
//@Dao
//interface ShowDAO {
//
//    @Query(ShowQueryConstants.GET_ALL)
//    fun getAllShows(): MutableLiveData<List<Show>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(show: Show)
//
//    @Query(ShowQueryConstants.DELETE_ALL)
//    fun deleteAll()
//}