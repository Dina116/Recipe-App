package com.training.recipeapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [User::class, FavoriteRecipe::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun favoriteRecipeDao(): FavoriteRecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val MIGRATION_2_4 = object : Migration(2, 4) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        // Create a new table without the profile_picture_url column
                        database.execSQL("""
                            CREATE TABLE IF NOT EXISTS users_new (
                                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                                email TEXT NOT NULL,
                                username TEXT NOT NULL,
                                hashedPassword TEXT NOT NULL
                            )
                        """.trimIndent())

                        // Copy the data from the old table to the new table
                        database.execSQL("""
                            INSERT INTO users_new (id, email, username, hashedPassword)
                            SELECT id, email, username, hashedPassword FROM users
                        """.trimIndent())

                        // Drop the old table
                        database.execSQL("DROP TABLE IF EXISTS users")

                        // Rename the new table to the old table name
                        database.execSQL("ALTER TABLE users_new RENAME TO users")
                    }
                }

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addMigrations(MIGRATION_2_4)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}
