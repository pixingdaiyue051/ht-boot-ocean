package com.tequeno.iou.service.user;

import com.tequeno.iou.pojo.sys.user.UserInfo;
import com.tequeno.iou.pojo.sys.user.UserInfoQuery;
import com.tequeno.iou.pojo.sys.user.UserModel;
import com.tequeno.iou.service.BaseService;

import java.util.function.Consumer;

public interface UserService extends BaseService<UserInfo, UserInfoQuery> {

    void addUser(UserModel userModel);

    void updateUser(UserModel userModel);

    UserInfo selectByUsername(String userName);

    String selectPasswordByUserId(Long userId);

    /**
     * 启用或禁用
     *
     * @param ids          用户id,逗号分隔
     * @param enableStatus 对应状态
     */
    void enableDisableUser(String ids, int enableStatus);

    /**
     * 物理删除用户
     *
     * @param ids 用户id,逗号分隔
     */
    void deleteUser(String ids);

    void bindPhoneOrEmail(String userName, Consumer<UserInfo> c);
}