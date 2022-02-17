package com.dailynotes.data

import androidx.room.Database
import androidx.room.Room
import com.dailynotes.model.Note
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: android.content.Context) : NoteDatabase{
            val instance = INSTANCE
            if(instance != null){
                return instance
            }
            synchronized(this){
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }
    }
}