package org.rsup.mongopractice.service

import org.rsup.mongopractice.controller.payload.CreateDeviceRequestVO
import org.rsup.mongopractice.repository.DeviceRepository
import org.rsup.mongopractice.repository.UserRepository
import org.rsup.mongopractice.repository.model.DeviceDocument
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeviceService(private val userRepository: UserRepository, private val deviceRepository: DeviceRepository) {

    @Transactional
    fun create(createDeviceRequestVO: CreateDeviceRequestVO) {
        val userDocument = userRepository.findById(createDeviceRequestVO.userId)
            .orElseThrow()

        val deviceDocument = DeviceDocument(name = createDeviceRequestVO.name, userId = createDeviceRequestVO.userId)
        userDocument.deviceDocuments.add(deviceDocument)

        deviceRepository.save(deviceDocument)
        userRepository.save(userDocument)

        throw RuntimeException("트랜잭션!!!")
    }
}