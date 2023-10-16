package com.ibrahimcanerdogan.valorantguideapp.data.database.other

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData

@Dao
interface ArmorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArmorDatabase(listMapData: List<ArmorData>)

    @Query("SELECT * FROM armor_data")
    fun getArmorListDatabase(): List<ArmorData>

}