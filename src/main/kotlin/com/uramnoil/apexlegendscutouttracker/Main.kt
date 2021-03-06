package com.uramnoil.apexlegendscutouttracker

import java.io.File
import javax.imageio.ImageIO

fun main() {
    val imagesDirectory = File(System.getProperty("user.dir") + "/images")
    if(!imagesDirectory.exists() or !imagesDirectory.isDirectory) {
        imagesDirectory.mkdir()
    }

    val resultsDirectory = File(System.getProperty("user.dir") + "/results")
    if(!resultsDirectory.exists() or !resultsDirectory.isDirectory) {
        resultsDirectory.mkdir()
    }

    imagesDirectory.listFiles()?.forEach {
        try {
            val img = ImageIO.read(it)
            val subImage = img.getSubimage(1197, 274, 508, 687)
            val original = File(resultsDirectory, it.name)
            var output = original
            val basename = original.name
            var n = 1
            while (output.exists()) {
                output = File(original.parent + "/" + basename.substring(0, basename.lastIndexOf(".")) + "(" + n++.toString() + ")" + ".png")
            }
            ImageIO.write(subImage, "png", output)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}