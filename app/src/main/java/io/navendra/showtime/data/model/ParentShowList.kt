package io.navendra.showtime.data.model


/**
 * Data class for Parent recyclerview showcasing various results of same genres
 */

data class ParentShowList(
        val id:Int,
        val category: String,
        val shows: MutableList<Show>?
){

//    companion object {
//        val showList = mutableListOf<Show>()
//        val parentShowList = mutableListOf<ParentShowList>()
//
//        fun random(category: String = "POPULAR") : ParentShowList {
//            repeat(4){
//                showList.add(Show.random())
//            }
//            return ParentShowList(0,category,showList)
//        }
//
//        fun randomList() : MutableList<ParentShowList>{
//            parentShowList.add(random())
//            parentShowList.add(random("UPCOMING"))
//            return parentShowList
//        }
//    }

}