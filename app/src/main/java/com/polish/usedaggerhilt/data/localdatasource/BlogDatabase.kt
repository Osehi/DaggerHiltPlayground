package com.polish.usedaggerhilt.data.localdatasource

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * this is the database to hold or store posts and comments
 */
@Database(entities = [PostCacheEntity::class], version = 1, exportSchema = false)
abstract class BlogDatabase:RoomDatabase(){

    abstract fun postDao():POSTitemDao

    companion object {
        val DATABASE_NAME:String = "blog_database"
    }

}