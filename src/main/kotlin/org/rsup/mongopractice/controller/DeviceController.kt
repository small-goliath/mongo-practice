package org.rsup.mongopractice.controller

import org.rsup.mongopractice.controller.payload.CreateDeviceRequestVO
import org.rsup.mongopractice.service.DeviceService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/devices")
class DeviceController(private val deviceService: DeviceService) {

    @PostMapping
    fun create(@RequestBody createDeviceRequestVO: CreateDeviceRequestVO) {
        println("장비를 할당합니다: $createDeviceRequestVO")
        deviceService.create(createDeviceRequestVO)
    }
}