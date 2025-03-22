package org.rsup.mongopractice.controller

import org.rsup.mongopractice.controller.payload.CreateIncomeRequestVO
import org.rsup.mongopractice.service.IncomeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/income")
class IncomeController(private val incomeService: IncomeService) {

    @PostMapping
    fun create(@RequestBody createIncomeRequestVO: CreateIncomeRequestVO) {
        println("소득을 등록합니다: $createIncomeRequestVO")
        incomeService.create(createIncomeRequestVO)
    }
}