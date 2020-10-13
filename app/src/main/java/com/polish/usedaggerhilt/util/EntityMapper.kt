package com.polish.usedaggerhilt.util

/**
 * this Entity mapper provides the entity and the domainModel to be mapped by the NetworkMApper
 * it takes a generic object
 */
interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity:Entity):DomainModel

    fun mapToEntity(domainModel:DomainModel):Entity

}