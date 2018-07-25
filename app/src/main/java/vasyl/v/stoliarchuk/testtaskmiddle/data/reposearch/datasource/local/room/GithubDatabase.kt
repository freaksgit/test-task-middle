package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room

import android.arch.persistence.db.SimpleSQLiteQuery
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.LicenseDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.OwnerDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.RepositoryDataDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData

@Database(entities = arrayOf(
        RoomRepositoryData::class,
        RoomLicense::class,
        RoomOwner::class), version = 1, exportSchema = false)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun repositoryDataDao(): RepositoryDataDao
    abstract fun licenseDao(): LicenseDao
    abstract fun onwerDao(): OwnerDao

    companion object {
        private var INSTANCE: GithubDatabase? = null

        fun getInstance(context: Context): GithubDatabase? {
            if (INSTANCE == null) {
                synchronized(GithubDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                GithubDatabase::class.java, "weather.db")
                                .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    fun clearAndResetAllTables(): Boolean {
        val query = SimpleSQLiteQuery("DELETE FROM sqlite_sequence")
        beginTransaction()
        return try {
            clearAllTables()
            query(query)
            setTransactionSuccessful()
            true
        } catch (e: Exception) {
            false
        } finally {
            endTransaction()
        }
    }
}