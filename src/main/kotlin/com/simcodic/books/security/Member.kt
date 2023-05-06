package com.simcodic.books.security

import com.simcodic.books.security.User
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.util.*

@Entity
@DiscriminatorValue(value = "MEMBER")
class Member(
    id: String = "",
    email: String = "",
    pwd: String = "",
    firstName: String = "",
    lastName: String = "",
    roles: String = "",
    enabled: Boolean = true,
    accountNonExpired: Boolean = true,
    accountNonLocked: Boolean = true,
    credentialsNonExpired: Boolean = true,
    created: Date = Date(),
    modified: Date = Date()
) : User(
    id,
    email,
    pwd,
    firstName,
    lastName,
    roles,
    enabled,
    accountNonExpired,
    accountNonLocked,
    credentialsNonExpired,
    created,
    modified
)