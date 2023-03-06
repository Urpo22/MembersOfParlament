package com.example.membersofparlament.Room

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity
data class Kansanedustaja(
        @PrimaryKey(autoGenerate = false)
        val hetekaId: Int,
        val lastname: String,
        val firstname: String,
        val seatNumber: Int,
        val party: String,
        val minister: Boolean,
        val pictureUrl: String,

) : Parcelable

@Dao interface OpsLogDAO {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: List<Kansanedustaja>)
    @Query("select * from Kansanedustaja")
    fun getAll(): LiveData<List<Kansanedustaja>>

}
