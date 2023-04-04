package github.buttm.restfulapi.belajarrestfulapi.util

interface EntityMapper <Entity, DomainModel>{
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel):Entity
}