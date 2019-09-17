package com.tequeno.config.handler;

import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.VUserRoleRes;
import com.tequeno.bootssm.service.res.ResourceService;
import com.tequeno.common.enums.HtUserErrorEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.shiro.HtPermissionAnno;
import com.tequeno.enums.HtUserResEnum;
import com.tequeno.utils.HtAssemConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Aspect
@Order(0)
public class AnnotationPermissionHandler {

    private final static Logger logger = LoggerFactory.getLogger(AnnotationPermissionHandler.class);

    @Autowired
    private ResourceService resourceService;

    @Pointcut("@annotation(com.tequeno.config.shiro.HtPermissionAnno)")
    public void permissionAspect() {
    }

    @Around("permissionAspect() && @annotation(permissionAnno) ")
    public Object doAdviceAroundPermission(ProceedingJoinPoint joinPoint, HtPermissionAnno permissionAnno) throws Throwable {
        logger.info("doAdviceAroundPermission");
        HtPermissionAnno.Logical logical = permissionAnno.logical();
        HtUserResEnum[] permissionEnums = permissionAnno.value();
        Subject user = SecurityUtils.getSubject();
        String userName = user.getPrincipal().toString();
        if (logical.equals(HtPermissionAnno.Logical.AND)) {
            // 只要有一种权限不对就拦截
            String msg = Arrays.stream(permissionEnums)
                    .map(p -> resourceService.selectResByResCode(p.getCode()))
                    .filter(r -> {
                        VUserRoleRes vUserRoleRes = resourceService.selectUserRes(userName, r.getResCode());
                        return vUserRoleRes == null || !r.getResCode().equals(vUserRoleRes.getResCode());
                    })
                    .map(ResourceInfo::getResZhName)
                    .collect(Collectors.joining(","));
            if (StringUtils.isNotEmpty(msg)) {
                msg = String.format(HtAssemConstants.NEED_ALL_PERMISSION, msg);
                return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_PERMITTED.setMsgBindReturn(msg));
            } else {
                return joinPoint.proceed();
            }
        } else {
            // 只要有一种权限就放行
            Optional<VUserRoleRes> any = Arrays.stream(permissionEnums)
                    .map(p -> resourceService.selectUserRes(userName, p.getCode()))
                    .filter(r -> null != r)
                    .findAny();
            if (any.isPresent()) {
                return joinPoint.proceed();
            } else {
                String msg = Arrays.stream(permissionEnums)
                        .map(p -> resourceService.selectResByResCode(p.getCode()).getResZhName())
                        .collect(Collectors.joining(","));
                if (permissionEnums.length > 1) {
                    msg = String.format(HtAssemConstants.NEED_ONE_LEAST_PERMISSION, msg);
                } else {
                    msg = String.format(HtAssemConstants.NEED_SPECIFIC_PERMISSION, msg);
                }
                return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_PERMITTED.setMsgBindReturn(msg));
            }
        }
    }
}