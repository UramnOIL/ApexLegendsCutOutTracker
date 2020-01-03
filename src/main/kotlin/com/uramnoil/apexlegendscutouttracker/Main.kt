package com.uramnoil.apexlegendscutouttracker

import java.io.File
import javax.imageio.ImageIO

fun main() {
    val imagesDirectory = File("images/")
    if(!imagesDirectory.exists() or !imagesDirectory.isDirectory) {
        imagesDirectory.mkdir()
    }

    val resultsDirectory = File("results/")
    if(!resultsDirectory.exists() or !resultsDirectory.isDirectory) {
        resultsDirectory.mkdir()
    }
    imagesDirectory.listFiles()?.forEach {
        val img = ImageIO.read(it)
        val subImage = img.getSubimage(1197, 274, 508, 687)
        var output = File(resultsDirectory.path + "/" + it.name)
        val n = 1;
        while (output.exists()) {
            output = File(output.path + "(" + n.toString() + ")")
        }
        ImageIO.write(subImage, "png", output)
    }
}