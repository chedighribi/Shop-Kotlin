package fr.eni.shop_info.bo

import java.util.Date

data class Article(
    var id: Long = 0,
    var name: String = "",
    var description: String = "",
    var price: Float = 0f,
    var date: Date = Date(),
    var urlImage: String = "",
    var category : String = "",
)
