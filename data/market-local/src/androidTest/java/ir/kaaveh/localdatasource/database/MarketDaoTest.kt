package ir.kaaveh.localdatasource.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import ir.kaaveh.localdatasource.test.favoriteLocalMarketDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class MarketDaoTest {

    private lateinit var marketDao: MarketDao
    private lateinit var db: MarketsDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MarketsDatabase::class.java).build()
        marketDao = db.marketDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun emptyTableAtDbInitialization() = runTest {
        val marketList = marketDao.getMarketList().first()
        assertTrue(marketList.isEmpty())
    }

    @Test
    @Throws(Exception::class)
    fun insertNewsToDb() = runTest {
        marketDao.insertMarketList(favoriteLocalMarketDto)
        val newsList = marketDao.getMarketList().first()
        assertTrue(newsList.contains(favoriteLocalMarketDto))
    }

}