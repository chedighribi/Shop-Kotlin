package fr.eni.shop_info.dao

import fr.eni.shop_info.bo.Article

interface ArticleDao {
    fun insert(article: Article): Long
    fun findById(id: Long): Article?
    fun findAll(): List<Article>
}