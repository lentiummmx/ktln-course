package com.example.jomorales.kotlincourse.presenter

import android.os.Handler
import com.example.jomorales.kotlincourse.model.Movie
import com.example.jomorales.kotlincourse.model.MoviesResult

class MoviesPresenter(private val callback: MoviesCallback) {

    fun fetchMovies() {
        callback.onViewStateChanged(MoviesResult.Loading)
        Handler().postDelayed({
            callback.onViewStateChanged(MoviesResult.Success(createDummyMovies()))
        }, 5000)
    }

    private fun createDummyMovies(): ArrayList<Movie> {
        val result: ArrayList<Movie> = arrayListOf()

        result.add(Movie(1, "Terminator", "The Terminator series is an American science-fiction franchise created by James Cameron and Gale Anne Hurd. It encompasses a series of films, comics, novels, and additional media concerning battles between Skynet's synthetic intelligent machine network, and John Connor's Resistance forces and the rest of the human race.", "AA", 5, "https://501mustseemoviesproject.files.wordpress.com/2014/04/terminatorposter.jpg"))
        result.add(Movie(2, "Alien", "Alien is a 1979 science fiction horror film directed by Ridley Scott, and starring Sigourney Weaver, Tom Skerritt, Veronica Cartwright, Harry Dean Stanton, John Hurt, Ian Holm and Yaphet Kotto. It is the first film in what became a large Alien franchise.", "AAA", 5, "https://duckduckgo.com/i/cac3e63c.jpg"))
        result.add(Movie(3, "Inglourious Basterds", "Inglourious Basterds is a 2009 war film written and directed by Quentin Tarantino and starring Brad Pitt, Christoph Waltz, Michael Fassbender, Eli Roth, Diane Kruger, Til Schweiger, and Mélanie Laurent.", "C", 5, "https://duckduckgo.com/i/5367ba34.jpg"))
        result.add(Movie(4, "Kill Bill: Volume 1", "Kill Bill: Volume 1 is a 2003 American martial arts film written and directed by Quentin Tarantino. It stars Uma Thurman as the Bride, who swears revenge on a team of assassins and their leader Bill after they try to kill her and her unborn child. Her journey takes her to Japan, where she battles the Tokyo yakuza.", "C", 5, "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.impdb.org%2Fimages%2F0%2F0d%2FKillBillcover.jpg&f=1"))
        result.add(Movie(5, "Kill Bill: Volume 2", "Kill Bill: Volume 2 is a 2004 American martial arts film written and directed by Quentin Tarantino. It stars Uma Thurman as the Bride, who continues her campaign of revenge against the Deadly Viper Assassination Squad (Lucy Liu, Michael Madsen, Daryl Hannah, and Vivica A. Fox) and their leader Bill (David Carradine), who tried to kill her and her unborn child.", "C", 5, "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fcdn.miramax.com%2Fmedia%2Fassets%2Fkill_bill_2_scrubbed_150402.jpg&f=1"))
        result.add(Movie(6, null, null, null, null, null))
        result.add(Movie(7, null, null, null, null, null))
        result.add(Movie(8, null, null, null, null, null))
        result.add(Movie(9, null, null, null, null, null))
        result.add(Movie(10, null, null, null, null, null))

        return result
    }

}