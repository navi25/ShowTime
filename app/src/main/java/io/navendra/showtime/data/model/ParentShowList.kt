package io.navendra.showtime.data.model

import java.util.*

/**
 * Data class for Parent recyclerview showcasing various shows of same genres
 */
data class ParentShowList(
        val id:Int,
        val category: String,
        val shows: MutableList<Show>?
)