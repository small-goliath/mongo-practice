package org.rsup.mongopractice.service

import org.rsup.mongopractice.controller.payload.CreateIncomeRequestVO
import org.rsup.mongopractice.repository.IncomeRepository
import org.rsup.mongopractice.repository.UserRepository
import org.rsup.mongopractice.repository.model.IncomeDocument
import org.springframework.stereotype.Service

@Service
class IncomeService(private val userRepository: UserRepository, private val incomeRepository: IncomeRepository) {

    fun create(createIncomeRequestVO: CreateIncomeRequestVO) {
        val userDocument = userRepository.findById(createIncomeRequestVO.userId)
            .orElseThrow()
        val incomeDocument = IncomeDocument(salary = createIncomeRequestVO.salary, stock = createIncomeRequestVO.stock, userDocument = userDocument)
        userDocument.income = incomeDocument

        incomeRepository.save(incomeDocument)
        userRepository.save(userDocument)
    }
}