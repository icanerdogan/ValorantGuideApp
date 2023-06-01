package com.ibrahimcanerdogan.valorantguideapp.data.database.map

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData

@Dao
interface MapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMapDatabase(listMapData: List<MapData>)

    @Query("SELECT * FROM map_data")
    fun getMapListDatabase(): List<MapData>

}