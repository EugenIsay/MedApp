package com.example.medapp.images

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

class Repository(val context: Context) {

    fun getImages(): List<Uri>{
        val dir = File(context.filesDir, DIR_IMAGES)
        if(!dir.exists()){
            dir.mkdirs()
            return emptyList()
        }
        return dir.listFiles()?.map { file -> file.path.toUri() } ?: emptyList()
    }

    fun saveImage(bitmap: Bitmap): Uri?{
        val dir  = File(context.filesDir, DIR_IMAGES)
        if (!dir.exists()){
            dir.mkdirs()
        }
        return try {
            val file = File(dir, UUID.randomUUID().toString())
            val fileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()
            file.path.toUri()
        } catch (e: Exception){
            null
        }
    }

    companion object RepositoryHelper{
        const val DIR_IMAGES = "images"
    }
}