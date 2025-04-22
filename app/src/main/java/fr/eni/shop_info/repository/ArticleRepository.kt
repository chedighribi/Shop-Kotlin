package fr.eni.shop_info.repository

import fr.eni.shop_info.bo.Article
import fr.eni.shop_info.dao.ArticleDao
import fr.eni.shop_info.dao.DaoFactory
import fr.eni.shop_info.dao.DaoType

class ArticleRepository() {

    private val articleDAO : ArticleDao = DaoFactory.createArticleDao(DaoType.MEMORY)

    fun getArticle(id : Long) : Article? {
        return articleDAO.findById(id)
    }

    fun addArticle(article: Article) : Long {
        return articleDAO.insert(article)
    }

    fun getAllArticles(): List<Article> {
        return articleDAO.findAll()
    }


}