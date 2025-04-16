package fr.eni.shop_info.dao

import fr.eni.shop_info.dao.memory.ArticleDaoMemoryImpl

abstract class DaoFactory {
    companion object {
        fun createArticleDao(type: DaoType): ArticleDao {

            val dao: ArticleDao

            when (type) {
                DaoType.MEMORY -> dao = ArticleDaoMemoryImpl()
                DaoType.NETWORK -> TODO()
            }

            return dao
        }
    }

}