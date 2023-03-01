package com.example.membersofparlament.Room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.membersofparlament.MainActivity


@Database(entities = [Kansanedustaja::class], version = 4, exportSchema = false)
abstract class KansanedustajaDB: RoomDatabase() {
    abstract val opsLogDAO: OpsLogDAO
    companion object {
        @Volatile
        private var INSTANCE: KansanedustajaDB? = null
        fun getInstance(): KansanedustajaDB {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(MainActivity.appContext, KansanedustajaDB::class.java, "OPSDatabase") //
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
