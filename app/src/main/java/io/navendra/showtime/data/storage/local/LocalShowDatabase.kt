//package io.navendra.showtime.data.storage.local
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import io.navendra.showtime.AppConstants.ShowTable as ShowConstant
//import io.navendra.showtime.data.model.Show
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//@Database(entities = [Show::class], version = 1)
//abstract class LocalShowDatabase : RoomDatabase(){
//    abstract fun showDAO(): ShowDAO
//
//
//    private class ShowDatabaseCallback(private val scope: CoroutineScope) :RoomDatabase.Callback() {
//
//        override fun onOpen(db: SupportSQLiteDatabase) {
//            super.onOpen(db)
//            INSTANCE?.let { localShowDatabase ->
//                scope.launch (Dispatchers.IO){
//                    populateDatabase(localShowDatabase.showDAO())
//                }
//            }
//        }
//
//        fun populateDatabase(showDAO: ShowDAO){
////            showDAO.deleteAll()
//
//        }
//
//    }
//
//
//    companion object {
//        @Volatile
//        private var INSTANCE: LocalShowDatabase? = null
//
//        fun getDatabase(context: Context, scope: CoroutineScope) : LocalShowDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                            context.applicationContext,
//                            LocalShowDatabase::class.java,
//                            ShowConstant.DATABASE_NAME
//                        )
//                        .addCallback(ShowDatabaseCallback(scope))
//                        .build()
//
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}