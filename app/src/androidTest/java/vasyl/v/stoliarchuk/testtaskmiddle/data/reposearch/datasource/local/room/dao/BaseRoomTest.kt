package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.GithubDatabase

@RunWith(AndroidJUnit4::class)
open class BaseRoomTest {
    protected lateinit var githubDatabase: GithubDatabase

    @Before
    fun initDb() {
        githubDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                GithubDatabase::class.java).build()
    }
    @Test
    fun nothing(){} // to run test on whole package

    @After
    fun closeDb() {
        githubDatabase.close()
    }
}