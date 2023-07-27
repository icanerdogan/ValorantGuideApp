package com.ibrahimcanerdogan.valorantguideapp.data.database.weapon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData

@Dao
interface WeaponDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeaponDatabase(agentList: List<WeaponData>)

    @Query("SELECT * FROM weapon_data")
    fun getWeaponListDatabase(): List<WeaponData>
}