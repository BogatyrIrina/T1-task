package org.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.annotation.PreInvoke;
import org.example.model.PlantException;
import org.example.model.RoleType;
import org.example.utils.UserContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
@Order(2)
@Slf4j
public class PreInvokeCheckerAspect {

    private static final Map<String, List<RoleType>> USERS = new HashMap<>();

    static {
        USERS.put("admin", List.of(RoleType.ADMIN, RoleType.USER));
        USERS.put("user", List.of(RoleType.USER));
    }

    @Pointcut("@annotation(preInvoke)")
    public void checkRulePointcut(PreInvoke preInvoke) {

    }

    @Before(value = "checkRulePointcut(preInvoke)", argNames = "preInvoke")
    public void before(PreInvoke preInvoke) {
        String currentUser = UserContext.getUsername();

        if (USERS.containsKey(currentUser)) {
            throw new PlantException("Пользователь не найден " + currentUser);
        }

        var roles = Arrays.stream(preInvoke.roles()).toList();
        var userRoles = USERS.get(currentUser);

        if (roles.stream().noneMatch(userRoles ::contains)) {
            throw new PlantException("Доступ запрещен! Роли: " + userRoles);
        }
    }
}
