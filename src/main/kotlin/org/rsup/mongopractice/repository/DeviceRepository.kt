package org.rsup.mongopractice.repository

import org.rsup.mongopractice.repository.model.DeviceDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface DeviceRepository : MongoRepository<DeviceDocument, String>