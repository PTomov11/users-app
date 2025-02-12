package com.ptomov.users_app.users;

import com.ptomov.users_app.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserDO extends BaseEntity {

    private String name;
}
