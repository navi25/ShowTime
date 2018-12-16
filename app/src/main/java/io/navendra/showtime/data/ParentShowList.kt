package io.navendra.showtime.data

/**
 * Data class for Parent recyclerview showcasing various shows of same genres
 */
data class ParentShowList(
        val id:Int,
        val genre:Genre,
        val shows: MutableList<Show>
)