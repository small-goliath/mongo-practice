package org.rsup.mongopractice.controller

import org.rsup.mongopractice.controller.payload.CreateUserRequestVO
import org.rsup.mongopractice.controller.payload.ModifyUserRequestVO
import org.rsup.mongopractice.controller.payload.SearchUserResponseVO
import org.rsup.mongopractice.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun create(@RequestBody createUserRequestVO: CreateUserRequestVO) {
        println("유저를 등록합니다: $createUserRequestVO")
        userService.create(createUserRequestVO)
    }

    @GetMapping("/{id}")
    fun search(@PathVariable id: String): SearchUserResponseVO {
        println("$id 유저를 조회합니다.")
        val userEntity = userService.search(id)
        return SearchUserResponseVO(userEntity)
    }

    @PutMapping("/{id}")
    fun modify(@PathVariable id: String, @RequestBody modifyUserRequestVO: ModifyUserRequestVO) {
        println("$id 유저를 수정합니다: $modifyUserRequestVO")
        userService.modify(id, modifyUserRequestVO)
    }

    @DeleteMapping("/{id}")
    fun modify(@PathVariable id: String) {
        println("$id 유저를 삭제합니다.")
        userService.delete(id)
    }
}