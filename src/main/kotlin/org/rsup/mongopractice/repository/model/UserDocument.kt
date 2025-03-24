package org.rsup.mongopractice.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.util.UUID

@Document(collection = "users")
data class UserDocument(

    @Id
    val id: String? = UUID.randomUUID().toString(),

    val name: String,

    @DocumentReference
    var incomeDocument: IncomeDocument? = null,

    @DocumentReference
    val deviceDocuments: MutableList<DeviceDocument> = mutableListOf()
)