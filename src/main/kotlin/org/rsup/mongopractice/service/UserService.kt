package org.rsup.mongopractice.service

import org.rsup.mongopractice.controller.payload.CreateUserRequestVO
import org.rsup.mongopractice.controller.payload.ModifyUserRequestVO
import org.rsup.mongopractice.repository.UserRepository
import org.rsup.mongopractice.repository.model.UserDocument
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(createUserRequestVO: CreateUserRequestVO) {
        val userDocument = UserDocument(name = createUserRequestVO.name)
        userRepository.save(userDocument)
    }

    fun search(id: String): UserDocument {
        return userRepository.findById(id)
            .orElse(UserDocument(name = "유저 없음"))
    }

    fun modify(id: String, modifyUserRequestVO: ModifyUserRequestVO) {
        val user = userRepository.findById(id)
            .orElse(null)
        if (user == null) {
            throw RuntimeException("변경할 유저 없음")
        }
        val updatedUser = user.copy(name = modifyUserRequestVO.name)
        userRepository.save(updatedUser)
    }

    fun delete(id: String) {
        userRepository.deleteById(id)
    }
}