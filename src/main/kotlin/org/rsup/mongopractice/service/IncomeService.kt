package org.rsup.mongopractice.service

import org.rsup.mongopractice.controller.payload.CreateIncomeRequestVO
import org.rsup.mongopractice.repository.IncomeRepository
import org.rsup.mongopractice.repository.UserRepository
import org.rsup.mongopractice.repository.model.IncomeDocument
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IncomeService(private val userRepository: UserRepository, private val incomeRepository: IncomeRepository) {

    @Transactional
    fun create(createIncomeRequestVO: CreateIncomeRequestVO) {
        val userDocument = userRepository.findById(createIncomeRequestVO.userId)
            .orElseThrow()
        val incomeDocument = IncomeDocument(salary = createIncomeRequestVO.salary, stock = createIncomeRequestVO.stock, userId = createIncomeRequestVO.userId)
        userDocument.incomeDocument = incomeDocument

        incomeRepository.save(incomeDocument)
        userRepository.save(userDocument)

//        throw RuntimeException("트랜잭션!!!")
    }
}