package io.navendra.showtime.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.navendra.showtime.AppConstants.ShowTable as ShowConstant
import io.navendra.showtime.data.model.Show

@Database(entities = [Show::class], version = 1)
abstract class LocalShowDatabase : RoomDatabase(){
    abstract fun showDAO(): ShowDAO

    companion object {
        @Volatile
        private var INSTANCE: LocalShowDatabase? = null

        fun getDatabase(context: Context) : LocalShowDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalShowDatabase::class.java,
                        ShowConstant.DATABASE_NAME)
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}