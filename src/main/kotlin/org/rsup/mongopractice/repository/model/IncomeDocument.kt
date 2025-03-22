package org.rsup.mongopractice.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.util.UUID

@Document(collection = "income")
data class IncomeDocument(

    @Id
    val id: String = UUID.randomUUID().toString(),

    val salary: Long,   // 연봉 소득

    val stock: Long,     // 주식 소득

    @DocumentReference
    val userDocument: UserDocument // UserDocument와 1:1 관계 매핑
)