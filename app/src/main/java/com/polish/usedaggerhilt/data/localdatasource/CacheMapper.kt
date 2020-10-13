package com.polish.usedaggerhilt.data.localdatasource

import com.polish.usedaggerhilt.model.POSTItem
import com.polish.usedaggerhilt.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject constructor(): EntityMapper<PostCacheEntity, POSTItem> {
    override fun mapFromEntity(entity: PostCacheEntity): POSTItem {
        return POSTItem(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            userId = entity.userId
        )
    }

    override fun mapToEntity(domainModel: POSTItem): PostCacheEntity {
        return PostCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            userId = domainModel.userId
        )
    }

    fun mapFromEntityList(entities:List<PostCacheEntity>):List<POSTItem>{
        return entities.map { mapFromEntity(it) }
    }
}