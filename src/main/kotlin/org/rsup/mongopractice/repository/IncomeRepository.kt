package org.rsup.mongopractice.repository

import org.rsup.mongopractice.repository.model.IncomeDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface IncomeRepository : MongoRepository<IncomeDocument, String>