package org.rsup.mongopractice.service

import org.rsup.mongopractice.controller.payload.CreateDeviceRequestVO
import org.rsup.mongopractice.repository.DeviceRepository
import org.rsup.mongopractice.repository.UserRepository
import org.rsup.mongopractice.repository.model.DeviceDocument
import org.springframework.stereotype.Service

@Service
class DeviceService(private val userRepository: UserRepository, private val deviceRepository: DeviceRepository) {

    fun create(createDeviceRequestVO: CreateDeviceRequestVO) {
        val userDocument = userRepository.findById(createDeviceRequestVO.userId)
            .orElseThrow()
        val deviceDocument = DeviceDocument(name = createDeviceRequestVO.name, userId = createDeviceRequestVO.userId)
        userDocument.deviceDocuments.plus(deviceDocument)

        deviceRepository.save(deviceDocument)
        userRepository.save(userDocument)
    }
}