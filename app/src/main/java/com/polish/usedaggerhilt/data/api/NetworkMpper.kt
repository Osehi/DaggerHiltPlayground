package com.polish.usedaggerhilt.data.api

import com.polish.usedaggerhilt.data.POSTNetworkEntity
import com.polish.usedaggerhilt.model.POST
import com.polish.usedaggerhilt.model.POSTItem
import com.polish.usedaggerhilt.util.EntityMapper
import javax.inject.Inject

/**
 * this implements the mapping between the data from the network to the app data
 */

class NetworkMpper @Inject constructor(): EntityMapper<POSTNetworkEntity, POSTItem> {
    override fun mapFromEntity(entity: POSTNetworkEntity): POSTItem {
        return POSTItem(
            id = entity.id,
            userId = entity.userId,
            title = entity.title,
            body = entity.body

        )
    }

    override fun mapToEntity(domainModel: POSTItem): POSTNetworkEntity {
        return POSTNetworkEntity(
            id = domainModel.id,
            userId = domainModel.userId,
            title = domainModel.title,
            body = domainModel.body

        )
    }

    fun mapFromEntityList(entities:List<POSTNetworkEntity>):List<POSTItem>{
        return entities.map {
            mapFromEntity(it)
        }
    }
}