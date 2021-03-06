package com.tequeno.config.handler;

import com.tequeno.anno.HtPermissionAnno;
import com.tequeno.constants.HtZeroOneConstant;
import com.tequeno.enums.HtUserErrorEnum;
import com.tequeno.enums.HtUserResEnum;
import com.tequeno.pojo.sys.res.ResourceInfo;
import com.tequeno.pojo.sys.res.ViewUserRoleRes;
import com.tequeno.service.res.ResourceService;
import com.tequeno.utils.HtAssemConstants;
import com.tequeno.utils.HtResultInfoWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Aspect
@Order(1)
public class PermissionHandler {

    private final static Logger logger = LoggerFactory.getLogger(PermissionHandler.class);

    @Resource
    private ResourceService resourceService;

    @Pointcut("@annotation(com.tequeno.anno.HtPermissionAnno)")
    public void permissionAspect() {
    }

    @Around("permissionAspect() && @annotation(permissionAnno) ")
    public Object doAdviceAroundPermission(ProceedingJoinPoint joinPoint, HtPermissionAnno permissionAnno) throws Throwable {
        logger.debug("doAdviceAroundPermission");
        HtPermissionAnno.Logical logical = permissionAnno.logical();
        HtUserResEnum[] permissionEnums = permissionAnno.value();
        Subject user = SecurityUtils.getSubject();
        String userName = user.getPrincipal().toString();
        if (logical.equals(HtPermissionAnno.Logical.AND)) {
            // 只要有一种权限不对就拦截
            String msg = Arrays.stream(permissionEnums)
                    .map(p -> resourceService.selectResByResCode(p.getCode()))
                    .filter(r -> {
                        ViewUserRoleRes vUserRoleRes = resourceService.selectUserRes(userName, r.getResCode());
                        return vUserRoleRes == null || !r.getResCode().equals(vUserRoleRes.getResCode());
                    })
                    .map(ResourceInfo::getResZhName)
                    .collect(Collectors.joining(","));
            if (StringUtils.isNotEmpty(msg)) {
                msg = String.format(HtAssemConstants.NEED_ALL_PERMISSION, msg);
                return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_PERMITTED.build(msg));
            } else {
                return joinPoint.proceed();
            }
        } else {
            // 只要有一种权限就放行
            Optional<ViewUserRoleRes> any = Arrays.stream(permissionEnums)
                    .map(p -> resourceService.selectUserRes(userName, p.getCode()))
                    .filter(Objects::nonNull)
                    .findAny();
            if (any.isPresent()) {
                return joinPoint.proceed();
            } else {
                String msg = Arrays.stream(permissionEnums)
                        .map(p -> resourceService.selectResByResCode(p.getCode()).getResZhName())
                        .collect(Collectors.joining(","));
                if (permissionEnums.length > HtZeroOneConstant.ONE_I) {
                    msg = String.format(HtAssemConstants.NEED_ONE_LEAST_PERMISSION, msg);
                } else {
                    msg = String.format(HtAssemConstants.NEED_SPECIFIC_PERMISSION, msg);
                }
                return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_PERMITTED.build(msg));
            }
        }
    }
}