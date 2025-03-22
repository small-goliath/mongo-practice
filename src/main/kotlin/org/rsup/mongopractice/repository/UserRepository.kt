package org.rsup.mongopractice.repository

import org.rsup.mongopractice.repository.model.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<UserDocument, String>