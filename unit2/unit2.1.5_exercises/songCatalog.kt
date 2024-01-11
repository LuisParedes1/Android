// Exercise 4: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#4

/*
    Imagine that you need to create a music-player app.

    Create a class that can represent the structure of a song. The Song class must include these code elements:

        Properties for the title, artist, year published, and play count
        A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
        A method that prints a song description in this format:

    "[Title], performed by [artist], was released in [year published]."
 */

 class Song(val title: String,
           val artist: String,
           val yearPublished: Int,
           var playCount: Int
          ){
    
    var isPopular: Boolean = if (playCount > 1000) {true} else {false}
    
    fun printSongDescription(){
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main(){
    val song: Song = Song(title = "Tu no vive asi",
                          artist = "Bad Bunny",
                          yearPublished = 2016,
                          playCount = 0
                         )
    
    song.printSongDescription()
}