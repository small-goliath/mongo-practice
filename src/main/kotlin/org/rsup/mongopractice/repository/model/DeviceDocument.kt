package org.rsup.mongopractice.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "devices")
data class DeviceDocument(

    @Id
    val id: String = UUID.randomUUID().toString(),

    val name: String,

    val userId: String  // 단방향 1:N 관계
)